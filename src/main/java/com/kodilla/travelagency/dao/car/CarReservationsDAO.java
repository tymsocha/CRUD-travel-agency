package com.kodilla.travelagency.dao.car;

import com.kodilla.travelagency.core.car.CarReservation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CarReservationsDAO extends CrudRepository<CarReservation, Long> {
    @Override
    List<CarReservation> findAll();

    @Override
    CarReservation save(CarReservation carReservation);

    Optional<CarReservation> findById(Long id);

    Optional<CarReservation> deleteTaskById(Long id);

    @Override
    void deleteAll();

    @Override
    long count();
}
