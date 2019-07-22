package com.kodilla.travelagency.facades;

import com.kodilla.travelagency.business.place.api.PlaceDTO;
import com.kodilla.travelagency.business.place.dao.PlaceDAO;
import com.kodilla.travelagency.business.place.domain.Place;
import com.kodilla.travelagency.business.place.facede.PlacesFacade;
import com.kodilla.travelagency.exceptions.PlaceNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PlaceFacadeTestSuite {
    @Autowired
    private PlacesFacade facade;

    @Autowired
    private PlaceDAO dao;

    @Test
    public void shouldGetAllPlaces() {
        //Given
        Place place = Place.builder().placeName("Beach").country("Spain").nearestCity("Barcelona").build();
        Place place1 = Place.builder().placeName("Castle").country("England").nearestCity("Birmingham").build();
        Place place2 = Place.builder().placeName("Church").country("France").nearestCity("Paris").build();
        dao.save(place);
        dao.save(place1);
        dao.save(place2);
        //When
        List<PlaceDTO> places = facade.getPlaces();
        //Then
        assertEquals(3, places.size());
        //CleanUp
        dao.delete(place);
        dao.delete(place1);
        dao.delete(place2);
    }

    @Test
    public void shouldFindPlaceById() {
        //Given
        Place place = Place.builder().placeName("Beach").country("Spain").nearestCity("Barcelona").build();
        Place savedPlace = dao.save(place);
        //When and then
        try {
            PlaceDTO foundPlace = facade.getPlace(savedPlace.getId());
            assertEquals("Beach", foundPlace.getPlaceName());
            assertEquals("Spain", foundPlace.getCountry());
            assertEquals("Barcelona", foundPlace.getNearestCity());
        } catch (PlaceNotFoundException e) {
            e.printStackTrace();
        }
        //Clean Up
        dao.delete(savedPlace);
    }

    @Test
    public void shouldDeletePlace() {
        //Given
        Place place = Place.builder().placeName("Beach").country("Spain").nearestCity("Barcelona").build();
        Place savedPlace = dao.save(place);
        //When
        facade.deletePlace(savedPlace.getId());
        List<PlaceDTO> places = facade.getPlaces();
        //Then
        assertEquals(0, places.size());
    }

    @Test
    public void shouldFetchAllPlacesByName() {
        //Given
        Place place = Place.builder().placeName("Beach").country("Spain").nearestCity("Barcelona").build();
        Place savedPlace = dao.save(place);
        //
        try {
            PlaceDTO foundPlace = facade.getPlaceByName("Beach");
            assertEquals("Beach", foundPlace.getPlaceName());
            assertEquals("Spain", foundPlace.getCountry());
            assertEquals("Barcelona", foundPlace.getNearestCity());
        } catch (PlaceNotFoundException e) {
            e.printStackTrace();
        }
        dao.delete(savedPlace);
    }

    @Test
    public void shouldFetchAllPlacesByCountry() {
        //Given
        Place place = Place.builder().placeName("Beach").country("Spain").nearestCity("Barcelona").build();
        Place place1 = Place.builder().placeName("Castle").country("France").nearestCity("Birmingham").build();
        Place place2 = Place.builder().placeName("Church").country("France").nearestCity("Paris").build();
        dao.save(place);
        dao.save(place1);
        dao.save(place2);
        //When
        List<PlaceDTO> places = facade.getPlacesByCountry("France");
        List<PlaceDTO> placeList = facade.getPlacesByCountry("Spain");
        //Then
        assertEquals(2, places.size());
        assertEquals(1, placeList.size());
        //CleanUp
        dao.delete(place);
        dao.delete(place1);
        dao.delete(place2);
    }

    @Test
    public void shouldFetchAllPlacesByNearestCity() {
        //Given
        Place place = Place.builder().placeName("Beach").country("Spain").nearestCity("Barcelona").build();
        Place place1 = Place.builder().placeName("Castle").country("France").nearestCity("Paris").build();
        Place place2 = Place.builder().placeName("Church").country("France").nearestCity("Paris").build();
        dao.save(place);
        dao.save(place1);
        dao.save(place2);
        //When
        List<PlaceDTO> places = facade.getPlacesByNearestCity("Paris");
        List<PlaceDTO> placeList = facade.getPlacesByNearestCity("Barcelona");
        //Then
        assertEquals(2, places.size());
        assertEquals(1, placeList.size());
        //CleanUp
        dao.delete(place);
        dao.delete(place1);
        dao.delete(place2);
    }

    @Test
    public void shouldFetchAllPlacesByNearestCityAndDistance() {
        //Given
        Place place = Place.builder().placeName("Beach").distanceFromNearestCity(26.2).nearestCity("Paris").build();
        Place place1 = Place.builder().placeName("Castle").distanceFromNearestCity(23.0).nearestCity("Birmingham").build();
        Place place2 = Place.builder().placeName("Church").distanceFromNearestCity(26.2).nearestCity("Paris").build();
        dao.save(place);
        dao.save(place1);
        dao.save(place2);
        //When
        List<PlaceDTO> places = facade.getPlacesByNearestCityAndDistance("Paris", 26.2);
        List<PlaceDTO> placeList = facade.getPlacesByNearestCityAndDistance("Birmingham", 23.0);
        List<PlaceDTO> wrongList = facade.getPlacesByNearestCityAndDistance("Paris", 2.0);
        //Then
        assertEquals(2, places.size());
        assertEquals(1, placeList.size());
        assertEquals(0, wrongList.size());
        //CleanUp
        dao.delete(place);
        dao.delete(place1);
        dao.delete(place2);
    }

    @Test
    public void shouldFetchAllPlacesByCost() {
        //Given
        Place place = Place.builder().placeName("Beach").costToEnter(BigDecimal.valueOf(23)).nearestCity("Barcelona").build();
        Place place1 = Place.builder().placeName("Castle").costToEnter(BigDecimal.valueOf(50)).nearestCity("Birmingham").build();
        Place place2 = Place.builder().placeName("Church").costToEnter(BigDecimal.valueOf(23)).nearestCity("Paris").build();
        dao.save(place);
        dao.save(place1);
        dao.save(place2);
        //When
        List<PlaceDTO> places = facade.getPlacesByCost(23L);
        List<PlaceDTO> placeList = facade.getPlacesByCost(50L);
        List<PlaceDTO> wrongList = facade.getPlacesByCost(2L);
        //Then
        assertEquals(2, places.size());
        assertEquals(1, placeList.size());
        assertEquals(0, wrongList.size());
        //CleanUp
        dao.delete(place);
        dao.delete(place1);
        dao.delete(place2);
    }

    @Test
    public void shouldFetchAllPlacesByMonument() {
        //Given
        Place place = Place.builder().placeName("Beach").isMonument(true).nearestCity("Barcelona").build();
        Place place1 = Place.builder().placeName("Castle").isMonument(false).nearestCity("Birmingham").build();
        Place place2 = Place.builder().placeName("Church").isMonument(true).nearestCity("Paris").build();
        dao.save(place);
        dao.save(place1);
        dao.save(place2);
        //When
        List<PlaceDTO> places = facade.getPlacesByMonumentStatus(true);
        List<PlaceDTO> placeList = facade.getPlacesByMonumentStatus(false);
        //Then
        assertEquals(2, places.size());
        assertEquals(1, placeList.size());
        //CleanUp
        dao.delete(place);
        dao.delete(place1);
        dao.delete(place2);
    }
}
