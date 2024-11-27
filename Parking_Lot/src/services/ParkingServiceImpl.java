package services;

import dto.ParkingEvent;
import dto.ParkingLot;
import dto.ParkingTicket;
import dto.exceptions.InvalidTicketException;
import dto.exceptions.SpotNotFoundException;
import dto.parkingSpot.ParkingSpot;
import dto.vehicle.Vehicle;
import enums.ParkingEventType;
import enums.ParkingSpotEnum;
import interfaces.DisplayService;
import interfaces.Observer;
import interfaces.ParkingService;
import strategy.ParkingStrategy;

import java.util.ArrayList;
import java.util.List;

public class ParkingServiceImpl implements ParkingService {

    ParkingStrategy parkingStrategy;
    ParkingLot parkingLot;
    DisplayService displayService;
    private List<Observer> observers;

    public ParkingServiceImpl(ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
        parkingLot = ParkingLot.getInstance();
        this.displayService = new DisplayServiceImpl();
        this.observers = new ArrayList<>();
    }

    @Override
    public ParkingTicket getEntryTicket(Vehicle vehicle) throws SpotNotFoundException {
        ParkingSpotEnum parkingSpotEnum = vehicle.getParkingSpotEnum();
        List<ParkingSpot> freeParkingSpots = parkingLot.getFreeParkingSpots().get(parkingSpotEnum);
        List<ParkingSpot> occupiedParkingSpots = parkingLot.getOccupiedParkingSpots().get(parkingSpotEnum);

        try {
            ParkingSpot parkingSpot = parkingStrategy.findParkingSpot(parkingSpotEnum);
            synchronized (parkingSpot) {
                if(parkingSpot.isFree()) {
                    parkingSpot.setIsFree(false);
                    freeParkingSpots.remove(parkingSpot);
                    occupiedParkingSpots.add(parkingSpot);
                    ParkingTicket parkingTicket = new ParkingTicket(vehicle, parkingSpot);
                    ParkingEvent parkingEvent = new ParkingEvent(ParkingEventType.ENTRY, parkingSpotEnum, vehicle);
                    notifyAllObservers(parkingEvent);
//                    displayService.update(parkingSpotEnum, -1);
                    System.out.println("Generating ticket: " + parkingTicket);
                    return parkingTicket;
                }
                getEntryTicket(vehicle);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("No spots available, please try with diff vehicle or come again after some time");
        }

        return null;
    }

    @Override
    public int exit(ParkingTicket parkingTicket, Vehicle vehicle) throws InvalidTicketException {
        if(!parkingTicket.getVehicle().equals(vehicle)) {
            throw new InvalidTicketException("Invalid ticket");
        }

        ParkingSpot parkingSpot = parkingTicket.getParkingSpot();
        System.out.println("Exit from: " + parkingSpot.toString());
        int amount = parkingSpot.getAmount();
        parkingSpot.setIsFree(true);
        parkingLot.getOccupiedParkingSpots().get(vehicle.getParkingSpotEnum()).remove(parkingSpot);
        sortedInsert(parkingLot.getFreeParkingSpots().get(vehicle.getParkingSpotEnum()), parkingSpot);
        ParkingEvent parkingEvent = new ParkingEvent(ParkingEventType.EXIT, vehicle.getParkingSpotEnum(), vehicle);
        notifyAllObservers(parkingEvent);
//        displayService.update(vehicle.getParkingSpotEnum(), 1);
        return amount;
    }
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void notifyAllObservers(ParkingEvent parkingEvent) {
        for(Observer observer : this.observers) {
            observer.update(parkingEvent);
        }
    }
    private void sortedInsert(List<ParkingSpot> parkingSpots, ParkingSpot parkingSpot) {
        int left = 0, right = parkingSpots.size();
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(parkingSpots.get(mid).getId() <= parkingSpot.getId()) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        parkingSpots.add(left, parkingSpot);
    }
}
