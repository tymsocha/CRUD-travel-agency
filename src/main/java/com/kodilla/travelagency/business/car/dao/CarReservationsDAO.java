package com.kodilla.travelagency.business.car.dao;

import com.kodilla.travelagency.business.car.domain.CarCompany;
import com.kodilla.travelagency.business.car.domain.CarReservation;
import com.kodilla.travelagency.business.car.domain.CarType;
import com.kodilla.travelagency.business.trip.domain.Trip;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CarReservationsDAO extends CrudRepository<CarReservation, Long> {
    @Override
    List<CarReservation> findAll();

    @Override
    CarReservation save(CarReservation carReservation);

    Optional<CarReservation> findById(Long id);

    Optional<CarReservation> deleteCarReservationById(Long id);

    @Override
    void deleteAll();

    @Override
    long count();

    List<CarReservation> findAllByCarType(CarType carType);

    List<CarReservation> findAllByCarCompany(CarCompany carCompany);

    List<CarReservation> findAllByTrip(Trip trip);

    Optional<CarReservation> findByStartRentDate(LocalDateTime localDateTime);
}
