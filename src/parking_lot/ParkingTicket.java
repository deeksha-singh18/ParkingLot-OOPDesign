package parking_lot;

import parking_lot.vehicle.Vehicle;

import java.time.LocalDateTime;

public class ParkingTicket {
    private String ticketNumber;

    private String vehicle_no;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private ParkingSpot parkingSpot;
    private ParkingFloor parkingFloor_number;

    private int cost;

    private ParkingTicketStatus ticketStatus;





    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getVehicle_no() {
        return vehicle_no;
    }

    public void setVehicle_no(String vehicle_no) {
        this.vehicle_no = vehicle_no;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public ParkingFloor getParkingFloor_number() {
        return parkingFloor_number;
    }

    public void setParkingFloor_number(ParkingFloor parkingFloor_number) {
        this.parkingFloor_number = parkingFloor_number;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }


    @Override
    public String toString() {
        return "ParkingTicket{" +
                "ticketNumber='" + ticketNumber + '\'' +
                ", vehicle_no='" + vehicle_no + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", parkingSpot=" + parkingSpot +
                ", parkingFloor_number=" + parkingFloor_number +
                ", cost=" + cost +
                ", ticketStatus=" + ticketStatus +
                '}';
    }

}
