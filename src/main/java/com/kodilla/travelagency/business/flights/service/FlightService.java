package com.kodilla.travelagency.business.flights.service;

import com.kodilla.travelagency.business.flights.dao.FlightDAO;
import com.kodilla.travelagency.business.flights.domain.Airline;
import com.kodilla.travelagency.business.flights.domain.Flight;
import com.kodilla.travelagency.business.flights.domain.Ticket;
import com.kodilla.travelagency.business.trip.domain.Trip;
import com.kodilla.travelagency.exceptions.AirlineNotFoundException;
import com.kodilla.travelagency.exceptions.FlightNotFoundException;
import com.kodilla.travelagency.exceptions.TicketNotFoundException;
import com.kodilla.travelagency.exceptions.TripNotFoundException;
import com.kodilla.travelagency.business.trip.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {
    @Autowired
    private FlightDAO dao;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TripService tripService;

    @Autowired
    private AirlineService airlineService;

    public List<Flight> getAllFlights() {
        return dao.findAll();
    }

    public Flight saveOrUpdateFlight(Flight flight) {
        return dao.save(flight);
    }

    public Flight findFlightById(Long flightId) throws FlightNotFoundException {
        return dao.findById(flightId).orElseThrow(FlightNotFoundException::new);
    }

    public void deleteFlight(Long flightId) throws FlightNotFoundException {
        dao.deleteFlightById(flightId).orElseThrow(FlightNotFoundException::new);
    }

    public List<Flight> getFlightsFromTicket(Long ticketId) throws TicketNotFoundException {
        Ticket ticket = ticketService.findTicketById(ticketId);
        List<Ticket> ticketList = new ArrayList<>();
        ticketList.add(ticket);
        return dao.getAllByTicketList(ticketList);
    }

    public List<Flight> getFlightsByAirline(Long airlineId) throws AirlineNotFoundException {
        Airline airline = airlineService.findAirlineById(airlineId);
        return dao.getAllByAirline(airline);
    }

    public List<Flight> getFlightsByOrigAndDest(String origin, String destination) {
        return dao.findAllByOriginAndDestination(origin, destination);
    }

    public List<Flight> getFlightsByDepartureDate(String departure) {
        LocalDateTime departureDate = LocalDateTime.parse(departure);
        return dao.findAllByDepartureDate(departureDate);
    }

    public List<Flight> getFlightsByArrivalDate(String arrival) {
        LocalDateTime arrivalDate = LocalDateTime.parse(arrival);
        return dao.findAllByDepartureDate(arrivalDate);
    }

    public List<Flight> getFlightsByTrip(Long tripId) throws TripNotFoundException {
        Trip trip = tripService.findTripById(tripId);
        List<Ticket> ticketList = ticketService.findTicketsByTrip(trip);
        return ticketList.stream()
                .flatMap(ticket -> ticket.getFlights().stream())
                .collect(Collectors.toList());
    }
}
