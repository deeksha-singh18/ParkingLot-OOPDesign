package parking_lot;

import parking_lot.vehicle.Vehicle;

import static parking_lot.VehicleType.*;


public class ExitPanel {

        private Vehicle vehicle;
        private int cost;
        private ParkingLot parkingLot;


        public String getId(){

            return getId();
        }



        public void vacateSpot(ParkingSpot spot){
            spot.removeVehicle();
            switch (spot.getSpotType()) {
                case HANDICAPPED:
                    parkingLot.setHandicappedSpotCount(parkingLot.getHandicappedSpotCount()-1);
                    break;
                case COMPACT:
                    parkingLot.setCompactSpotCount(parkingLot.getCompactSpotCount()-1);
                    break;
                case LARGE:
                    parkingLot.setLargeSpotCount(parkingLot.getLargeSpotCount()-1);
                    break;
                case MOTORBIKE:
                    parkingLot.setMotorbikeSpotCount(parkingLot.getMotorbikeSpotCount()-1);
                    break;
                case ELECTRIC:
                    parkingLot.setElectricSpotCount(parkingLot.getElectricSpotCount()-1);
                    break;
                default:
            }


        }




        public int makePayment(Vehicle vehicle){

            if(vehicle.getType()==CAR){
                cost = 30;
            }

            if(vehicle.getType()==VAN){
                cost =40;
            }

            if(vehicle.getType()==MOTORBIKE){
                cost=20;
            }

            if(vehicle.getType()==TRUCK){
                cost=50;
            }
            return cost;
        }





}
