package com.kodilla.travelagency.mappers;

import com.kodilla.travelagency.business.trip.api.TripDTO;
import com.kodilla.travelagency.business.trip.domain.Trip;
import com.kodilla.travelagency.business.trip.mapper.TripMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TripMapperTestSuite {
    @Autowired
    private TripMapper mapper;

    @Test
    public void testMapTripToTripDTO() {
        //Given
        Trip trip = new Trip(1L, "Spain", null, new ArrayList<>(),
                null, new ArrayList<>(), BigDecimal.ONE);
        //when
        TripDTO tripDTO = mapper.mapTripToTripDTO(trip);
        //Then
        assertEquals("Spain", tripDTO.getTripName());
        assertEquals(0, tripDTO.getCarReservations().size());
        assertEquals(0, tripDTO.getPlaceList().size());
        assertNull(tripDTO.getHotelReservations());
        assertNull(tripDTO.getTickets());
    }

    @Test
    public void testMapTripDTOToTrip() {
        //Given
        TripDTO tripDTO = new TripDTO(1L, "Spain", null, new ArrayList<>(),
                null, new ArrayList<>(), BigDecimal.ONE);
        //when
        Trip trip = mapper.mapTripDTOToTrip(tripDTO);
        //Then
        assertEquals("Spain", trip.getTripName());
        assertEquals(0, trip.getCarReservations().size());
        assertEquals(0, trip.getPlaceList().size());
        assertNull(trip.getHotelReservations());
        assertNull(trip.getTickets());
    }

    @Test
    public void testMapTripListToTripDTOList() {
        //Given
        Trip trip = new Trip(1L, "Spain", null, new ArrayList<>(),
                null, new ArrayList<>(), BigDecimal.ONE);
        Trip trip1 = new Trip(2L, "Greece", null, new ArrayList<>(),
                null, new ArrayList<>(), BigDecimal.ONE);
        Trip trip2 = new Trip(3L, "Italy", null, new ArrayList<>(),
                null, new ArrayList<>(), BigDecimal.ONE);
        List<Trip> tripList = new ArrayList<>();
        tripList.add(trip);
        tripList.add(trip1);
        tripList.add(trip2);
        //When
        List<TripDTO> tripDTOList = mapper.mapTripListToTripDTOList(tripList);
        //Then
        assertEquals(3, tripDTOList.size());
    }

    @Test
    public void testMapTripDTOListToTripList() {
        //Given
        TripDTO tripDTO = new TripDTO(1L, "Spain", null, new ArrayList<>(),
                null, new ArrayList<>(), BigDecimal.ONE);
        TripDTO tripDTO1 = new TripDTO(2L, "Greece", null, new ArrayList<>(),
                null, new ArrayList<>(), BigDecimal.ONE);
        TripDTO tripDTO2 = new TripDTO(3L, "Italy", null, new ArrayList<>(),
                null, new ArrayList<>(), BigDecimal.ONE);
        List<TripDTO> tripDTOList = new ArrayList<>();
        tripDTOList.add(tripDTO);
        tripDTOList.add(tripDTO1);
        tripDTOList.add(tripDTO2);
        //When
        List<Trip> tripList = mapper.mapTripDTOListToTripList(tripDTOList);
        //Then
        assertEquals(3, tripList.size());
    }
}
