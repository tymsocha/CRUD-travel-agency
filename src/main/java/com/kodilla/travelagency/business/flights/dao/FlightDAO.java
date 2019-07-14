package com.kodilla.travelagency.business.flights.dao;

import com.kodilla.travelagency.business.flights.domain.Airline;
import com.kodilla.travelagency.business.flights.domain.Flight;
import com.kodilla.travelagency.business.flights.domain.Ticket;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FlightDAO extends CrudRepository<Flight, Long> {
    @Override
    List<Flight> findAll();

    @Override
    Flight save(Flight flight);

    Optional<Flight> findById(Long id);

    Optional<Flight> deleteFlightById(Long id);

    @Override
    void deleteAll();

    @Override
    long count();

    List<Flight> getAllByTicketList(List<Ticket> tickets);

    List<Flight> getAllByAirline(Airline airline);

    List<Flight> findAllByOriginAndDestination(String origin, String destination);

    List<Flight> findAllByDepartureDate(LocalDateTime departure);
}
