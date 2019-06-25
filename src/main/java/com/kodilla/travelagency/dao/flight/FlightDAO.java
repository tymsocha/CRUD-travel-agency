package com.kodilla.travelagency.dao.flight;

import com.kodilla.travelagency.core.flight.Flight;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface FlightDAO extends CrudRepository<Flight, Long> {
    @Override
    List<Flight> findAll();

    @Override
    Flight save(Flight flight);

    Optional<Flight> findById(Long id);

    Optional<Flight> deleteTaskById(Long id);

    @Override
    void deleteAll();

    @Override
    long count();
}
