package com.kodilla.travelagency.business.flights.service;

import com.kodilla.travelagency.business.flights.dao.TicketDAO;
import com.kodilla.travelagency.business.flights.domain.Airline;
import com.kodilla.travelagency.business.flights.domain.Ticket;
import com.kodilla.travelagency.business.trip.domain.Trip;
import com.kodilla.travelagency.exceptions.AirlineNotFoundException;
import com.kodilla.travelagency.exceptions.TicketNotFoundException;
import com.kodilla.travelagency.exceptions.TripNotFoundException;
import com.kodilla.travelagency.business.trip.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketDAO dao;

    @Autowired
    private AirlineService airlineService;

    @Autowired
    private TripService tripService;

    public List<Ticket> getAllTickets() {
        return dao.findAll();
    }

    public Ticket saveOrUpdateTicket(Ticket ticket) {
        return dao.save(ticket);
    }

    public void deleteTicket(Long flightId) throws TicketNotFoundException {
        dao.deleteTicketById(flightId).orElseThrow(TicketNotFoundException::new);
    }

    public Ticket findTicketById(Long ticketId) throws TicketNotFoundException {
        return dao.findById(ticketId).orElseThrow(TicketNotFoundException::new);
    }

    public List<Ticket> findTicketsByTrip(Trip trip) {
        return dao.findAllByTrip(trip);
    }

    public List<Ticket> getTicketsByLastOrFirstName(String firstName, String lastName) {
        return dao.findAllByFirstNameOrLastName(firstName, lastName);
    }

    public List<Ticket> getAllByTripAndAirline(Long tripId, Long airlineId) throws TripNotFoundException, AirlineNotFoundException {
        Trip trip = tripService.findTripById(tripId);
        Airline airline = airlineService.findAirlineById(airlineId);
        return dao.findAllByTripAndAirline(trip, airline);
    }

    public List<Ticket> getAllByAirline(Long airlineId)  throws AirlineNotFoundException {
        Airline airline = airlineService.findAirlineById(airlineId);
        return dao.findAllByAirline(airline);
    }
}
