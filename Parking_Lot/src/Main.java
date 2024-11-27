import dto.DisplayBoard;
import dto.ParkingTicket;
import dto.exceptions.InvalidTicketException;
import dto.exceptions.SpotNotFoundException;
import dto.parkingSpot.ParkingSpot;
import dto.vehicle.Car;
import dto.vehicle.MotorBike;
import dto.vehicle.Truck;
import dto.vehicle.Vehicle;
import enums.ParkingSpotEnum;
import interfaces.DisplayService;
import interfaces.ParkingService;
import interfaces.ParkingSpotService;
import services.DisplayServiceImpl;
import services.LoggerService;
import services.ParkingServiceImpl;
import services.ParkingSpotServiceImpl;
import strategy.NearestFirstParkingStrategy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ParkingSpotService parkingSpotService = new ParkingSpotServiceImpl();
        DisplayService displayService = new DisplayServiceImpl();
        parkingSpotService.create(ParkingSpotEnum.MINI, 1);
        parkingSpotService.create(ParkingSpotEnum.MINI, 2);
        parkingSpotService.create(ParkingSpotEnum.MINI, 1);
        parkingSpotService.create(ParkingSpotEnum.MINI, 2);
        parkingSpotService.create(ParkingSpotEnum.MINI, 1);
        parkingSpotService.create(ParkingSpotEnum.MINI, 2);

        parkingSpotService.create(ParkingSpotEnum.COMPACT, 1);
        parkingSpotService.create(ParkingSpotEnum.COMPACT, 2);
        parkingSpotService.create(ParkingSpotEnum.COMPACT, 1);
        parkingSpotService.create(ParkingSpotEnum.COMPACT, 2);
        parkingSpotService.create(ParkingSpotEnum.COMPACT, 1);
        parkingSpotService.create(ParkingSpotEnum.COMPACT, 2);

        parkingSpotService.create(ParkingSpotEnum.LARGE, 1);
        parkingSpotService.create(ParkingSpotEnum.LARGE, 2);

        Vehicle car1 = new Car();
        Vehicle car2 = new Car();
        Vehicle car3 = new Car();
        Vehicle car4 = new Car();
        ParkingServiceImpl parkingService = new ParkingServiceImpl(new NearestFirstParkingStrategy());

        parkingService.addObserver(new LoggerService());
        parkingService.addObserver(new DisplayServiceImpl());
        try {
            ParkingTicket ticket1 = parkingService.getEntryTicket(car1);
            ParkingTicket ticket2 = parkingService.getEntryTicket(car2);
            ParkingTicket ticket3 = parkingService.getEntryTicket(car3);
            ParkingTicket ticket4 = parkingService.getEntryTicket(car4);

            parkingService.exit(ticket3, car3);
            ParkingTicket ticket = parkingService.getEntryTicket(car3);
            ParkingTicket ticketo = parkingService.getEntryTicket(car3);
            ParkingTicket ticketk = parkingService.getEntryTicket(car3);
            ParkingTicket ticketkl = parkingService.getEntryTicket(car3);
            ParkingTicket ticketklp = parkingService.getEntryTicket(car3);

            displayService.display();
        } catch (SpotNotFoundException e) {
            System.out.println("error while generating ticket");
            throw new RuntimeException(e);
        } catch (InvalidTicketException e) {
            throw new RuntimeException(e);
        }
    }
}