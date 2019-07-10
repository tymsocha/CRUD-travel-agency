package com.kodilla.travelagency.service.hotel;

import com.kodilla.travelagency.core.hotel.Hotel;
import com.kodilla.travelagency.core.hotel.HotelReservation;
import com.kodilla.travelagency.core.hotel.RoomType;
import com.kodilla.travelagency.core.trip.Trip;
import com.kodilla.travelagency.dao.hotel.HotelReservationDAO;
import com.kodilla.travelagency.exceptions.HotelNotFoundException;
import com.kodilla.travelagency.exceptions.HotelReservationNotFound;
import com.kodilla.travelagency.exceptions.TripNotFoundException;
import com.kodilla.travelagency.service.trip.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelReservationService {
    @Autowired
    private HotelReservationDAO hotelReservationDAO;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private TripService tripService;

    public List<HotelReservation> getAllHotelReservations() {
        return hotelReservationDAO.findAll();
    }

    public List<HotelReservation> findHotelReservationByGuestName(String guestName) {
        return hotelReservationDAO.findAllByGuestName(guestName);
    }

    public HotelReservation createHotelReservation(HotelReservation hotelReservation) {
        return hotelReservationDAO.save(hotelReservation);
    }

    public HotelReservation findHotelReservationById(Long hotelReservationId) throws HotelReservationNotFound {
        return hotelReservationDAO.findById(hotelReservationId).orElseThrow(HotelReservationNotFound::new);
    }

    public void deleteHotelReservation(Long hotelReservationId) throws HotelReservationNotFound {
        hotelReservationDAO.deleteHotelReservationById(hotelReservationId).orElseThrow(HotelReservationNotFound::new);
    }

    public List<HotelReservation> getAllHotelReservationsByHotel(Long hotelId) throws HotelNotFoundException {
        Hotel hotel = hotelService.findHotelById(hotelId);
        return hotelReservationDAO.findAllByHotel(hotel);
    }

    public List<HotelReservation> getAllHotelReservationsByRoomType(RoomType roomType) {
        return hotelReservationDAO.findAllByRoomType(roomType);
    }

    public List<HotelReservation> getAllHotelReservationsByTrip(Long tripId) throws TripNotFoundException {
        Trip trip = tripService.findTripById(tripId);
        return hotelReservationDAO.findAllByTrip(trip);
    }

    public List<HotelReservation> getAllHotelReservationsByBreakfast(Boolean isBreakFast) {
        return hotelReservationDAO.findAllByIsBreakfast(isBreakFast);
    }
}
