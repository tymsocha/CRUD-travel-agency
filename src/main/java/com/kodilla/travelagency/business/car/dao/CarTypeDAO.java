package com.kodilla.travelagency.business.car.dao;

import com.kodilla.travelagency.business.car.domain.CarType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CarTypeDAO extends CrudRepository<CarType, Long> {
    @Override
    List<CarType> findAll();

    @Override
    CarType save(CarType carType);

    Optional<CarType> findById(Long id);

    @Override
    void delete(Long carTypeId);

    @Override
    void deleteAll();

    @Override
    long count();

    List<CarType> findAllByIsAutomatic(Boolean isAuto);

    List<CarType> findAllByWithGPS(Boolean isGPS);

    List<CarType> findAllByWithAC(Boolean isAC);

    List<CarType> findAllByNumberOfDoors(Integer numberOfDoors);
}
