package com.kodilla.travelagency.business.place.dao;

import com.kodilla.travelagency.business.place.domain.Place;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface PlaceDAO extends CrudRepository<Place, Long> {
    @Override
    List<Place> findAll();

    @Override
    Place save(Place place);

    Optional<Place> findById(Long id);

    Optional<Place> deletePlaceById(Long id);

    @Override
    void deleteAll();

    @Override
    long count();

    Optional<Place> findByPlaceName(String placeName);

    List<Place> findAllByCountry(String country);

    List<Place> findAllByNearestCity(String nearestCity);

    List<Place> findAllByNearestCityAndDistanceFromNearestCity(String nearestCity, Double distance);

    List<Place> findAllByCostToEnter(BigDecimal cost);

    List<Place> findAllByIsMonument(Boolean isMonument);

    List<Place> findAllByCountryAndIsMonumentAndCostToEnterAndNearestCityAndDistanceFromNearestCity (
            String country, String nearestCity, Double distance, BigDecimal cost, Boolean isMonument
    );
}
