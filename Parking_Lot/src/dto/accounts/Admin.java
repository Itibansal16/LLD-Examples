package dto.accounts;

import dto.ParkingLot;

public class Admin extends Account{
    private ParkingLot parkingLot;

    public Admin() {
        this.parkingLot = ParkingLot.getInstance();
    }
}
