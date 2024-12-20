package services;

import dto.DisplayBoard;
import dto.ParkingEvent;
import enums.ParkingSpotEnum;
import interfaces.DisplayService;
import interfaces.Observer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisplayServiceImpl implements DisplayService, Observer {
    @Override
    public void update(ParkingSpotEnum parkingSpotEnum, int change) {
        Map<ParkingSpotEnum, Integer> currentState = DisplayBoard.getInstance().getFreeParkingSpots();
        currentState.put(parkingSpotEnum, currentState.getOrDefault(parkingSpotEnum, 0) + change);

    }

    @Override
    public void display() {
        DisplayBoard displayBoard = DisplayBoard.getInstance();
        System.out.println("--------------------DISPLAY BOARD---------------------");
        System.out.println("Parking Spot type  ||  Number of free spots");
        System.out.println(ParkingSpotEnum.MINI + "  ||  " + displayBoard.getFreeParkingSpots().get(ParkingSpotEnum.MINI));
        System.out.println(ParkingSpotEnum.COMPACT + "  ||  " + displayBoard.getFreeParkingSpots().get(ParkingSpotEnum.COMPACT));
        System.out.println(ParkingSpotEnum.LARGE + "  ||  " + displayBoard.getFreeParkingSpots().get(ParkingSpotEnum.LARGE));
        System.out.println("--------------------***********---------------------");
    }

    @Override
    public void update(ParkingEvent event) {
        int currentCount = DisplayBoard.getInstance().getFreeParkingSpots().get(event.getParkingSpotEnum());
        int newCount = currentCount + event.getEventType().getChange();
        DisplayBoard.getInstance().getFreeParkingSpots().replace(event.getParkingSpotEnum(), newCount);
        this.display();
    }
}
