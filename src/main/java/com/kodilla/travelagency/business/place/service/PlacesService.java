package com.kodilla.travelagency.business.place.service;

import com.kodilla.travelagency.business.place.api.PlaceDTO;
import com.kodilla.travelagency.business.place.dao.PlaceDAO;
import com.kodilla.travelagency.business.place.domain.Place;
import com.kodilla.travelagency.exceptions.PlaceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PlacesService {
    @Autowired
    private PlaceDAO placeDAO;

    public List<Place> getAllPlaces() {
        return placeDAO.findAll();
    }

    public Place findPlaceByPlaceName(String placeName) throws PlaceNotFoundException {
        return placeDAO.findByPlaceName(placeName).orElseThrow(PlaceNotFoundException::new);
    }

    public Place saveOrUpdatePlace(Place place) {
        return placeDAO.save(place);
    }

    public Place findPlaceById(Long placeId) throws PlaceNotFoundException {
        return placeDAO.findById(placeId).orElseThrow(PlaceNotFoundException::new);
    }

    public void deletePlace(Long placeId) {
        placeDAO.delete(placeId);
    }

    public List<Place> findPlacesByCountry(String country) {
        return placeDAO.findAllByCountry(country);
    }

    public List<Place> findPlacesByNearestCity(String nearestCity) {
        return placeDAO.findAllByNearestCity(nearestCity);
    }

    public List<Place> findPlacesByNearestCityAndDistance(String city, Double distance) {
        return placeDAO.findAllByNearestCityAndDistanceFromNearestCity(city, distance);
    }

    public List<Place> findPlacesByCost(BigDecimal cost) {
        return placeDAO.findAllByCostToEnter(cost);
    }

    public List<Place> findPlacesByIsMonument(Boolean isMonument) {
        return placeDAO.findAllByIsMonument(isMonument);
    }
}
