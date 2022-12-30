package parking_lot.parking_spot;

import parking_lot.ParkingSpotType;
import parking_lot.vehicle.Vehicle;

public abstract class ParkingSpot {
    private String spotID;
    private boolean free;
    private Vehicle vehicle;
    private final ParkingSpotType spotType;



    public ParkingSpot(ParkingSpotType spotType) {
        this.spotType = spotType;
    }

    public String getSpotID() {

        return spotID;
    }

    public void setNumber(String spotID) {

        this.spotID = spotID;
    }

    public boolean isFree() {

        return free;
    }

    public void setFree(boolean free) {

        this.free = free;
    }

    public Vehicle getVehicle() {

        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {

        this.vehicle = vehicle;
    }

    public ParkingSpotType getSpotType() {

        return spotType;
    }



    public void assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        free = false;
    }

    public void removeVehicle() {
        this.vehicle = null;
        free = true;
    }



}

