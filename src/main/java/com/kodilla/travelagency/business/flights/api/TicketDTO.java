package com.kodilla.travelagency.business.flights.api;

import com.kodilla.travelagency.business.flights.FlightCabin;
import com.kodilla.travelagency.business.trip.domain.Trip;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketDTO {
    private Long id;

    private String firstName;

    private String lastName;

    private FlightCabin flightCabin;

    private String meal;

    private String seat;

    private BigDecimal price;

    private Trip trip;

}
