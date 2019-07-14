package com.kodilla.travelagency.business.trip.mapper;

import com.kodilla.travelagency.business.trip.api.TripDTO;
import com.kodilla.travelagency.business.trip.domain.Trip;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TripMapper {
    public Trip mapTripDTOToTrip(TripDTO tripDTO) {
        return Trip.builder()
                .id(tripDTO.getId())
                .tripName(tripDTO.getTripName())
                .placeList(tripDTO.getPlaceList())
                .totalPrice(tripDTO.getTotalPrice())
                .build();
    }

    public TripDTO mapTripToTripDTO(Trip trip) {
        return TripDTO.builder()
                .id(trip.getId())
                .tripName(trip.getTripName())
                .placeList(trip.getPlaceList())
                .totalPrice(trip.getTotalPrice())
                .build();
    }

    public List<Trip> mapTripDTOListToTripList(List<TripDTO> tripDTOList) {
        return tripDTOList.stream().map(tripDTO -> Trip.builder()
                    .id(tripDTO.getId())
                    .tripName(tripDTO.getTripName())
                    .placeList(tripDTO.getPlaceList())
                    .totalPrice(tripDTO.getTotalPrice())
                    .build())
                .collect(Collectors.toList());
    }

    public List<TripDTO> mapTripListToTripDTOList(List<Trip> tripList) {
        return tripList.stream().map(trip -> TripDTO.builder()
                    .id(trip.getId())
                    .tripName(trip.getTripName())
                    .placeList(trip.getPlaceList())
                    .totalPrice(trip.getTotalPrice())
                    .build())
                .collect(Collectors.toList());
    }
}
