package ru.job4j.ood.lsp.parking;

public class CarTruckParking implements Parkingable {
    private CarParking carParking;
    private TruckParking truckParking;

    public CarTruckParking(int carSpace, int truckSpace) {
        this.carParking = new CarParking(carSpace);
        this.truckParking = new TruckParking(truckSpace);
    }

    public CarParking getCarParking() {
        return carParking;
    }

    public TruckParking getTruckParking() {
        return truckParking;
    }

    @Override
    public boolean park(Vehicle vehicle) {
        boolean rsl = false;
        if (vehicle.getSize() == 1) {
            rsl = carParking.park(vehicle);
        } else if (vehicle.getSize() > 1) {
            rsl = truckParking.park(vehicle);
            if (!rsl) {
                rsl = carParking.park(vehicle);
            }
        }
        return rsl;
    }
}
