package com.kodilla.travelagency.business.trip.dao;

import com.kodilla.travelagency.business.trip.domain.Trip;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TripDAO extends CrudRepository<Trip, Long> {
    @Override
    List<Trip> findAll();

    @Override
    Trip save(Trip trip);

    Optional<Trip> findById(Long id);

    Optional<Trip> deleteTripById(Long id);

    Optional<Trip> findByTripName(String tripName);

    @Override
    void deleteAll();

    @Override
    long count();
}
