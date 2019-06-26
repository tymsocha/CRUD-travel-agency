package com.kodilla.travelagency.dao.hotel;

import com.kodilla.travelagency.core.hotel.HotelReservation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface HotelReservationDAO extends CrudRepository<HotelReservation, Long> {
    @Override
    List<HotelReservation> findAll();

    @Override
    HotelReservation save(HotelReservation hotelReservation);

    Optional<HotelReservation> findById(Long id);

    Optional<HotelReservation> deleteTaskById(Long id);

    @Override
    void deleteAll();

    @Override
    long count();
}
