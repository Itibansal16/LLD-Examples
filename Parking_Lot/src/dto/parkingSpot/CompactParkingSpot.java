package dto.parkingSpot;

import enums.ParkingSpotEnum;

public class CompactParkingSpot extends ParkingSpot{
    private static int COST = 200;
    public CompactParkingSpot(Integer floor) {
        super(floor, COST);
        amount = COST;
    }

    @Override
    public int cost(int parkingHours) {
        return parkingHours * amount;
    }
}
