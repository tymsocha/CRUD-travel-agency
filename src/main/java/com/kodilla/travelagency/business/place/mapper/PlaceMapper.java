package com.kodilla.travelagency.business.place.mapper;

import com.kodilla.travelagency.business.place.api.PlaceDTO;
import com.kodilla.travelagency.business.place.domain.Place;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlaceMapper {
    public Place mapPlaceDTOToPlace(PlaceDTO placeDTO) {
        return Place.builder()
                .id(placeDTO.getId())
                .placeName(placeDTO.getPlaceName())
                .country(placeDTO.getCountry())
                .description(placeDTO.getDescription())
                .isMonument(placeDTO.getIsMonument())
                .costToEnter(placeDTO.getCostToEnter())
                .nearestCity(placeDTO.getNearestCity())
                .distanceFromNearestCity(placeDTO.getDistanceFromNearestCity())
                .build();
    }

    public PlaceDTO mapPlaceToPlaceDTO(Place place) {
        return PlaceDTO.builder()
                .id(place.getId())
                .placeName(place.getPlaceName())
                .country(place.getCountry())
                .description(place.getDescription())
                .isMonument(place.getIsMonument())
                .costToEnter(place.getCostToEnter())
                .nearestCity(place.getNearestCity())
                .distanceFromNearestCity(place.getDistanceFromNearestCity())
                .build();
    }

    public List<Place> mapPlaceDTOListToPlaceList(List<PlaceDTO> placeDTOList) {
        return placeDTOList.stream().map(placeDTO -> Place.builder()
                    .id(placeDTO.getId())
                    .placeName(placeDTO.getPlaceName())
                    .country(placeDTO.getCountry())
                    .description(placeDTO.getDescription())
                    .isMonument(placeDTO.getIsMonument())
                    .costToEnter(placeDTO.getCostToEnter())
                    .nearestCity(placeDTO.getNearestCity())
                    .distanceFromNearestCity(placeDTO.getDistanceFromNearestCity())
                    .build())
                .collect(Collectors.toList());
    }

    public List<PlaceDTO> mapPlaceListToPlaceDTOList(List<Place> placeList) {
        return placeList.stream().map(place -> PlaceDTO.builder()
                    .id(place.getId())
                    .placeName(place.getPlaceName())
                    .country(place.getCountry())
                    .description(place.getDescription())
                    .isMonument(place.getIsMonument())
                    .costToEnter(place.getCostToEnter())
                    .nearestCity(place.getNearestCity())
                    .distanceFromNearestCity(place.getDistanceFromNearestCity())
                    .build())
                .collect(Collectors.toList());
    }
}
