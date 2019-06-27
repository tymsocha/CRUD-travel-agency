package com.kodilla.travelagency.dao.flight;

import com.kodilla.travelagency.core.flight.Airline;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AirlineDAO extends CrudRepository<Airline, Long> {
    @Override
    List<Airline> findAll();

    @Override
    Airline save(Airline airline);

    Optional<Airline> findById(Long id);

    Optional<Airline> deleteTaskById(Long id);

    @Override
    void deleteAll();

    @Override
    long count();
}
