package com.kodilla.travelagency.business.flights.controller;

import com.kodilla.travelagency.business.flights.api.FlightDTO;
import com.kodilla.travelagency.business.flights.mapper.FlightMapper;
import com.kodilla.travelagency.business.flights.service.FlightService;
import com.kodilla.travelagency.business.flights.api.FlightsAndDestApi;
import com.kodilla.travelagency.exceptions.AirlineNotFoundException;
import com.kodilla.travelagency.exceptions.FlightNotFoundException;
import com.kodilla.travelagency.exceptions.TicketNotFoundException;
import com.kodilla.travelagency.exceptions.TripNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Api(tags = "Flights")
@CrossOrigin(origins = "*")
@RestController
@Transactional
@RequestMapping("v1/travel/flights")
public class FlightController {
    @Autowired
    private FlightService service;
    
    @Autowired
    private FlightMapper mapper;

    @ApiOperation(value = "Get All Flights")
    @GetMapping(value = "getAll")
    public List<FlightDTO> getFlights() {
        return mapper.mapFlightListToFlightDTOList(service.getAllFlights());
    }

    @ApiOperation(value = "Get Flight By Id")
    @GetMapping(value = "get/{flightId}")
    public FlightDTO getFlight(@PathVariable Long flightId) throws FlightNotFoundException {
        return mapper.mapFlightToFlightDTO(service.findFlightById(flightId));
    }

    @ApiOperation(value = "Add Flight to Base")
    @PostMapping(value = "add", consumes = APPLICATION_JSON_VALUE)
    public FlightDTO addFlight(@RequestBody FlightDTO flightDTO) {
        return mapper.mapFlightToFlightDTO(service.saveOrUpdateFlight(mapper.mapFlightDTOToFlight(flightDTO)));
    }

    @ApiOperation(value = "Update Flight Details")
    @PutMapping(value = "update", consumes = APPLICATION_JSON_VALUE)
    public FlightDTO updateFlight(@RequestBody FlightDTO flightDTO) {
        return mapper.mapFlightToFlightDTO(service.saveOrUpdateFlight(mapper.mapFlightDTOToFlight(flightDTO)));
    }

    @ApiOperation(value = "Delete Flight")
    @DeleteMapping(value = "delete/{flightId}")
    public void deleteHotel(@PathVariable Long flightId) throws FlightNotFoundException {
        service.deleteFlight(flightId);
    }

    @ApiOperation(value = "Get All Flights in a Trip")
    @GetMapping(value = "getAll/{tripId}")
    public List<FlightDTO> getFlightsByTrip(@PathVariable Long tripId) throws TripNotFoundException {
        return mapper.mapFlightListToFlightDTOList(service.getFlightsByTrip(tripId));
    }

    @ApiOperation(value = "Get All Flights in a Ticket")
    @GetMapping(value = "getAll/ticket/{ticketId}")
    public List<FlightDTO> getFlightsByTicket(@PathVariable Long ticketId) throws TicketNotFoundException {
        return mapper.mapFlightListToFlightDTOList(service.getFlightsFromTicket(ticketId));
    }

    @ApiOperation(value = "Get All Flights from Place To Place")
    @GetMapping(value = "getAll/orgAndDest")
    public List<FlightDTO> getFlightsByOriginAndDestination(@RequestBody FlightsAndDestApi api) {
        return mapper.mapFlightListToFlightDTOList(service.getFlightsByOrigAndDest(api.getOrigin(), api.getDestination()));
    }

    @ApiOperation(value = "Get All Flights Operated By Airline")
    @GetMapping(value = "getAll/airline/{airlineId}")
    public List<FlightDTO> getFlightsByAirline(@PathVariable Long airlineId) throws AirlineNotFoundException {
        return mapper.mapFlightListToFlightDTOList(service.getFlightsByAirline(airlineId));
    }

    @ApiOperation(value = "Get All Flights By Departure Date")
    @GetMapping(value = "getAll/departure")
    public List<FlightDTO> getFlightsByDeparture(@RequestBody FlightsAndDestApi api) {
        return mapper.mapFlightListToFlightDTOList(service.getFlightsByDepartureDate(api.getDepartureDate()));
    }

    @ApiOperation(value = "Get All Flights By Arrival Date")
    @GetMapping(value = "getAll/arrival")
    public List<FlightDTO> getFlightsByArrival(@RequestBody FlightsAndDestApi api) {
        return mapper.mapFlightListToFlightDTOList(service.getFlightsByArrivalDate(api.getArrivalDate()));
    }
}
