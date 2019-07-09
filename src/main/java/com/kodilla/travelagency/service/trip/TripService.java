package com.kodilla.travelagency.service.trip;

import com.kodilla.travelagency.core.car.CarReservation;
import com.kodilla.travelagency.core.flight.Flight;
import com.kodilla.travelagency.core.flight.Ticket;
import com.kodilla.travelagency.core.hotel.HotelReservation;
import com.kodilla.travelagency.core.trip.Trip;
import com.kodilla.travelagency.dao.trip.TripDAO;
import com.kodilla.travelagency.exceptions.TripNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public Trip saveTrip(Trip trip) {
        return tripDAO.save(trip);
    }

    public Trip findTripById(Long tripId) throws TripNotFoundException {
        return tripDAO.findById(tripId).orElseThrow(TripNotFoundException::new);
    }

    public void deleteTrip(Long tripId) throws TripNotFoundException {
        tripDAO.deleteTripById(tripId).orElseThrow(TripNotFoundException::new);
    }

    public List<HotelReservation> getAllHotelReservationInTrip(Long tripId) throws TripNotFoundException {
        Trip trip = findTripById(tripId);
        return trip.getHotelReservations();
    }

    public List<CarReservation> getAllCarReservationInTrip(Long tripId) throws TripNotFoundException {
        Trip trip = findTripById(tripId);
        return trip.getCarReservations();
    }

    public List<Ticket> getAllTicketsInTrip(Long tripId) throws TripNotFoundException {
        Trip trip = findTripById(tripId);
        return trip.getTickets();
    }

    public List<Flight> getAllFlightsInTrip(Long tripId) throws TripNotFoundException {
        Trip trip = findTripById(tripId);
        return trip.getTickets().stream()
                .flatMap(ticket -> ticket.getFlights().stream())
                .collect(Collectors.toList());
    }
}
