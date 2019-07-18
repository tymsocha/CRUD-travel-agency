package com.kodilla.travelagency.business.car.service;

import com.kodilla.travelagency.business.car.domain.CarType;
import com.kodilla.travelagency.business.car.dao.CarTypeDAO;
import com.kodilla.travelagency.exceptions.CarTypeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarTypeService {
    @Autowired
    private CarTypeDAO carTypeDAO;

    public List<CarType> getAllCarTypes() {
        return carTypeDAO.findAll();
    }

    public CarType saveOrUpdateCarType(CarType carType) {
        return carTypeDAO.save(carType);
    }

    public CarType findCarTypeById(Long carTypeId) throws CarTypeNotFoundException {
        return carTypeDAO.findById(carTypeId).orElseThrow(CarTypeNotFoundException::new);
    }

    public void deleteCarType(Long carTypeId)  {
        carTypeDAO.delete(carTypeId);
    }

    public List<CarType> getAllWithAutomaticTrans(Boolean isAuto) {
        return carTypeDAO.findAllByIsAutomatic(isAuto);
    }

    public List<CarType> getAllWithGPS(Boolean isGPS) {
        return carTypeDAO.findAllByWithGPS(isGPS);
    }

    public List<CarType> getAllWithAC(Boolean isAC) {
        return carTypeDAO.findAllByWithAC(isAC);
    }

    public List<CarType> getAllByNumberOfDoors(Integer numberOfDoors) {
        return carTypeDAO.findAllByNumberOfDoors(numberOfDoors);
    }

}
