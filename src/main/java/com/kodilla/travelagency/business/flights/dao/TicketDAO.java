package com.kodilla.travelagency.business.flights.dao;

import com.kodilla.travelagency.business.flights.domain.Airline;
import com.kodilla.travelagency.business.flights.domain.Ticket;
import com.kodilla.travelagency.business.trip.domain.Trip;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TicketDAO extends CrudRepository<Ticket, Long> {
    @Override
    List<Ticket> findAll();

    @Override
    Ticket save(Ticket ticket);

    Optional<Ticket> findById(Long id);

    Optional<Ticket> deleteTicketById(Long id);

    @Override
    void deleteAll();

    @Override
    long count();

    List<Ticket> findAllByTrip(Trip trip);

    List<Ticket> findAllByFirstNameOrLastName(String firstName, String lastName);

    List<Ticket> findAllByTripAndAirline(Trip trip, Airline airline);

    List<Ticket> findAllByAirline(Airline airline);
}
