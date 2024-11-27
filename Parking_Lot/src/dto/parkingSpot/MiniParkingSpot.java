package dto.parkingSpot;

public class MiniParkingSpot extends ParkingSpot{

    private static int COST = 100;
    public MiniParkingSpot(Integer floor) {
        super(floor, COST);
        this.amount = COST;
    }


    @Override
    public int cost(int parkingHours) {
        return amount * parkingHours;
    }
}
