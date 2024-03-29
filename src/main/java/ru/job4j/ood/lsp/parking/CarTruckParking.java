package ru.job4j.ood.lsp.parking;

import java.util.HashMap;
import java.util.Map;

public class CarTruckParking implements Parkingable {
    private int carSpace;
    private int truckSpace;
    private int freeCarSpace;
    private int freeTruckSpace;
    private Map<Vehicle, Integer> parking = new HashMap<>();

    public CarTruckParking(int carSpace, int truckSpace) {
        this.carSpace = carSpace;
        this.freeCarSpace = carSpace;
        this.truckSpace = truckSpace;
        this.freeTruckSpace = truckSpace;
    }

    public int getCarSpace() {
        return carSpace;
    }

    public int getTruckSpace() {
        return truckSpace;
    }

    public int getFreeCarSpace() {
        return freeCarSpace;
    }

    public int getFreeTruckSpace() {
        return freeTruckSpace;
    }

    public Map<Vehicle, Integer> getParking() {
        return new HashMap<>(parking);
    }

    @Override
    public boolean park(Vehicle vehicle) {
        boolean rsl = false;
        if (vehicle.getSize() > Car.CAR_SIZE && freeTruckSpace > 0) {
            parking.put(vehicle, vehicle.getSize());
            freeTruckSpace--;
            rsl = true;
        } else if (freeCarSpace >= vehicle.getSize()) {
            parking.put(vehicle, vehicle.getSize());
            freeCarSpace -= vehicle.getSize();
            rsl = true;
        }
        return rsl;
    }
}
