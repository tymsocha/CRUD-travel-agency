package com.kodilla.travelagency.facades;

import com.kodilla.travelagency.business.car.api.CarTypeDTO;
import com.kodilla.travelagency.business.car.dao.CarTypeDAO;
import com.kodilla.travelagency.business.car.domain.CarType;
import com.kodilla.travelagency.business.car.facede.CarTypeFacade;
import com.kodilla.travelagency.business.car.mapper.CarTypeMapper;
import com.kodilla.travelagency.exceptions.CarTypeNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CarTypeFacadeTestSuite {
    @Autowired
    private CarTypeFacade facade;

    @Autowired
    private CarTypeDAO dao;

    @Autowired
    private CarTypeMapper mapper;
    
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
        List<CarTypeDTO> carTypes = facade.getCarTypes();
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
            CarTypeDTO foundCarType = facade.getCarType(savedCarType.getId());
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
        facade.deleteCarType(savedCarType.getId());
        List<CarTypeDTO> carTypes = facade.getCarTypes();
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
        CarTypeDTO savedCarType = facade.addCarType(mapper.mapCarTypeToCarTypeDTO(carType));
        CarTypeDTO savedCarType1 = facade.addCarType(mapper.mapCarTypeToCarTypeDTO(carType1));
        CarTypeDTO savedCarType2 = facade.addCarType(mapper.mapCarTypeToCarTypeDTO(carType2));
        CarTypeDTO savedCarType3 = facade.addCarType(mapper.mapCarTypeToCarTypeDTO(carType3));
        //When
        List<CarTypeDTO> carTypesWithAuto = facade.getCarTypesWithAutomaticTransition(false);
        //Then
        assertEquals(2, carTypesWithAuto.size());
        //CleanUp
        facade.deleteCarType(savedCarType.getId());
        facade.deleteCarType(savedCarType1.getId());
        facade.deleteCarType(savedCarType2.getId());
        facade.deleteCarType(savedCarType3.getId());
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
        CarTypeDTO savedCarType = facade.addCarType(mapper.mapCarTypeToCarTypeDTO(carType));
        CarTypeDTO savedCarType1 = facade.addCarType(mapper.mapCarTypeToCarTypeDTO(carType1));
        CarTypeDTO savedCarType2 = facade.addCarType(mapper.mapCarTypeToCarTypeDTO(carType2));
        CarTypeDTO savedCarType3 = facade.addCarType(mapper.mapCarTypeToCarTypeDTO(carType3));
        //When
        List<CarTypeDTO> carTypesWith3Doors = facade.getCarTypesByNumberOfDoors(3);
        //Then
        assertEquals(2, carTypesWith3Doors.size());
        //CleanUp
        facade.deleteCarType(savedCarType.getId());
        facade.deleteCarType(savedCarType1.getId());
        facade.deleteCarType(savedCarType2.getId());
        facade.deleteCarType(savedCarType3.getId());
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
        CarTypeDTO savedCarType = facade.addCarType(mapper.mapCarTypeToCarTypeDTO(carType));
        CarTypeDTO savedCarType1 = facade.addCarType(mapper.mapCarTypeToCarTypeDTO(carType1));
        CarTypeDTO savedCarType2 = facade.addCarType(mapper.mapCarTypeToCarTypeDTO(carType2));
        CarTypeDTO savedCarType3 = facade.addCarType(mapper.mapCarTypeToCarTypeDTO(carType3));
        //When
        List<CarTypeDTO> carTypesWithGPS = facade.getCarTypesWithGPS(true);
        //Then
        assertEquals(3, carTypesWithGPS.size());
        //CleanUp
        facade.deleteCarType(savedCarType.getId());
        facade.deleteCarType(savedCarType1.getId());
        facade.deleteCarType(savedCarType2.getId());
        facade.deleteCarType(savedCarType3.getId());
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
        CarTypeDTO savedCarType = facade.addCarType(mapper.mapCarTypeToCarTypeDTO(carType));
        CarTypeDTO savedCarType1 = facade.addCarType(mapper.mapCarTypeToCarTypeDTO(carType1));
        CarTypeDTO savedCarType2 = facade.addCarType(mapper.mapCarTypeToCarTypeDTO(carType2));
        CarTypeDTO savedCarType3 = facade.addCarType(mapper.mapCarTypeToCarTypeDTO(carType3));
        //When
        List<CarTypeDTO> carTypesWithAC = facade.getCarTypesWithAC(false);
        //Then
        assertEquals(1, carTypesWithAC.size());
        //CleanUp
        facade.deleteCarType(savedCarType.getId());
        facade.deleteCarType(savedCarType1.getId());
        facade.deleteCarType(savedCarType2.getId());
        facade.deleteCarType(savedCarType3.getId());
    }
}
