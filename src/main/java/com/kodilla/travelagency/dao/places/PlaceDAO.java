package com.kodilla.travelagency.dao.places;

import com.kodilla.travelagency.core.places.Place;
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

    List<Place> findByCountry(String country);

    List<Place> findByNearestCity(String nearestCity);

    List<Place> findByNearestCityAndDistanceFromNearestCity(String nearestCity, Double distance);

    List<Place> findByCostToEnter(BigDecimal cost);

    List<Place> findByIsMonument(Boolean isMonument);

    List<Place> findByCountryAndIsMonumentAndCostToEnterAndNearestCityAndDistanceFromNearestCity(
            String country, String nearestCity, Double distance, BigDecimal cost, Boolean isMonument
    );
}
