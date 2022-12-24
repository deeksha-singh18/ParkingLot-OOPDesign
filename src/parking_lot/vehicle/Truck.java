package parking_lot.vehicle;

import parking_lot.VehicleType;

public class Truck extends Vehicle{
    public Truck(String licenseNumber, VehicleType type) {
        super(licenseNumber, VehicleType.TRUCK);
    }
}
