package com.iut.suprails.dao;

import com.iut.suprails.entity.Trip;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author bargenson
 */
@Local
public interface TripDao {
    
    Trip addTrip(Trip trip);
    
    List<Trip> getAllTrips();

    public Trip findTripById(Long tripId);
    
    public List<Trip> findTripByIdGare(Long arrivalStationId, Long departureStationId, String price);

    public void removeTrip(Trip findTripById);
    
}
