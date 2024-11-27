package dto;

import enums.ParkingSpotEnum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DisplayBoard {
    private static DisplayBoard displayBoard = null;
    private Map<ParkingSpotEnum, Integer> freeParkingSpots;

    private DisplayBoard() {
        this.freeParkingSpots = new HashMap<>();
    }

    public static DisplayBoard getInstance() {
        if(Objects.isNull(displayBoard)) {
            displayBoard = new DisplayBoard();
        }
        return displayBoard;
    }

    public Map<ParkingSpotEnum, Integer> getFreeParkingSpots() {
        return freeParkingSpots;
    }
}
