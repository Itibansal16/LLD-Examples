package services;

import dto.DisplayBoard;
import enums.ParkingSpotEnum;
import interfaces.DisplayService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisplayServiceImpl implements DisplayService {
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
    }
}
