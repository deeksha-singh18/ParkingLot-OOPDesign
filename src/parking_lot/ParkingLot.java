package parking_lot;
import parking_lot.admin.Address;
import parking_lot.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ParkingLot {
    private static String name = "City Parking Lot";
    private static Address address;

    private static int compactSpotCount=0;
    private static int largeSpotCount=0;
    private static int motorbikeSpotCount=0;
    private static int handicappedSpotCount=0;
    private static int electricSpotCount=0;


    private static final int maxCompactCount;
    private static final int maxLargeCount;
    private static final int maxMotorbikeCount;
    private static final int maxHandicappedCount;
    private static final int maxElectricCount;

    private static List<ParkingFloor> parkingFloors;
    private static List<EntrancePanel> entrancePanels;
    private static List<EntrancePanel> exitPanels;

    private static ParkingLot parkingLot = null;


    static {
         maxCompactCount=2;
         maxLargeCount=3;
         maxMotorbikeCount=4;
         maxHandicappedCount=5;
         maxElectricCount=3;
    }



    private ParkingLot(){
        parkingFloors= new ArrayList<ParkingFloor>();
        entrancePanels = new ArrayList<EntrancePanel>();
        exitPanels = new ArrayList<>();
    }




    public static ParkingLot getInstance ()
    {
        if(parkingLot == null){
            parkingLot = new ParkingLot();
        }
        return parkingLot;
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


    public static List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public static List<EntrancePanel> getEntrancePanels() {
        return entrancePanels;
    }

    public static List<EntrancePanel> getExitPanels() {
        return exitPanels;
    }



    public ParkingTicket getParkingTicket(Vehicle vehicle){
        if (this.isFull(vehicle.getType())) {
            return null;
        }
        ParkingTicket ticket = new ParkingTicket();
        vehicle.assignTicket(ticket);

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

    public boolean isAllFull(){
        if((maxCompactCount+maxLargeCount+maxHandicappedCount+maxMotorbikeCount+maxElectricCount)==
                (compactSpotCount+largeSpotCount+handicappedSpotCount+electricSpotCount+motorbikeSpotCount)){

            return true;
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




    public ParkingSpotType getParkingSpotType(Vehicle vehicle){

        if(vehicle.getType()==VehicleType.CAR){
            if(compactSpotCount<maxCompactCount){
                return ParkingSpotType.COMPACT;
            }
            else{
                return ParkingSpotType.LARGE;
            }

        }



        if(vehicle.getType()==VehicleType.TRUCK || vehicle.getType()==VehicleType.VAN){
            return ParkingSpotType.LARGE;
        }


        if(vehicle.getType()==VehicleType.MOTORBIKE){
            return ParkingSpotType.MOTORBIKE;
        }

        if(vehicle.getType()==VehicleType.ELECTRIC_CAR){
            return ParkingSpotType.ELECTRIC;
        }


        return null;
    }














}
