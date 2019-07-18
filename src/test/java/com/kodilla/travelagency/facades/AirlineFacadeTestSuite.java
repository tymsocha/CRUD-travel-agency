package com.kodilla.travelagency.facades;

import com.kodilla.travelagency.business.flights.api.AirlineDTO;
import com.kodilla.travelagency.business.flights.dao.AirlineDAO;
import com.kodilla.travelagency.business.flights.domain.Airline;
import com.kodilla.travelagency.business.flights.facede.AirlineFacade;
import com.kodilla.travelagency.exceptions.AirlineNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AirlineFacadeTestSuite {
    @Autowired
    private AirlineFacade facade;

    @Autowired
    private AirlineDAO dao;

    @Test
    public void shouldGetAllAirlines() {
        //Given
        Airline airline = Airline.builder().name("LH").address("FRA").phoneNumber("123").build();
        Airline airline1 = Airline.builder().name("LO").address("WAW").phoneNumber("456").build();
        Airline airline2 = Airline.builder().name("BA").address("LON").phoneNumber("789").build();
        dao.save(airline);
        dao.save(airline1);
        dao.save(airline2);
        //When
        List<AirlineDTO> airlines = facade.getAirlines();
        //Then
        assertEquals(3, airlines.size());
        //CleanUp
        dao.delete(airline);
        dao.delete(airline1);
        dao.delete(airline2);
    }

    @Test
    public void shouldFindAirlineById() {
        //Given
        Airline airline = Airline.builder().name("LH").address("FRA").phoneNumber("123").build();
        Airline savedAirline = dao.save(airline);
        //When and then
        try {
            AirlineDTO foundAirline = facade.getAirline(savedAirline.getId());
            assertEquals("LH", foundAirline.getName());
            assertEquals("FRA", foundAirline.getAddress());
            assertEquals("123", foundAirline.getPhoneNumber());
        } catch (AirlineNotFoundException e) {
            e.printStackTrace();
        }
        //Clean Up
        dao.delete(savedAirline);
    }

    @Test
    public void shouldDeleteAirline() {
        //Given
        Airline airline = Airline.builder().name("LH").address("FRA").phoneNumber("123").build();
        Airline savedAirline = dao.save(airline);
        //When
        facade.deleteAirline(savedAirline.getId());
        List<AirlineDTO> airlines = facade.getAirlines();
        //Then
        assertEquals(0, airlines.size());
    }
}
