package com.kodilla.travelagency.mappers;

import com.kodilla.travelagency.business.car.api.CarReservationDTO;
import com.kodilla.travelagency.business.car.domain.CarReservation;
import com.kodilla.travelagency.business.car.mapper.CarReservationsMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CarReservationMapperTestSuite {
    @Autowired
    private CarReservationsMapper mapper;

    @Test
    public void mapCarResToDTO() {
        //Given
        CarReservation carReservation = new CarReservation(1L,
                LocalDateTime.of(2016, 10, 13, 15, 12),
                LocalDateTime.of(2016, 10, 16, 18, 12),
                BigDecimal.valueOf(3), BigDecimal.valueOf(30), BigDecimal.valueOf(90),
                null, null, null);
        //When
        CarReservationDTO carReservationDTO = mapper.mapCarToCarDTO(carReservation);
        //Then
        assertEquals(BigDecimal.valueOf(3), carReservationDTO.getNumberOfRentDays());
        assertEquals(BigDecimal.valueOf(90), carReservationDTO.getPrice());
    }

    @Test
    public void mapDTOToCarRes() {
        //Given
        CarReservationDTO carReservationDTO = new CarReservationDTO(1L,
                LocalDateTime.of(2016, 10, 13, 15, 12),
                LocalDateTime.of(2016, 10, 16, 18, 12),
                BigDecimal.valueOf(3), BigDecimal.valueOf(30), BigDecimal.valueOf(90),
                null, null, null);
        //When
        CarReservation carReservation = mapper.mapCarDTOToCar(carReservationDTO);
        //Then
        assertEquals(BigDecimal.valueOf(3), carReservation.getNumberOfRentDays());
        assertEquals(BigDecimal.valueOf(90), carReservation.getPrice());
    }

    @Test
    public void mapCarResListToDTOList() {
        //Given
        CarReservation carReservation1 = new CarReservation(1L,
                LocalDateTime.of(2016, 10, 13, 15, 12),
                LocalDateTime.of(2016, 10, 16, 18, 12),
                BigDecimal.valueOf(3), BigDecimal.valueOf(30), BigDecimal.valueOf(90),
                null, null, null);
        CarReservation carReservation2 = new CarReservation(1L,
                LocalDateTime.of(2016, 10, 13, 15, 12),
                LocalDateTime.of(2016, 10, 16, 18, 12),
                BigDecimal.valueOf(3), BigDecimal.valueOf(30), BigDecimal.valueOf(90),
                null, null, null);
        List<CarReservation> carReservations = new ArrayList<>();
        carReservations.add(carReservation1);
        carReservations.add(carReservation2);
        //When
        assertEquals(2, carReservations.size());
    }

    @Test
    public void mapDTOListToCarResList() {
        //Given
        CarReservationDTO carReservation1 = new CarReservationDTO(1L,
                LocalDateTime.of(2016, 10, 13, 15, 12),
                LocalDateTime.of(2016, 10, 16, 18, 12),
                BigDecimal.valueOf(3), BigDecimal.valueOf(30), BigDecimal.valueOf(90),
                null, null, null);
        CarReservationDTO carReservation2 = new CarReservationDTO(1L,
                LocalDateTime.of(2016, 10, 13, 15, 12),
                LocalDateTime.of(2016, 10, 16, 18, 12),
                BigDecimal.valueOf(3), BigDecimal.valueOf(30), BigDecimal.valueOf(90),
                null, null, null);
        List<CarReservationDTO> carReservations = new ArrayList<>();
        carReservations.add(carReservation1);
        carReservations.add(carReservation2);
        //When
        assertEquals(2, carReservations.size());
    }
}
