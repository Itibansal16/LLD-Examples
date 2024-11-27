package dto;

import dto.vehicle.Vehicle;
import enums.ParkingEventType;
import enums.ParkingSpotEnum;

public class ParkingEvent {
    private ParkingEventType eventType;
    private ParkingSpotEnum parkingSpotEnum;
    private Vehicle vehicle;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingEvent(ParkingEventType eventType, ParkingSpotEnum parkingSpotEnum) {
        this.eventType = eventType;
        this.parkingSpotEnum = parkingSpotEnum;
    }

    public ParkingEvent(ParkingEventType eventType, ParkingSpotEnum parkingSpotEnum, Vehicle vehicle) {
        this.eventType = eventType;
        this.parkingSpotEnum = parkingSpotEnum;
        this.vehicle = vehicle;
    }

    public ParkingEventType getEventType() {
        return eventType;
    }

    public void setEventType(ParkingEventType eventType) {
        this.eventType = eventType;
    }

    public ParkingSpotEnum getParkingSpotEnum() {
        return parkingSpotEnum;
    }

    public void setParkingSpotEnum(ParkingSpotEnum parkingSpotEnum) {
        this.parkingSpotEnum = parkingSpotEnum;
    }

    @Override
    public String toString() {
        return "Vehicle " + vehicle + " has made an " + eventType + " at parking spot " + parkingSpotEnum;
    }
}
