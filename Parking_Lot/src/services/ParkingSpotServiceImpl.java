package services;

import dto.ParkingLot;
import dto.parkingSpot.ParkingSpot;
import enums.ParkingSpotEnum;
import interfaces.DisplayService;
import interfaces.ParkingSpotService;

import java.util.ArrayList;

public class ParkingSpotServiceImpl implements ParkingSpotService {
    DisplayService displayService = new DisplayServiceImpl();
    @Override
    public ParkingSpot create(ParkingSpotEnum parkingSpotEnum, Integer floor) {
        try {
            ParkingSpot parkingSpot = (ParkingSpot) parkingSpotEnum.getParkingSpot().getConstructor(Integer.class).newInstance(floor);
            ParkingLot.getInstance().getFreeParkingSpots().getOrDefault(parkingSpotEnum, new ArrayList<>()).add(parkingSpot);
            displayService.update(parkingSpotEnum, 1);
            return parkingSpot;
//        } catch (InstantiationException e) {
//            throw new RuntimeException(e);
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        } catch (InvocationTargetException e) {
//            throw new RuntimeException(e);
//        } catch (NoSuchMethodException e) {
//            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
