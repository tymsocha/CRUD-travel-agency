package com.kodilla.travelagency.services;

import com.kodilla.travelagency.business.car.dao.CarTypeDAO;
import com.kodilla.travelagency.business.car.domain.CarType;
import com.kodilla.travelagency.business.car.service.CarTypeService;
import com.kodilla.travelagency.exceptions.CarTypeNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CarTypeServiceTestSuite {
    @Autowired
    private CarTypeService service;

    @Autowired
    private CarTypeDAO dao;

    @Test
    public void shouldGetAllCarTypes() {
        //Given
        CarType carType = CarType.builder()
                .isAutomatic(true).numberOfDoors(5).withAC(true).withGPS(false).build();
        CarType carType1 = CarType.builder()
                .isAutomatic(true).numberOfDoors(3).withAC(true).withGPS(false).build();
        CarType carType2 = CarType.builder()
                .isAutomatic(true).numberOfDoors(5).withAC(true).withGPS(true).build();
        dao.save(carType);
        dao.save(carType1);
        dao.save(carType2);
        //When
        List<CarType> carTypes = service.getAllCarTypes();
        //Then
        assertEquals(3, carTypes.size());
        //CleanUp
        dao.delete(carType);
        dao.delete(carType1);
        dao.delete(carType2);
    }

    @Test
    public void shouldFindCarTypeById() {
        //Given
        CarType carType = CarType.builder()
                .isAutomatic(true).numberOfDoors(5).withAC(true).withGPS(false).build();

        CarType savedCarType = dao.save(carType);
        //When and then
        try {
            CarType foundCarType = service.findCarTypeById(savedCarType.getId());
            assertTrue(foundCarType.getIsAutomatic());
            assertTrue(foundCarType.getWithAC());
            assertFalse(foundCarType.getWithGPS());
        } catch (CarTypeNotFoundException e) {
            e.printStackTrace();
        }
        //Clean Up
        dao.delete(savedCarType);
    }

    @Test
    public void shouldDeleteCarType() {
        //Given
        CarType carType = CarType.builder()
                .isAutomatic(true).numberOfDoors(5).withAC(true).withGPS(false).build();

        CarType savedCarType = dao.save(carType);
        //When
        service.deleteCarType(savedCarType.getId());
        List<CarType> carTypes = service.getAllCarTypes();
        //Then
        assertEquals(0, carTypes.size());
    }

    @Test
    public void shouldFetchAllWithAutoTrans() {
        //Given
        CarType carType = CarType.builder()
                .isAutomatic(true).numberOfDoors(5).withAC(true).withGPS(false).build();
        CarType carType1 = CarType.builder()
                .isAutomatic(false).numberOfDoors(5).withAC(true).withGPS(false).build();
        CarType carType2 = CarType.builder()
                .isAutomatic(false).numberOfDoors(5).withAC(false).withGPS(false).build();
        CarType carType3 = CarType.builder()
                .isAutomatic(true).numberOfDoors(5).withAC(true).withGPS(false).build();
        service.saveOrUpdateCarType(carType);
        service.saveOrUpdateCarType(carType1);
        service.saveOrUpdateCarType(carType2);
        service.saveOrUpdateCarType(carType3);
        //When
        List<CarType> carTypesWithAuto = service.getAllWithAutomaticTrans(false);
        //Then
        assertEquals(2, carTypesWithAuto.size());
        //CleanUp
        service.deleteCarType(carType.getId());
        service.deleteCarType(carType1.getId());
        service.deleteCarType(carType2.getId());
        service.deleteCarType(carType3.getId());
    }

    @Test
    public void shouldFetchAllByDoorsNr() {
        //Given
        CarType carType = CarType.builder()
                .isAutomatic(true).numberOfDoors(3).withAC(true).withGPS(false).build();
        CarType carType1 = CarType.builder()
                .isAutomatic(true).numberOfDoors(3).withAC(true).withGPS(false).build();
        CarType carType2 = CarType.builder()
                .isAutomatic(true).numberOfDoors(5).withAC(false).withGPS(false).build();
        CarType carType3 = CarType.builder()
                .isAutomatic(true).numberOfDoors(5).withAC(true).withGPS(false).build();
        service.saveOrUpdateCarType(carType);
        service.saveOrUpdateCarType(carType1);
        service.saveOrUpdateCarType(carType2);
        service.saveOrUpdateCarType(carType3);
        //When
        List<CarType> carTypesWith3Doors = service.getAllByNumberOfDoors(3);
        //Then
        assertEquals(2, carTypesWith3Doors.size());
        //CleanUp
        service.deleteCarType(carType.getId());
        service.deleteCarType(carType1.getId());
        service.deleteCarType(carType2.getId());
        service.deleteCarType(carType3.getId());
    }

    @Test
    public void shouldFetchAllWithGPS() {
        //Given
        CarType carType = CarType.builder()
                .isAutomatic(true).numberOfDoors(5).withAC(true).withGPS(true).build();
        CarType carType1 = CarType.builder()
                .isAutomatic(true).numberOfDoors(5).withAC(true).withGPS(true).build();
        CarType carType2 = CarType.builder()
                .isAutomatic(true).numberOfDoors(5).withAC(false).withGPS(true).build();
        CarType carType3 = CarType.builder()
                .isAutomatic(true).numberOfDoors(5).withAC(true).withGPS(false).build();
        service.saveOrUpdateCarType(carType);
        service.saveOrUpdateCarType(carType1);
        service.saveOrUpdateCarType(carType2);
        service.saveOrUpdateCarType(carType3);
        //When
        List<CarType> carTypesWithGPS = service.getAllWithGPS(true);
        //Then
        assertEquals(3, carTypesWithGPS.size());
        //CleanUp
        service.deleteCarType(carType.getId());
        service.deleteCarType(carType1.getId());
        service.deleteCarType(carType2.getId());
        service.deleteCarType(carType3.getId());
    }

    @Test
    public void shouldFetchAllWithAC() {
        //Given
        CarType carType = CarType.builder()
                .isAutomatic(true).numberOfDoors(5).withAC(true).withGPS(false).build();
        CarType carType1 = CarType.builder()
                .isAutomatic(true).numberOfDoors(5).withAC(true).withGPS(false).build();
        CarType carType2 = CarType.builder()
                .isAutomatic(true).numberOfDoors(5).withAC(false).withGPS(false).build();
        CarType carType3 = CarType.builder()
                .isAutomatic(true).numberOfDoors(5).withAC(true).withGPS(false).build();
        service.saveOrUpdateCarType(carType);
        service.saveOrUpdateCarType(carType1);
        service.saveOrUpdateCarType(carType2);
        service.saveOrUpdateCarType(carType3);
        //When
        List<CarType> carTypesWithAC = service.getAllWithAC(false);
        //Then
        assertEquals(1, carTypesWithAC.size());
        //CleanUp
        service.deleteCarType(carType.getId());
        service.deleteCarType(carType1.getId());
        service.deleteCarType(carType2.getId());
        service.deleteCarType(carType3.getId());
    }
}
