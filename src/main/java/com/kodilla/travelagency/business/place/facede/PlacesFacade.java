package com.kodilla.travelagency.business.place.facede;

import com.kodilla.travelagency.business.place.api.PlaceDTO;
import com.kodilla.travelagency.business.place.mapper.PlaceMapper;
import com.kodilla.travelagency.business.place.service.PlacesService;
import com.kodilla.travelagency.exceptions.PlaceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class PlacesFacade {
    @Autowired
    private PlaceMapper placeMapper;

    @Autowired
    private PlacesService placesService;

    public List<PlaceDTO> getPlaces() {
        return placeMapper.mapPlaceListToPlaceDTOList(placesService.getAllPlaces());
    }

    public PlaceDTO getPlace(Long placeId) throws PlaceNotFoundException {
        return placeMapper.mapPlaceToPlaceDTO(placesService.findPlaceById(placeId));
    }

    public PlaceDTO getPlaceByName(String placeName) throws PlaceNotFoundException {
        return placeMapper.mapPlaceToPlaceDTO(placesService.findPlaceByPlaceName(placeName));
    }

    public PlaceDTO savePlace(PlaceDTO placeDTO) {
        return placeMapper.mapPlaceToPlaceDTO(placesService.saveOrUpdatePlace(placeMapper.mapPlaceDTOToPlace(placeDTO)));
    }

    public PlaceDTO updatePlace(PlaceDTO placeDTO) {
        return placeMapper.mapPlaceToPlaceDTO(placesService.saveOrUpdatePlace(placeMapper.mapPlaceDTOToPlace(placeDTO)));
    }

    public void deletePlace(Long placeId) {
        placesService.deletePlace(placeId);
    }

    public List<PlaceDTO> getPlacesByCountry(String country) {
        return placeMapper.mapPlaceListToPlaceDTOList(placesService.findPlacesByCountry(country));
    }

    public List<PlaceDTO> getPlacesByNearestCity(String city) {
        return placeMapper.mapPlaceListToPlaceDTOList(placesService.findPlacesByNearestCity(city));
    }

    public List<PlaceDTO> getPlacesByNearestCityAndDistance(String city, Double distance) {
        return placeMapper.mapPlaceListToPlaceDTOList(
                placesService.findPlacesByNearestCityAndDistance(city, distance));
    }

    public List<PlaceDTO> getPlacesByCost(Long cost) {
        return placeMapper.mapPlaceListToPlaceDTOList(placesService.findPlacesByCost(BigDecimal.valueOf(cost)));
    }

    public List<PlaceDTO> getPlacesByMonumentStatus(Boolean status) {
        return placeMapper.mapPlaceListToPlaceDTOList(placesService.findPlacesByIsMonument(status));
    }
}
