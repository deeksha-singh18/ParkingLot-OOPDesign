package parking_lot;

import parking_lot.parking_spot.*;
import parking_lot.vehicle.*;
import java.util.HashMap;

import static parking_lot.ParkingSpotType.*;


public class ParkingFloor {
    private String floorName;
    private HashMap<ParkingSpotType,HashMap<String,ParkingSpot>> parkingSlots;

    private ParkingDisplayBoard displayBoard;


    public ParkingFloor(HashMap<ParkingSpotType, HashMap<String, ParkingSpot>> parkingSlots, ParkingDisplayBoard displayBoard) {
        this.parkingSlots = parkingSlots;
        this.displayBoard = displayBoard;
    }

    public ParkingFloor(String floorName) {
        this.floorName = floorName;
    }

    public void assignVehicleToSpot(Vehicle vehicle, ParkingSpot spot) {
        spot.assignVehicle(vehicle);

        incrementSpotCount (vehicleType){

        }

    }



    public void removeVehicleFromSpot(ParkingSpot spot){
        spot.removeVehicle();

        decrementSpotCount(spot){

        }


    }


















}
