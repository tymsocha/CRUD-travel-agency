package com.kodilla.travelagency.dto.trip;

import com.kodilla.travelagency.core.car.CarReservation;
import com.kodilla.travelagency.core.flight.Flight;
import com.kodilla.travelagency.core.hotel.HotelReservation;
import com.kodilla.travelagency.core.places.Place;
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

    private List<HotelReservation> hotelReservationList;

    private List<Flight> flightList;

    private List<CarReservation> carReservationList;

    private List<Place> placeList;

    private BigDecimal totalPrice;
}
