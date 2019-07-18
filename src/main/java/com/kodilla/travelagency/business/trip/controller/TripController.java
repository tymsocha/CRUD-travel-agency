package com.kodilla.travelagency.business.trip.controller;


import com.kodilla.travelagency.business.car.api.CarReservationDTO;
import com.kodilla.travelagency.business.flights.api.FlightDTO;
import com.kodilla.travelagency.business.flights.api.TicketDTO;
import com.kodilla.travelagency.business.hotel.api.HotelReservationDTO;
import com.kodilla.travelagency.business.trip.api.TripDTO;
import com.kodilla.travelagency.business.trip.facede.TripFacade;
import com.kodilla.travelagency.exceptions.TripNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Api(tags = "Trips")
@CrossOrigin(origins = "*")
@RestController
@Transactional
@RequestMapping("/v1/travel/trips")
public class TripController {
    @Autowired
    private TripFacade facade;

    @ApiOperation(value = "Get All Trips")
    @GetMapping(value = "getAll")
    public List<TripDTO> getTrips() {
        return facade.getTrips();
    }

    @ApiOperation(value = "Get Trip by Id")
    @GetMapping(value = "get/{tripId}")
    public TripDTO getTrip(@PathVariable Long tripId) throws TripNotFoundException {
        return facade.getTrip(tripId);
    }

    @ApiOperation(value = "Get Trip by Name")
    @GetMapping(value = "get/{tripName}")
    public TripDTO getTrip(@PathVariable String tripName) throws TripNotFoundException {
        return facade.getTrip(tripName);
    }

    @ApiOperation(value = "Create Trip")
    @PostMapping(value = "create", consumes = APPLICATION_JSON_VALUE)
    public TripDTO createTrip(@RequestBody TripDTO tripDTO) {
        return facade.createTrip(tripDTO);
    }

    @ApiOperation(value = "Update Trip")
    @PutMapping(value = "update", consumes = APPLICATION_JSON_VALUE)
    public TripDTO updateTrip(@RequestBody TripDTO tripDTO) {
        return facade.updateTrip(tripDTO);
    }

    @ApiOperation(value = "Delete Trip")
    @DeleteMapping(value = "delete/{tripId}")
    public void deleteTrip(@PathVariable Long tripId) throws TripNotFoundException {
        facade.deleteTrip(tripId);
    }

    @ApiOperation(value = "Get All Hotels")
    @GetMapping(value = "get/{tripId}/hotels")
    public List<HotelReservationDTO> getHotelReservations(@PathVariable Long tripId) throws TripNotFoundException {
        return facade.getHotelReservations(tripId);
    }

    @ApiOperation(value = "Get All Cars")
    @GetMapping(value = "get/{tripId}/cars")
    public List<CarReservationDTO> getCarReservations(@PathVariable Long tripId) throws TripNotFoundException {
        return facade.getCarReservations(tripId);
    }

    @ApiOperation(value = "Get All Flights")
    @GetMapping(value = "get/{tripId}/flights")
    public List<FlightDTO> getFlights(@PathVariable Long tripId) throws TripNotFoundException {
        return facade.getFlights(tripId);
    }

    @ApiOperation(value = "Get All Tickets")
    @GetMapping(value = "get/{tripId}/tickets")
    public List<TicketDTO> getTickets(@PathVariable Long tripId) throws TripNotFoundException {
        return facade.getTickets(tripId);
    }
}
