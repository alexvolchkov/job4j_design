package ru.job4j.ood.lsp.parking;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ParkingableTest {

    @Test
    public void whenParkingCar() {
        CarTruckParking carTruckParking = new CarTruckParking(4, 3);
        assertTrue(carTruckParking.park(new Car(1)));
        assertThat(carTruckParking.getCarParking().getFreeSpace(), is(3));
        assertThat(carTruckParking.getTruckParking().getFreeSpace(), is(3));
    }

    @Test
    public void whenNotParkingCar() {
        CarTruckParking carTruckParking = new CarTruckParking(1, 3);
        carTruckParking.park(new Car(1));
        assertFalse(carTruckParking.park(new Car(1)));
    }

    @Test
    public void whenParkingTruck() {
        CarTruckParking carTruckParking = new CarTruckParking(4, 3);
        assertTrue(carTruckParking.park(new Truck(2)));
        assertThat(carTruckParking.getCarParking().getFreeSpace(), is(4));
        assertThat(carTruckParking.getTruckParking().getFreeSpace(), is(2));
    }

    @Test
    public void whenParkingTruckOnCarSpace() {
        CarTruckParking carTruckParking = new CarTruckParking(4, 1);
        carTruckParking.park(new Truck(2));
        assertTrue(carTruckParking.park(new Truck(2)));
        assertThat(carTruckParking.getCarParking().getFreeSpace(), is(2));
        assertThat(carTruckParking.getTruckParking().getFreeSpace(), is(0));
    }

    @Test
    public void whenNotParkingTruck() {
        CarTruckParking carTruckParking = new CarTruckParking(1, 1);
        carTruckParking.park(new Truck(2));
        assertFalse(carTruckParking.park(new Truck(2)));
    }
}