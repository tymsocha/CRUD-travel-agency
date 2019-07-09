package com.kodilla.travelagency.service.trip;

import com.kodilla.travelagency.core.trip.Trip;
import com.kodilla.travelagency.dao.trip.TripDAO;
import com.kodilla.travelagency.exceptions.TripNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {
    @Autowired
    private TripDAO tripDAO;

    public List<Trip> getAllTrips() {
        return tripDAO.findAll();
    }

    public Trip findTripByTripName(String tripName) throws TripNotFoundException {
        return tripDAO.findByTripName(tripName).orElseThrow(TripNotFoundException::new);
    }
}
