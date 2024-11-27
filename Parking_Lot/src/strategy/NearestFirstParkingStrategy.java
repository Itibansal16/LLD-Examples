package strategy;

import dto.ParkingLot;
import dto.exceptions.SpotNotFoundException;
import dto.parkingSpot.ParkingSpot;
import enums.ParkingSpotEnum;

import java.util.List;

public class NearestFirstParkingStrategy implements ParkingStrategy{
    @Override
    public ParkingSpot findParkingSpot(ParkingSpotEnum parkingSpotEnum) throws SpotNotFoundException {
        List<ParkingSpot> parkingSpots = ParkingLot.getInstance().getFreeParkingSpots().get(parkingSpotEnum);
        if(parkingSpots.size() == 0) {
            throw new SpotNotFoundException("spots not found in nearest first strategy");
        }

        return parkingSpots.get(0);
    }
}
