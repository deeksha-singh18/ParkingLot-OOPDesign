package parking_lot;

import parking_lot.parking_spot.*;
import parking_lot.vehicle.*;

import java.util.ArrayList;
import java.util.HashMap;

import static parking_lot.ParkingSpotType.*;


public class ParkingFloor {
    private static String floorName;
    private static ParkingLot parkingLot;
    static HashMap<ParkingSpotType, HashMap<VehicleType, String>> parkingSlots;
    Vehicle vehicle;

    public static HashMap<ParkingSpotType, HashMap<VehicleType, String>> getParkingSlots() {

        return parkingSlots;
    }


    private VehicleType vehicleType;


    public ParkingFloor(VehicleType vehicleType) {

        this.vehicleType = vehicleType;
    }



    public ParkingFloor(String floorName) {

        this.floorName = floorName;
    }



    public void floor() {
        parkingSlots.put(COMPACT, new HashMap<VehicleType, String>());
        parkingSlots.put(MOTORBIKE, new HashMap<VehicleType, String>());
        parkingSlots.put(ELECTRIC, new HashMap<VehicleType, String>());
        parkingSlots.put(HANDICAPPED, new HashMap<VehicleType, String>());
        parkingSlots.put(LARGE, new HashMap<VehicleType, String>());
    }


    public void parkVehicleToSpot() {
        ParkingSpotType parkingSpotType = parkingLot.getParkingSpotType(vehicle);

        parkingSlots.get(parkingSpotType).put(vehicle.getType(), vehicle.getLicenseNumber());


    }


    public void vacateVehicleFromSpot() {

        parkingSlots.get(parkingLot.getParkingSpotType(vehicle)).remove(vehicle.getType());

    }

}















