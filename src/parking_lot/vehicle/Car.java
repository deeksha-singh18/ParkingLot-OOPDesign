package parking_lot.vehicle;

import parking_lot.VehicleType;

public class Car extends Vehicle {
    public Car(String licenseNumber, VehicleType type) {
        super(licenseNumber, VehicleType.CAR);
    }
}
