package com.kodilla.travelagency.mappers;

import com.kodilla.travelagency.business.flights.api.FlightDTO;
import com.kodilla.travelagency.business.flights.domain.Flight;
import com.kodilla.travelagency.business.flights.mapper.FlightMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FlightMapperTestSuite {
    @Autowired
    private FlightMapper mapper;

    @Test
    public void mapFlightToFlightDTO() {
        //Given
        Flight flight = new Flight(1L, null, "NYC", "ORD",
                LocalDateTime.of(2016, 10, 10, 10, 10),
                LocalDateTime.of(2016, 10, 10, 15,30),
                8L, "323", null);
        //When
        FlightDTO flightDTO = mapper.mapFlightToFlightDTO(flight);
        //Then
        assertEquals("NYC", flightDTO.getOrigin());
    }

    @Test
    public void mapDTOToFlight() {
        //Given
        FlightDTO flightDTO = new FlightDTO(1L, null, "NYC", "ORD",
                LocalDateTime.of(2016, 10, 10, 10, 10),
                LocalDateTime.of(2016, 10, 10, 15,30),
                8L, "323", null);
        //When
        Flight flight = mapper.mapFlightDTOToFlight(flightDTO);
        //Then
        assertEquals("NYC", flight.getOrigin());
    }

    @Test
    public void mapFlightListToDTOList() {
        //Given
        Flight flight = new Flight(1L, null, "NYC", "ORD",
                LocalDateTime.of(2016, 10, 10, 10, 10),
                LocalDateTime.of(2016, 10, 10, 15,30),
                8L, "323", null);
        Flight flight1 = new Flight(1L, null, "LHR", "BHX",
                LocalDateTime.of(2016, 10, 10, 10, 10),
                LocalDateTime.of(2016, 10, 10, 15,30),
                1L, "323", null);
        List<Flight> flights = new ArrayList<>();
        flights.add(flight);
        flights.add(flight1);
        //When
        List<FlightDTO> flightDTOList = mapper.mapFlightListToFlightDTOList(flights);
        //Then
        assertEquals(2, flightDTOList.size());
    }

    @Test
    public void mapDTOListToFlightList() {
        //Given
        FlightDTO flightDTO = new FlightDTO(1L, null, "NYC", "ORD",
                LocalDateTime.of(2016, 10, 10, 10, 10),
                LocalDateTime.of(2016, 10, 10, 15,30),
                8L, "323", null);
        FlightDTO flightDTO1 = new FlightDTO(1L, null, "LHR", "BHX",
                LocalDateTime.of(2016, 10, 10, 10, 10),
                LocalDateTime.of(2016, 10, 10, 15,30),
                1L, "323", null);
        List<FlightDTO> flightDTOS = new ArrayList<>();
        flightDTOS.add(flightDTO);
        flightDTOS.add(flightDTO1);
        //When
        List<Flight> flightList = mapper.mapFlightDTOListToFlightList(flightDTOS);
        //Then
        assertEquals(2, flightList.size());
    }
}
