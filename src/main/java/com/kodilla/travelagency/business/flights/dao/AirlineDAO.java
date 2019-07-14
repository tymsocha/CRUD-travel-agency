package com.kodilla.travelagency.business.flights.dao;

import com.kodilla.travelagency.business.flights.domain.Airline;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AirlineDAO extends CrudRepository<Airline, Long> {
    @Override
    List<Airline> findAll();

    @Override
    Airline save(Airline airline);

    Optional<Airline> findById(Long id);

    Optional<Airline> deleteAirlineById(Long id);

    @Override
    void deleteAll();

    @Override
    long count();

    Optional<Airline> findByAddressOrNameOrPhoneNumber(String address, String name, String phone);
}
