package dto.parkingSpot.spotDecorator;

import dto.parkingSpot.ParkingSpot;

public class WashspotDecorator extends SpotDecorator{
    public WashspotDecorator(ParkingSpot parkingSpot) {
        super(parkingSpot);
    }

    @Override
    public int cost(int parkingHours) {
        return parkingSpot.cost(parkingHours) + 20;
    }
}
