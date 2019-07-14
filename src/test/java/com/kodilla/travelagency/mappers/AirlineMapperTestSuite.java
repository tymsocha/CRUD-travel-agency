package com.kodilla.travelagency.mappers;

import com.kodilla.travelagency.business.flights.api.AirlineDTO;
import com.kodilla.travelagency.business.flights.domain.Airline;
import com.kodilla.travelagency.business.flights.mapper.AirlineMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AirlineMapperTestSuite {
    @Autowired
    private AirlineMapper mapper;

    @Test
    public void testMapAirlineToDTO() {
        //Given
        Airline airline = new Airline(1L, "Lufthansa", "Frankfurt", "123456789");
        //When
        AirlineDTO dto = mapper.mapAirlineToAirlineDTO(airline);
        //Then
        assertEquals(1L, dto.getId(), 0.001);
        assertEquals("Lufthansa", dto.getName());
        assertEquals("Frankfurt", dto.getAddress());
        assertEquals("123456789", dto.getPhoneNumber());
    }

    @Test
    public void testMapDTOToAirline() {
        //Given
        AirlineDTO airlineDTO = new AirlineDTO(1L, "Lufthansa", "Frankfurt", "123456789");
        //When
        Airline airline = mapper.mapAirlineDTOToAirline(airlineDTO);
        //Then
        assertEquals(1L, airline.getId(), 0.001);
        assertEquals("Lufthansa", airline.getName());
        assertEquals("Frankfurt", airline.getAddress());
        assertEquals("123456789", airline.getPhoneNumber());
    }

    @Test
    public void testMapAirlineListToDTOList() {
        //Given
        Airline lh = new Airline(1L, "Lufthansa", "Frankfurt", "123456789");
        Airline aa = new Airline(2L, "American Airlines", "Chicago", "987654321");
        Airline ba = new Airline(3L, "British Airways", "London", "987456321");
        List<Airline> airlines = new ArrayList<>();
        airlines.add(lh);
        airlines.add(aa);
        airlines.add(ba);
        //When
        List<AirlineDTO> airlineDTOS = mapper.mapAirlineListToAirlineDTOList(airlines);
        //Then
        assertEquals(3, airlineDTOS.size());
        assertEquals("Lufthansa", airlineDTOS.get(0).getName());
        assertEquals("American Airlines", airlineDTOS.get(1).getName());
        assertEquals("British Airways", airlineDTOS.get(2).getName());
    }

    @Test
    public void testMapAirlineDTOListToAirlineList() {
        //Given
        AirlineDTO lh = new AirlineDTO(1L, "Lufthansa", "Frankfurt", "123456789");
        AirlineDTO aa = new AirlineDTO(2L, "American Airlines", "Chicago", "987654321");
        AirlineDTO ba = new AirlineDTO(3L, "British Airways", "London", "987456321");
        List<AirlineDTO> airlineDTOS = new ArrayList<>();
        airlineDTOS.add(lh);
        airlineDTOS.add(aa);
        airlineDTOS.add(ba);
        //When
        List<Airline> airlines = mapper.mapAirlineDTOListToAirlineList(airlineDTOS);
        //Then
        assertEquals(3, airlines.size());
        assertEquals("Lufthansa", airlines.get(0).getName());
        assertEquals("American Airlines", airlines.get(1).getName());
        assertEquals("British Airways", airlines.get(2).getName());
    }
}
