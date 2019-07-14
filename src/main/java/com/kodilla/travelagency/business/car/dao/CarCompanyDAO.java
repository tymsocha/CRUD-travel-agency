package com.kodilla.travelagency.business.car.dao;

import com.kodilla.travelagency.business.car.domain.CarCompany;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CarCompanyDAO extends CrudRepository<CarCompany, Long> {
    @Override
    List<CarCompany> findAll();

    @Override
    CarCompany save(CarCompany carCompany);

    Optional<CarCompany> findById(Long id);

    Optional<CarCompany> deleteCarCompanyById(Long id);

    @Override
    void deleteAll();

    @Override
    long count();

    Optional<CarCompany> findByAddressOrCarCompanyNameOrPhoneNumber(String address, String name, String number);
}
