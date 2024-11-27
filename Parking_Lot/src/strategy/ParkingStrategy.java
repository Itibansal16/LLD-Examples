package strategy;

import dto.exceptions.SpotNotFoundException;
import dto.parkingSpot.ParkingSpot;
import enums.ParkingSpotEnum;

public interface ParkingStrategy {
    ParkingSpot findParkingSpot(ParkingSpotEnum parkingSpotEnum) throws SpotNotFoundException;
}
