package ru.job4j.ood.lsp.parking;

import java.util.HashMap;
import java.util.Map;

public class CarParking implements Parkingable {
    private int space;
    private int freeSpace;
    private Map<Vehicle, Integer> parking = new HashMap<>();

    public CarParking(int space) {
        this.space = space;
        this.freeSpace = space;
    }

    public int getSpace() {
        return space;
    }

    public int getFreeSpace() {
        return freeSpace;
    }

    public Map<Vehicle, Integer> getParking() {
        return parking;
    }

    @Override
    public boolean park(Vehicle vehicle) {
        boolean rsl = false;
        if (freeSpace - vehicle.getSize() >= 0) {
            freeSpace -= vehicle.getSize();
            parking.put(vehicle, vehicle.getSize());
            rsl = true;
        }
        return rsl;
    }
}
