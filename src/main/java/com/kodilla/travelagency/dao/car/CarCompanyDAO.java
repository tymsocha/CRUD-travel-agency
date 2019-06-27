package com.kodilla.travelagency.dao.car;

import com.kodilla.travelagency.core.car.CarCompany;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CarCompanyDAO extends CrudRepository<CarCompany, Long> {
    @Override
    List<CarCompany> findAll();

    @Override
    CarCompany save(CarCompany carCompany);

    Optional<CarCompany> findById(Long id);

    Optional<CarCompany> deleteTaskById(Long id);

    @Override
    void deleteAll();

    @Override
    long count();
}
