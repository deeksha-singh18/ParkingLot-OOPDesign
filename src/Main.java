import parking_lot.*;
import parking_lot.vehicle.Vehicle;

import java.util.Scanner;



public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to City ParkingLot");

        System.out.println("Choose the option \n 1.Park the vehicle \n 2.Leave the parkinglot");

        int option = sc.nextInt();
        if(option==1) {

            System.out.println("Enter the vehicle type : ");
            VehicleType vehicle_type = VehicleType.valueOf(sc.next());


            ParkingLot obj = ParkingLot.getInstance();
            ParkingDisplayBoard displayBoard = new ParkingDisplayBoard();


            if (displayBoard.showParkingDisplayBoard()) {
                return;
            }
            else {

                if (obj.isFull(VehicleType.valueOf(String.valueOf(vehicle_type)))) {
                    System.out.println("Spots are not available for this vehicle");

                } else {
                    System.out.println("Parking Spots are available, you can park");

                    System.out.println("Enter the vehicle number: ");

                    String vehicle_no = sc.next();

                    Vehicle vehicle = new Vehicle(vehicle_no,vehicle_type);


                    System.out.println("Generated Ticket  is : " + System.currentTimeMillis());

                    obj.incrementSpotCount(vehicle_type);

                    System.out.println("Parking details :-");

                    System.out.println("Parking floor : A");
                    System.out.println("Parking Spot type : " + obj.getParkingSpotType(vehicle));
                    System.out.println("Spot no : c11");


                }


            }
        }

    }
















}