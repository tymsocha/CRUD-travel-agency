package com.kodilla.travelagency.service.places;

import com.kodilla.travelagency.api.places.PlaceDTO;
import com.kodilla.travelagency.core.places.Place;
import com.kodilla.travelagency.dao.places.PlaceDAO;
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

    public Place savePlace(Place place) {
        return placeDAO.save(place);
    }

    public Place findPlaceById(Long placeId) throws PlaceNotFoundException {
        return placeDAO.findById(placeId).orElseThrow(PlaceNotFoundException::new);
    }

    public void deletePlace(Long placeId) throws PlaceNotFoundException {
        placeDAO.deletePlaceById(placeId).orElseThrow(PlaceNotFoundException::new);
    }

    public List<Place> findPlacesByCountry(String country) {
        return placeDAO.findAllByCountry(country);
    }

    public List<Place> findPlacesByNearestCity(String nearestCity) {
        return placeDAO.findAllByNearestCity(nearestCity);
    }

    public List<Place> findPlacesByNearestCityAnddistance(String city, Double distance) {
        return placeDAO.findAllByNearestCityAndDistanceFromNearestCity(city, distance);
    }

    public List<Place> findPlacesByCost(BigDecimal cost) {
        return placeDAO.findAllByCostToEnter(cost);
    }

    public List<Place> findPlacesByIsMonument(Boolean isMonument) {
        return placeDAO.findAllByIsMonument(isMonument);
    }

    public List<Place> findPlaceUsingAllParameters(PlaceDTO placeDTO) {
        return placeDAO.findAllByCountryAndIsMonumentAndCostToEnterAndNearestCityAndDistanceFromNearestCity(
                placeDTO.getCountry(),
                placeDTO.getNearestCity(),
                placeDTO.getDistanceFromNearestCity(),
                placeDTO.getCostToEnter(),
                placeDTO.getIsMonument()
        );
    }
}
