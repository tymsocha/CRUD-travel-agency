package com.kodilla.travelagency.business.hotel.dao;

import com.kodilla.travelagency.business.hotel.RoomType;
import com.kodilla.travelagency.business.hotel.domain.Hotel;
import com.kodilla.travelagency.business.hotel.domain.HotelReservation;
import com.kodilla.travelagency.business.trip.domain.Trip;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface HotelReservationDAO extends CrudRepository<HotelReservation, Long> {
    @Override
    List<HotelReservation> findAll();

    @Override
    HotelReservation save(HotelReservation hotelReservation);

    Optional<HotelReservation> findById(Long id);

    Optional<HotelReservation> deleteHotelReservationById(Long id);

    @Override
    void deleteAll();

    @Override
    long count();

    List<HotelReservation> findAllByGuestName(String guestName);

    List<HotelReservation> findAllByHotel(Hotel hotel);

    List<HotelReservation> findAllByIsBreakfast(Boolean isBreakfast);

    List<HotelReservation> findAllByTrip(Trip trip);

    List<HotelReservation> findAllByRoomType(RoomType roomType);


}
