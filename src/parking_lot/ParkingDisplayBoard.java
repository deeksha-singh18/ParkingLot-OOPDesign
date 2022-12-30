package parking_lot;

import parking_lot.parking_spot.*;

public class ParkingDisplayBoard {

    ParkingLot parkingLot;



    public boolean showParkingDisplayBoard() {
        try {
            if (parkingLot.isAllFull()) {

                System.out.println("All spots are occupied");
                return true;
            }
        }

        catch(NullPointerException e){
            return false;
        }
        return false;

    }


}