package services;

import dto.ParkingEvent;
import interfaces.Observer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerService implements Observer {
    Logger logger = Logger.getLogger("logger");
    @Override
    public void update(ParkingEvent event) {

        logger.log(Level.INFO, "NEW ACTIVITY: " + event);
//        logger.log(Level.INFO, "Vehicle " + event.getVehicle().getName() + " has made an " + event.getEventType() +
//                " at parking spot: " + event.getParkingSpotEnum());
    }
}
