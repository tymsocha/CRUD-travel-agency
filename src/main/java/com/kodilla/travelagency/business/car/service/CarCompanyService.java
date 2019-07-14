package com.kodilla.travelagency.business.car.service;

import com.kodilla.travelagency.business.car.domain.CarCompany;
import com.kodilla.travelagency.business.car.dao.CarCompanyDAO;
import com.kodilla.travelagency.exceptions.CarCompanyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarCompanyService {
    @Autowired
    private CarCompanyDAO carCompanyDAO;

    public List<CarCompany> getAllCarCompanies() {
        return carCompanyDAO.findAll();
    }

    public CarCompany findCarCompanyByParameter(String parameter) throws CarCompanyNotFoundException {
        return carCompanyDAO.findByAddressOrCarCompanyNameOrPhoneNumber(parameter, parameter, parameter)
                .orElseThrow(CarCompanyNotFoundException::new);
    }

    public CarCompany saveOrUpdateCarCompany(CarCompany carCompany) {
        return carCompanyDAO.save(carCompany);
    }

    public CarCompany findCarCompanyById(Long carCompanyId) throws CarCompanyNotFoundException {
        return carCompanyDAO.findById(carCompanyId).orElseThrow(CarCompanyNotFoundException::new);
    }

    public void deleteCarCompany(Long carCompanyId) throws CarCompanyNotFoundException {
        carCompanyDAO.deleteCarCompanyById(carCompanyId).orElseThrow(CarCompanyNotFoundException::new);
    }
}
