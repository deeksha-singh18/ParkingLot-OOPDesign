package parking_lot;

import parking_lot.vehicle.Vehicle;

import static parking_lot.VehicleType.*;


public class ExitPanel {

        private String id;


        public String getId(){
            return getId();
        }


        public int makePayment(Vehicle vehicle){
            int cost=0;

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


        public static class EntrancePanel {


        }
}
