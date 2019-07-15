package com.kodilla.travelagency.business.trip.api;

import com.kodilla.travelagency.business.car.domain.CarReservation;
import com.kodilla.travelagency.business.flights.domain.Ticket;
import com.kodilla.travelagency.business.hotel.domain.HotelReservation;
import com.kodilla.travelagency.business.place.domain.Place;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TripDTO {
    private Long id;

    private String tripName;

    private List<Ticket> tickets;

    private List<CarReservation> carReservations;

    private List<HotelReservation> hotelReservations;

    private List<Place> placeList;

    private BigDecimal totalPrice;
}
