package com.kodilla.travelagency.dao.hotel;

import com.kodilla.travelagency.core.hotel.Hotel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface HotelDAO extends CrudRepository<Hotel, Long> {
    @Override
    List<Hotel> findAll();

    @Override
    Hotel save(Hotel hotel);

    Optional<Hotel> findById(Long id);

    Optional<Hotel> deleteTaskById(Long id);

    @Override
    void deleteAll();

    @Override
    long count();
}
