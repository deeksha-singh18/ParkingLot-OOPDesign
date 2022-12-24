package parking_lot;
import parking_lot.admin.Address;
import parking_lot.vehicle.Vehicle;

import java.util.HashMap;


public class ParkingLot {
    private String name;
    private Address address;

    private static int compactSpotCount=0;
    private static int largeSpotCount=0;
    private static int motorbikeSpotCount=0;
    private static int handicappedSpotCount=0;
    private static int electricSpotCount=0;


    private final int maxCompactCount;
    private final int maxLargeCount;
    private final int maxMotorbikeCount;
    private final int maxHandicappedCount;
    private final int maxElectricCount;

    private HashMap<String, ParkingFloor> parkingFloors;
    private HashMap<String,EntrancePanel> entrancePanels;
    private HashMap<String,ExitPanel> exitPanels;

    private static ParkingLot parkingLot = null;


    public ParkingLot(String name, Address address, int maxCompactCount, int maxLargeCount, int maxMotorbikeCount, int maxHandicappedCount, int maxElectricCount, HashMap<String, ParkingFloor> parkingFloors) {
        this.name = name;
        this.address = address;
        this.maxCompactCount = maxCompactCount;
        this.maxLargeCount = maxLargeCount;
        this.maxMotorbikeCount = maxMotorbikeCount;
        this.maxHandicappedCount=maxHandicappedCount;
        this.maxElectricCount = maxElectricCount;
        this.parkingFloors = parkingFloors;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getCompactSpotCount() {
        return compactSpotCount;
    }

    public void setCompactSpotCount(int compactSpotCount) {
        this.compactSpotCount = compactSpotCount;
    }

    public int getLargeSpotCount() {
        return largeSpotCount;
    }

    public void setLargeSpotCount(int largeSpotCount) {
        this.largeSpotCount = largeSpotCount;
    }

    public int getMotorbikeSpotCount() {
        return motorbikeSpotCount;
    }

    public void setMotorbikeSpotCount(int motorbikeSpotCount) {
        this.motorbikeSpotCount = motorbikeSpotCount;
    }

    public int getHandicappedSpotCount() {
        return handicappedSpotCount;
    }

    public void setHandicappedSpotCount(int handicappedSpotCount) {
        this.handicappedSpotCount = handicappedSpotCount;
    }

    public int getElectricSpotCount() {
        return electricSpotCount;
    }

    public void setElectricSpotCount(int electricSpotCount) {
        this.electricSpotCount = electricSpotCount;
    }

    public int getMaxCompactCount() {
        return maxCompactCount;
    }

    public int getMaxLargeCount() {
        return maxLargeCount;
    }

    public int getMaxMotorbikeCount() {
        return maxMotorbikeCount;
    }

    public int getMaxHandicappedCount() {
        return maxHandicappedCount;
    }

    public int getMaxElectricCount() {
        return maxElectricCount;
    }



    public HashMap<String, ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }






    public ParkingTicket getParkingTicket(Vehicle vehicle){
        if (this.isFull(vehicle.getType())) {
            return null;
        }
        ParkingTicket ticket = new ParkingTicket();
        vehicle.assignTicket(ticket);
        this.incrementSpotCount(vehicle.getType());

        return ticket;
    }


    public boolean isFull(VehicleType type) {
        if (type == VehicleType.TRUCK || type == VehicleType.VAN) {
            return largeSpotCount >= maxLargeCount;
        }

        if (type == VehicleType.MOTORBIKE) {
            return motorbikeSpotCount >= maxMotorbikeCount;
        }

        if (type == VehicleType.CAR) {
            return (compactSpotCount + largeSpotCount) >= (maxCompactCount + maxLargeCount);
        }

        if(type== VehicleType.ELECTRIC_CAR){
            return (electricSpotCount + compactSpotCount + largeSpotCount >=maxElectricCount + maxLargeCount + maxCompactCount);
        }


        return false;

    }




    public void incrementSpotCount(VehicleType type) {
        if (type == VehicleType.TRUCK || type == VehicleType.VAN) {
            largeSpotCount++;
        } else if (type == VehicleType.MOTORBIKE) {
            motorbikeSpotCount++;
        } else if (type == VehicleType.CAR) {
            if (compactSpotCount < maxCompactCount) {
                compactSpotCount++;
            } else {
                largeSpotCount++;
            }
        }
        else { // electric car
            if (electricSpotCount < maxElectricCount) {
                electricSpotCount++;
            } else if (compactSpotCount < maxCompactCount) {
                compactSpotCount++;
            } else {
                largeSpotCount++;
            }
        }
    }



    public void decrementSpotCount(ParkingSpot spot){
        spot.removeVehicle();
        switch (spot.getSpotType()) {
            case HANDICAPPED:
                handicappedSpotCount--;
                break;
            case COMPACT:
                compactSpotCount--;
                break;
            case LARGE:
                largeSpotCount--;
                break;
            case MOTORBIKE:
                motorbikeSpotCount--;
                break;
            case ELECTRIC:
                electricSpotCount--;
                break;
            default:
        }
    }





    public void addParkingFloor(String floorName,ParkingFloor floor) {

        parkingFloors.put(floorName,floor);
    }

    public void removeParkingFloor(String floorName) {

        parkingFloors.remove(floorName);
    }






}
