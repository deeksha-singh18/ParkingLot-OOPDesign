package parking_lot.vehicle;

import parking_lot.ParkingTicket;
import parking_lot.VehicleType;

public class Vehicle {

    private String licenseNumber;
    private final VehicleType type;
    private ParkingTicket ticket;


    public Vehicle(String licenseNumber,VehicleType type) {
        this.licenseNumber=licenseNumber;
        this.type = type;
    }

    public void assignTicket(ParkingTicket ticket) {

        this.ticket = ticket;
    }


    public String getLicenseNumber() {

        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {

        this.licenseNumber = licenseNumber;
    }

    public VehicleType getType() {

        return type;
    }

    public ParkingTicket getTicket() {

        return ticket;
    }

    public void setTicket(ParkingTicket ticket) {

        this.ticket = ticket;
    }
}
