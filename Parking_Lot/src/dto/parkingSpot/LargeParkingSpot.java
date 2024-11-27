package dto.parkingSpot;

import enums.ParkingSpotEnum;

public class LargeParkingSpot extends ParkingSpot{
    private static int COST = 300;
    public LargeParkingSpot(Integer floor) {
        super(floor, COST);
        amount = COST;
    }

    @Override
    public int cost(int parkingHours) {
        return parkingHours * amount;
    }
}
