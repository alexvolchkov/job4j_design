package ru.job4j.ood.lsp.parking;

import java.util.HashMap;
import java.util.Map;

public class TruckParking implements Parkingable {
    private int space;
    private int freeSpace;
    private Map<Vehicle, Integer> parking = new HashMap<>();

    public TruckParking(int space) {
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
        if (freeSpace - 1 >= 0) {
            freeSpace--;
            parking.put(vehicle, 1);
            rsl = true;
        }
        return rsl;
    }
}
