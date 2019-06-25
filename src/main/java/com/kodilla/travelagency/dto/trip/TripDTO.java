package com.kodilla.travelagency.dto.trip;

import com.kodilla.travelagency.core.car.Car;
import com.kodilla.travelagency.core.flight.Flight;
import com.kodilla.travelagency.core.hotel.Hotel;
import com.kodilla.travelagency.core.places.Place;
import lombok.*;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TripDTO {
    private Long id;

    private List<Hotel> hotelList;

    private List<Flight> flightList;

    private List<Car> carList;

    private List<Place> placeList;

    private BigDecimal totalPrice;
}
