package com.kodilla.travelagency.dao.flight;

import com.kodilla.travelagency.core.car.CarReservation;
import com.kodilla.travelagency.core.flight.Ticket;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TicketDAO extends CrudRepository<Ticket, Long> {
    @Override
    List<Ticket> findAll();

    @Override
    Ticket save(Ticket ticket);

    Optional<Ticket> findById(Long id);

    Optional<Ticket> deleteTaskById(Long id);

    @Override
    void deleteAll();

    @Override
    long count();
}
