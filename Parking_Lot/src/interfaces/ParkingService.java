package interfaces;

import dto.ParkingTicket;
import dto.exceptions.InvalidTicketException;
import dto.exceptions.SpotNotFoundException;
import dto.vehicle.Vehicle;

public interface ParkingService {
    ParkingTicket getEntryTicket(Vehicle vehicle) throws SpotNotFoundException;
    int exit(ParkingTicket parkingTicket, Vehicle vehicle) throws InvalidTicketException;
}
