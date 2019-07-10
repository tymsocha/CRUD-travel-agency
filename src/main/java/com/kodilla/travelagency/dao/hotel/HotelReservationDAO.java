package com.kodilla.travelagency.dao.hotel;

import com.kodilla.travelagency.core.hotel.Hotel;
import com.kodilla.travelagency.core.hotel.HotelReservation;
import com.kodilla.travelagency.core.hotel.RoomType;
import com.kodilla.travelagency.core.trip.Trip;
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
