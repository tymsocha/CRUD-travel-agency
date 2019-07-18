package com.kodilla.travelagency.business.place.facede;

import com.kodilla.travelagency.business.place.api.PlaceDTO;
import com.kodilla.travelagency.business.place.mapper.PlaceMapper;
import com.kodilla.travelagency.business.place.service.PlacesService;
import com.kodilla.travelagency.exceptions.PlaceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public void deletePlace(Long placeId) throws PlaceNotFoundException {
        placesService.deletePlace(placeId);
    }

    public List<PlaceDTO> getPlacesByCountry(PlaceDTO placeDTO) {
        return placeMapper.mapPlaceListToPlaceDTOList(placesService.findPlacesByCountry(placeDTO.getCountry()));
    }

    public List<PlaceDTO> getPlacesByNearestCity(PlaceDTO placeDTO) {
        return placeMapper.mapPlaceListToPlaceDTOList(placesService.findPlacesByNearestCity(placeDTO.getNearestCity()));
    }

    public List<PlaceDTO> getPlacesByNearestCityAndDistance(PlaceDTO placeDTO) {
        return placeMapper.mapPlaceListToPlaceDTOList(
                placesService.findPlacesByNearestCityAndDistance(
                        placeDTO.getNearestCity(), placeDTO.getDistanceFromNearestCity()
                )
        );
    }

    public List<PlaceDTO> getPlacesByCost(PlaceDTO placeDTO) {
        return placeMapper.mapPlaceListToPlaceDTOList(placesService.findPlacesByCost(placeDTO.getCostToEnter()));
    }

    public List<PlaceDTO> getPlacesByMonumentStatus(PlaceDTO placeDTO) {
        return placeMapper.mapPlaceListToPlaceDTOList(placesService.findPlacesByIsMonument(placeDTO.getIsMonument()));
    }
}
