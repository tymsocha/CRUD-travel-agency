package com.kodilla.travelagency.services;

import com.kodilla.travelagency.business.flights.dao.FlightDAO;
import com.kodilla.travelagency.business.flights.domain.Flight;
import com.kodilla.travelagency.business.flights.service.FlightService;
import com.kodilla.travelagency.exceptions.FlightNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FlightServiceTestSuite {
    @Autowired
    private FlightService service;
    
    @Autowired
    private FlightDAO dao;

    @Test
    public void shouldGetAllFlights() {
        //Given
        Flight flight = Flight.builder()
                .flightDuration(8L).airplaneModel("727").destination("FRA").origin("CPH").build();
        Flight flight1 = Flight.builder()
                .flightDuration(8L).airplaneModel("727").destination("FRA").origin("CPH").build();
        Flight flight2 = Flight.builder()
                .flightDuration(8L).airplaneModel("727").destination("FRA").origin("CPH").build();
        dao.save(flight);
        dao.save(flight1);
        dao.save(flight2);
        //When
        List<Flight> flights = service.getAllFlights();
        //Then
        assertEquals(3, flights.size());
        //CleanUp
        dao.delete(flight);
        dao.delete(flight1);
        dao.delete(flight2);
    }

    @Test
    public void shouldFindFlightById() {
        //Given
        Flight flight = Flight.builder()
                .flightDuration(8L).airplaneModel("727").destination("FRA").origin("CPH").build();

        Flight savedFlight = dao.save(flight);
        //When and then
        try {
            Flight foundFlight = service.findFlightById(savedFlight.getId());
            assertEquals("727", foundFlight.getAirplaneModel());
            assertEquals("CPH", foundFlight.getOrigin());
            assertEquals("FRA", foundFlight.getDestination());
        } catch (FlightNotFoundException e) {
            e.printStackTrace();
        }
        //Clean Up
        dao.delete(savedFlight);
    }

    @Test
    public void shouldDeleteFlight() {
        //Given
        Flight flight = Flight.builder()
                .flightDuration(8L).airplaneModel("727").destination("FRA").origin("CPH").build();

        Flight savedFlight = dao.save(flight);
        //When
        service.deleteFlight(savedFlight.getId());
        List<Flight> flights = service.getAllFlights();
        //Then
        assertEquals(0, flights.size());
    }

    @Test
    public void shouldFetchAllFlightsByOriginAndDestination() {
        //Given
        Flight flight = Flight.builder()
                .flightDuration(8L).airplaneModel("727").destination("FRA").origin("CPH").build();
        Flight flight1 = Flight.builder()
                .flightDuration(8L).airplaneModel("727").destination("FRA").origin("CPH").build();
        Flight flight2 = Flight.builder()
                .flightDuration(8L).airplaneModel("727").destination("ORD").origin("JFK").build();
        dao.save(flight);
        dao.save(flight1);
        dao.save(flight2);
        //When
        List<Flight> flights = service.getFlightsByOrigAndDest("JFK", "ORD");
        List<Flight> flightList = service.getFlightsByOrigAndDest("CPH", "FRA");
        //Then
        assertEquals(1, flights.size());
        assertEquals(2, flightList.size());
        //CleanUp
        dao.delete(flight);
        dao.delete(flight1);
        dao.delete(flight2);
    }

    @Test
    public void shouldFetchAllFlightsByArrivalDate() {
        //Given
        Flight flight = Flight.builder()
                .arrivalDate(LocalDateTime.of(2019, 7, 5, 15, 15)).build();
        Flight flight1 = Flight.builder()
                .arrivalDate(LocalDateTime.of(2019, 7, 5, 15, 15)).build();
        Flight flight2 = Flight.builder()
                .arrivalDate(LocalDateTime.of(2018, 7, 5, 15, 15)).build();
        dao.save(flight);
        dao.save(flight1);
        dao.save(flight2);
        //When
        List<Flight> flights = service.getFlightsByArrivalDate("2019-07-05T15:15");
        List<Flight> flightList = service.getFlightsByArrivalDate("2018-07-05T15:15");
        //Then
        assertEquals(2, flights.size());
        assertEquals(1, flightList.size());
        //CleanUp
        dao.delete(flight);
        dao.delete(flight1);
        dao.delete(flight2);
    }

    @Test
    public void shouldFetchAllFlightsByDepartureDate() {
        //Given
        Flight flight = Flight.builder()
                .departureDate(LocalDateTime.of(2019, 7, 5, 15, 15)).build();
        Flight flight1 = Flight.builder()
                .departureDate(LocalDateTime.of(2019, 7, 5, 15, 15)).build();
        Flight flight2 = Flight.builder()
                .departureDate(LocalDateTime.of(2018, 7, 5, 15, 15)).build();
        dao.save(flight);
        dao.save(flight1);
        dao.save(flight2);
        //When
        List<Flight> flights = service.getFlightsByDepartureDate("2019-07-05T15:15");
        List<Flight> flightList = service.getFlightsByDepartureDate("2018-07-05T15:15");
        //Then
        assertEquals(2, flights.size());
        assertEquals(1, flightList.size());
        //CleanUp
        dao.delete(flight);
        dao.delete(flight1);
        dao.delete(flight2);
    }
}
