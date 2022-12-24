package parking_lot;

import parking_lot.vehicle.Vehicle;

public abstract class ParkingSpot {
    private String spotName;
    private boolean free;
    private Vehicle vehicle;
    private final ParkingSpotType spotType;



    public ParkingSpot(ParkingSpotType spotType) {
        this.spotName=spotName;
        this.spotType = spotType;
    }

    public String getSpotName() {

        return spotName;
    }

    public void setNumber(String spotNamer) {

        this.spotName = spotName;
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

