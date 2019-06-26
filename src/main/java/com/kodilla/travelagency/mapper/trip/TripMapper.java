package com.kodilla.travelagency.mapper.trip;

import com.kodilla.travelagency.core.trip.Trip;
import com.kodilla.travelagency.dto.trip.TripDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TripMapper {
    public Trip mapTripDTOToTrip(TripDTO tripDTO) {
        return Trip.builder()
                .id(tripDTO.getId())
                .carReservationList(tripDTO.getCarReservationList())
                .hotelReservationList(tripDTO.getHotelReservationList())
                .flightList(tripDTO.getFlightList())
                .placeList(tripDTO.getPlaceList())
                .totalPrice(tripDTO.getTotalPrice())
                .build();
    }

    public TripDTO mapTripToTripDTO(Trip trip) {
        return TripDTO.builder()
                .id(trip.getId())
                .carReservationList(trip.getCarReservationList())
                .hotelReservationList(trip.getHotelReservationList())
                .flightList(trip.getFlightList())
                .placeList(trip.getPlaceList())
                .totalPrice(trip.getTotalPrice())
                .build();
    }

    public List<Trip> mapTripDTOListToTripList(List<TripDTO> tripDTOList) {
        return tripDTOList.stream().map(tripDTO -> Trip.builder()
                    .id(tripDTO.getId())
                    .carReservationList(tripDTO.getCarReservationList())
                    .hotelReservationList(tripDTO.getHotelReservationList())
                    .flightList(tripDTO.getFlightList())
                    .placeList(tripDTO.getPlaceList())
                    .totalPrice(tripDTO.getTotalPrice())
                    .build())
                .collect(Collectors.toList());
    }

    public List<TripDTO> mapTripListToTripDTOList(List<Trip> tripList) {
        return tripList.stream().map(trip -> TripDTO.builder()
                .id(trip.getId())
                .carReservationList(trip.getCarReservationList())
                .hotelReservationList(trip.getHotelReservationList())
                .flightList(trip.getFlightList())
                .placeList(trip.getPlaceList())
                .totalPrice(trip.getTotalPrice())
                .build())
                .collect(Collectors.toList());
    }
}
