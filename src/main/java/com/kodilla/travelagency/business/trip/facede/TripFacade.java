package com.kodilla.travelagency.business.trip.facede;

import com.kodilla.travelagency.business.car.api.CarReservationDTO;
import com.kodilla.travelagency.business.car.mapper.CarReservationsMapper;
import com.kodilla.travelagency.business.flights.api.FlightDTO;
import com.kodilla.travelagency.business.flights.api.TicketDTO;
import com.kodilla.travelagency.business.flights.mapper.FlightMapper;
import com.kodilla.travelagency.business.flights.mapper.TicketMapper;
import com.kodilla.travelagency.business.hotel.api.HotelReservationDTO;
import com.kodilla.travelagency.business.hotel.mapper.HotelReservationMapper;
import com.kodilla.travelagency.business.trip.api.TripDTO;
import com.kodilla.travelagency.business.trip.mapper.TripMapper;
import com.kodilla.travelagency.business.trip.service.TripService;
import com.kodilla.travelagency.exceptions.TripNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TripFacade {
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

    public List<TripDTO> getTrips() {
        return tripMapper.mapTripListToTripDTOList(tripService.getAllTrips());
    }

    public TripDTO getTrip(Long tripId) throws TripNotFoundException {
        return tripMapper.mapTripToTripDTO(tripService.findTripById(tripId));
    }

    public TripDTO getTrip(String tripName) throws TripNotFoundException {
        return tripMapper.mapTripToTripDTO(tripService.findTripByTripName(tripName));
    }

    public TripDTO createTrip(TripDTO tripDTO) {
        return tripMapper.mapTripToTripDTO(tripService.saveOrUpdateTrip(tripMapper.mapTripDTOToTrip(tripDTO)));
    }

    public TripDTO updateTrip(TripDTO tripDTO) {
        tripService.saveOrUpdateTrip(tripMapper.mapTripDTOToTrip(tripDTO));
        return tripDTO;
    }

    public void deleteTrip(Long tripId) throws TripNotFoundException {
        tripService.deleteTrip(tripId);
    }

    public List<HotelReservationDTO> getHotelReservations(Long tripId) throws TripNotFoundException {
        return  hotelReservationMapper.mapHotleListToHotelDTOList(
                tripService.getAllHotelReservationInTrip(tripId));
    }

    public List<CarReservationDTO> getCarReservations(Long tripId) throws TripNotFoundException {
        return carReservationsMapper.mapCarListToCarDTOList(
                tripService.getAllCarReservationInTrip(tripId));
    }

    public List<FlightDTO> getFlights(Long tripId) throws TripNotFoundException {
        return flightMapper.mapFlightListToFlightDTOList(tripService.getAllFlightsInTrip(tripId));
    }

    public List<TicketDTO> getTickets(Long tripId) throws TripNotFoundException {
        return ticketMapper.mapTicketListToTicketDTOList(tripService.getAllTicketsInTrip(tripId));
    }
}
