package com.kodilla.travelagency.dao.trip;

import com.kodilla.travelagency.core.trip.Trip;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TripDAO extends CrudRepository<Trip, Long> {
    @Override
    List<Trip> findAll();

    @Override
    Trip save(Trip trip);

    Optional<Trip> findById(Long id);

    Optional<Trip> deleteTaskById(Long id);

    @Override
    void deleteAll();

    @Override
    long count();
}
