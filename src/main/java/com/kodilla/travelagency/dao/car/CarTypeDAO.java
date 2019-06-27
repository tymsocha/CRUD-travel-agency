package com.kodilla.travelagency.dao.car;

import com.kodilla.travelagency.core.car.CarType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CarTypeDAO extends CrudRepository<CarType, Long> {
    @Override
    List<CarType> findAll();

    @Override
    CarType save(CarType carType);

    Optional<CarType> findById(Long id);

    Optional<CarType> deleteTaskById(Long id);

    @Override
    void deleteAll();

    @Override
    long count();
}
