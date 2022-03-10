package ru.job4j.ood.lsp.parking;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ParkingableTest {

    @Test
    @Ignore
    public void whenParkingCar() {
        CarTruckParking carTruckParking = new CarTruckParking(4, 3);
        assertTrue(carTruckParking.park(new Car()));
        assertThat(carTruckParking.getFreeCarSpace(), is(3));
        assertThat(carTruckParking.getFreeTruckSpace(), is(3));
    }

    @Test
    @Ignore
    public void whenNotParkingCar() {
        CarTruckParking carTruckParking = new CarTruckParking(1, 3);
        carTruckParking.park(new Car());
        assertFalse(carTruckParking.park(new Car()));
    }

    @Test
    @Ignore
    public void whenParkingTruck() {
        CarTruckParking carTruckParking = new CarTruckParking(4, 3);
        assertTrue(carTruckParking.park(new Truck(2)));
        assertThat(carTruckParking.getFreeCarSpace(), is(4));
        assertThat(carTruckParking.getFreeTruckSpace(), is(2));
    }

    @Test
    @Ignore
    public void whenParkingTruckOnCarSpace() {
        CarTruckParking carTruckParking = new CarTruckParking(4, 1);
        carTruckParking.park(new Truck(2));
        assertTrue(carTruckParking.park(new Truck(2)));
        assertThat(carTruckParking.getFreeCarSpace(), is(2));
        assertThat(carTruckParking.getFreeTruckSpace(), is(0));
    }

    @Test
    @Ignore
    public void whenNotParkingTruck() {
        CarTruckParking carTruckParking = new CarTruckParking(1, 1);
        carTruckParking.park(new Truck(2));
        assertFalse(carTruckParking.park(new Truck(2)));
    }
}