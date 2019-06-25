package com.kodilla.travelagency.dao.places;

import com.kodilla.travelagency.core.places.Place;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PlaceDAO extends CrudRepository<Place, Long> {
    @Override
    List<Place> findAll();

    @Override
    Place save(Place place);

    Optional<Place> findById(Long id);

    Optional<Place> deleteTaskById(Long id);

    @Override
    void deleteAll();

    @Override
    long count();
}
