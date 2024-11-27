package dto;

import dto.parkingSpot.ParkingSpot;
import enums.ParkingSpotEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ParkingLot {
    private String name;
    private List<EntryPanel> entrances;
    private List<ExitPanel> exits;
    private DisplayBoard displayBoard;
    private Map<ParkingSpotEnum, List<ParkingSpot>> freeParkingSpots;
    private Map<ParkingSpotEnum, List<ParkingSpot>> occupiedParkingSpots;

    private static ParkingLot parkingLot = null;
    private ParkingLot(String name) {
        this.name = name;
        entrances = new ArrayList<>();
        exits = new ArrayList<>();
        displayBoard = DisplayBoard.getInstance();
        freeParkingSpots = new HashMap<>();
        occupiedParkingSpots = new HashMap<>();
        ParkingSpotEnum[] parkingSpotEnums = ParkingSpotEnum.values();
        for(ParkingSpotEnum parkingSpotEnum : parkingSpotEnums) {
            freeParkingSpots.put(parkingSpotEnum, new ArrayList<>());
            occupiedParkingSpots.put(parkingSpotEnum, new ArrayList<>());
        }
    }

    public static ParkingLot getInstance() {
        if(Objects.isNull(parkingLot)) {
            parkingLot = new ParkingLot("PARKING LOT 1");
        }
        return parkingLot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EntryPanel> getEntrances() {
        return entrances;
    }

    public void setEntrances(List<EntryPanel> entrances) {
        this.entrances = entrances;
    }

    public List<ExitPanel> getExits() {
        return exits;
    }

    public void setExits(List<ExitPanel> exits) {
        this.exits = exits;
    }

    public DisplayBoard getDisplayBoard() {
        return displayBoard;
    }

    public void setDisplayBoard(DisplayBoard displayBoard) {
        this.displayBoard = displayBoard;
    }

    public Map<ParkingSpotEnum, List<ParkingSpot>> getFreeParkingSpots() {
        return freeParkingSpots;
    }

    public void setFreeParkingSpots(Map<ParkingSpotEnum, List<ParkingSpot>> freeParkingSpots) {
        this.freeParkingSpots = freeParkingSpots;
    }

    public Map<ParkingSpotEnum, List<ParkingSpot>> getOccupiedParkingSpots() {
        return occupiedParkingSpots;
    }

    public void setOccupiedParkingSpots(Map<ParkingSpotEnum, List<ParkingSpot>> occupiedParkingSpots) {
        this.occupiedParkingSpots = occupiedParkingSpots;
    }
}
