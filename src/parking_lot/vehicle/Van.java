package parking_lot.vehicle;

import parking_lot.VehicleType;

public class Van extends Vehicle{
    public Van(String licenseNumber, VehicleType type) {
        super(licenseNumber, VehicleType.VAN);
    }
}
