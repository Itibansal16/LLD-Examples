package enums;

import dto.parkingSpot.CompactParkingSpot;
import dto.parkingSpot.LargeParkingSpot;
import dto.parkingSpot.MiniParkingSpot;

public enum ParkingSpotEnum {
    COMPACT(CompactParkingSpot.class),
    MINI(MiniParkingSpot.class),
    LARGE(LargeParkingSpot.class);

    private Class parkingSpot;
    ParkingSpotEnum(Class parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public Class getParkingSpot() {
        return this.parkingSpot;
    }
}
