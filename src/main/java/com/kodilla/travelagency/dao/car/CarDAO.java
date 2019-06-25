package com.kodilla.travelagency.dao.car;

import com.kodilla.travelagency.core.car.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CarDAO extends CrudRepository<Car, Long> {
    @Override
    List<Car> findAll();

    @Override
    Car save(Car car);

    Optional<Car> findById(Long id);

    Optional<Car> deleteTaskById(Long id);

    @Override
    void deleteAll();

    @Override
    long count();
}
