package com.kodilla.travelagency.business.flights.facede;

import com.kodilla.travelagency.business.flights.api.FlightDTO;
import com.kodilla.travelagency.business.flights.api.FlightsAndDestApi;
import com.kodilla.travelagency.business.flights.mapper.FlightMapper;
import com.kodilla.travelagency.business.flights.service.FlightService;
import com.kodilla.travelagency.exceptions.AirlineNotFoundException;
import com.kodilla.travelagency.exceptions.FlightNotFoundException;
import com.kodilla.travelagency.exceptions.TicketNotFoundException;
import com.kodilla.travelagency.exceptions.TripNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlightFacade {
    @Autowired
    private FlightService service;

    @Autowired
    private FlightMapper mapper;

    public List<FlightDTO> getFlights() {
        return mapper.mapFlightListToFlightDTOList(service.getAllFlights());
    }

    public FlightDTO getFlight(Long flightId) throws FlightNotFoundException {
        return mapper.mapFlightToFlightDTO(service.findFlightById(flightId));
    }

    public FlightDTO addFlight(FlightDTO flightDTO) {
        return mapper.mapFlightToFlightDTO(service.saveOrUpdateFlight(mapper.mapFlightDTOToFlight(flightDTO)));
    }

    public FlightDTO updateFlight(FlightDTO flightDTO) {
        return mapper.mapFlightToFlightDTO(service.saveOrUpdateFlight(mapper.mapFlightDTOToFlight(flightDTO)));
    }

    public void deleteHotel(Long flightId) throws FlightNotFoundException {
        service.deleteFlight(flightId);
    }

    public List<FlightDTO> getFlightsByTrip(Long tripId) throws TripNotFoundException {
        return mapper.mapFlightListToFlightDTOList(service.getFlightsByTrip(tripId));
    }

    public List<FlightDTO> getFlightsByTicket(Long ticketId) throws TicketNotFoundException {
        return mapper.mapFlightListToFlightDTOList(service.getFlightsFromTicket(ticketId));
    }

    public List<FlightDTO> getFlightsByOriginAndDestination(FlightsAndDestApi api) {
        return mapper.mapFlightListToFlightDTOList(service.getFlightsByOrigAndDest(api.getOrigin(), api.getDestination()));
    }

    public List<FlightDTO> getFlightsByAirline(Long airlineId) throws AirlineNotFoundException {
        return mapper.mapFlightListToFlightDTOList(service.getFlightsByAirline(airlineId));
    }

    public List<FlightDTO> getFlightsByDeparture(FlightsAndDestApi api) {
        return mapper.mapFlightListToFlightDTOList(service.getFlightsByDepartureDate(api.getDepartureDate()));
    }

    public List<FlightDTO> getFlightsByArrival(FlightsAndDestApi api) {
        return mapper.mapFlightListToFlightDTOList(service.getFlightsByArrivalDate(api.getArrivalDate()));
    }
}
