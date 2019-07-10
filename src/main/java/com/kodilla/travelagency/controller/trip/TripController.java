package com.kodilla.travelagency.controller.trip;


import com.kodilla.travelagency.api.car.CarReservationDTO;
import com.kodilla.travelagency.api.flight.FlightDTO;
import com.kodilla.travelagency.api.flight.TicketDTO;
import com.kodilla.travelagency.api.hotel.HotelReservationDTO;
import com.kodilla.travelagency.api.trip.TripDTO;
import com.kodilla.travelagency.exceptions.TripNotFoundException;
import com.kodilla.travelagency.mapper.car.CarReservationsMapper;
import com.kodilla.travelagency.mapper.flight.FlightMapper;
import com.kodilla.travelagency.mapper.flight.TicketMapper;
import com.kodilla.travelagency.mapper.hotel.HotelReservationMapper;
import com.kodilla.travelagency.mapper.trip.TripMapper;
import com.kodilla.travelagency.service.trip.TripService;
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
    private TripService tripService;

    @Autowired
    private TripMapper tripMapper;

    @Autowired
    private HotelReservationMapper hotelReservationMapper;

    @Autowired
    private CarReservationsMapper carReservationsMapper;

    @Autowired
    private TicketMapper ticketMapper;

    @Autowired
    private FlightMapper flightMapper;

    @ApiOperation(value = "Get All Trips")
    @GetMapping(value = "getTrips")
    public List<TripDTO> getTrips() {
        return tripMapper.mapTripListToTripDTOList(tripService.getAllTrips());
    }

    @ApiOperation(value = "Get Trip by Id")
    @GetMapping(value = "getTrip/{tripId}")
    public TripDTO getTrip(@PathVariable Long tripId) throws TripNotFoundException {
        return tripMapper.mapTripToTripDTO(tripService.findTripById(tripId));
    }

    @ApiOperation(value = "Get Trip by Name")
    @GetMapping(value = "getTrip/{tripName}")
    public TripDTO getTrip(@PathVariable String tripName) throws TripNotFoundException {
        return tripMapper.mapTripToTripDTO(tripService.findTripByTripName(tripName));
    }

    @ApiOperation(value = "Save Trip")
    @PostMapping(value = "saveTrip", consumes = APPLICATION_JSON_VALUE)
    public TripDTO saveTrip(@RequestBody TripDTO tripDTO) {
        return tripMapper.mapTripToTripDTO(tripService.saveTrip(tripMapper.mapTripDTOToTrip(tripDTO)));
    }

    @ApiOperation(value = "Update Trip")
    @PutMapping(value = "updateTrip", consumes = APPLICATION_JSON_VALUE)
    public TripDTO updateTrip(@RequestBody TripDTO tripDTO) {
        tripService.saveTrip(tripMapper.mapTripDTOToTrip(tripDTO));
        return tripDTO;
    }

    @ApiOperation(value = "Delete Trip")
    @DeleteMapping(value = "deleteTrip/{tripId}")
    public void deleteTrip(@PathVariable Long tripId) throws TripNotFoundException {
        tripService.deleteTrip(tripId);
    }

    @ApiOperation(value = "Get All Hotels")
    @GetMapping(value = "getTrip/{tripId}/hotels")
    public List<HotelReservationDTO> getHotelReservations(@PathVariable Long tripId) throws TripNotFoundException {
        return  hotelReservationMapper.mapHotleListToHotelDTOList(
                tripService.getAllHotelReservationInTrip(tripId));
    }

    @ApiOperation(value = "Get All Cars")
    @GetMapping(value = "getTrip/{tripId}/cars")
    public List<CarReservationDTO> getCarReservations(@PathVariable Long tripId) throws TripNotFoundException {
        return carReservationsMapper.mapCarListToCarDTOList(
                tripService.getAllCarReservationInTrip(tripId));
    }

    @ApiOperation(value = "Get All Flights")
    @GetMapping(value = "getTrip/{tripId}/flights")
    public List<FlightDTO> getFlights(@PathVariable Long tripId) throws TripNotFoundException {
        return flightMapper.mapFlightListToFlightDTOList(tripService.getAllFlightsInTrip(tripId));
    }

    @ApiOperation(value = "Get All Tickets")
    @GetMapping(value = "getTrip/{tripId}/tickets")
    public List<TicketDTO> getTickets(@PathVariable Long tripId) throws TripNotFoundException {
        return ticketMapper.mapTicketListToTicketDTOList(tripService.getAllTicketsInTrip(tripId));
    }
}
