package com.kodilla.travelagency.mappers;

import com.kodilla.travelagency.business.car.api.CarTypeDTO;
import com.kodilla.travelagency.business.car.domain.CarType;
import com.kodilla.travelagency.business.car.mapper.CarTypeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CarTypeMapperTestSuite {
    @Autowired
    private CarTypeMapper mapper;

    @Test
    public void mapCarTypeToDTO() {
        //Given
        CarType carType = new CarType(1L, true, 3, true, true);
        //When
        CarTypeDTO carTypeDTO = mapper.mapCarTypeToCarTypeDTO(carType);
        //Then
        assertTrue(carTypeDTO.getIsAutomatic());
        assertTrue(carType.getWithAC());
        assertTrue(carType.getWithGPS());
    }

    @Test
    public void mapDTOToCarType() {
        //Given
        CarTypeDTO carTypeDTO = new CarTypeDTO(1L, true, 3, true, true);
        //When
        CarType carType = mapper.mapCarTypeDTOToCarType(carTypeDTO);
        //Then
        assertTrue(carType.getIsAutomatic());
        assertTrue(carType.getWithAC());
        assertTrue(carType.getWithGPS());
    }

    @Test
    public void mapCarTypeDTOListToCarTypeList() {
        //Given
        CarTypeDTO carTypeDTO = new CarTypeDTO(1L, true, 3, true, true);
        CarTypeDTO carTypeDTO1 = new CarTypeDTO(1L, true, 3, true, true);
        CarTypeDTO carTypeDTO2 = new CarTypeDTO(1L, true, 3, true, true);
        List<CarTypeDTO> carTypeDTOS = new ArrayList<>();
        carTypeDTOS.add(carTypeDTO);
        carTypeDTOS.add(carTypeDTO1);
        carTypeDTOS.add(carTypeDTO2);
        //When
        List<CarType> carTypes = mapper.mapDTOListToCarTypeList(carTypeDTOS);
        //Then
        assertEquals(3, carTypeDTOS.size());
    }

    @Test
    public void mapCarTypeListToCarTypeDTOList() {
        //Given
        CarType carType = new CarType(1L, true, 3, true, true);
        CarType carType1 = new CarType(1L, true, 3, true, true);
        CarType carType2 = new CarType(1L, true, 3, true, true);
        List<CarType> carTypes = new ArrayList<>();
        carTypes.add(carType);
        carTypes.add(carType1);
        carTypes.add(carType2);
        //When
        List<CarTypeDTO> carTypeDTOS = mapper.mapCarTypeListToDTOList(carTypes);
        //Then
        assertEquals(3, carTypes.size());
    }
}
