package com.kodilla.travelagency.api.flight;

import com.kodilla.travelagency.core.flight.FlightCabin;
import com.kodilla.travelagency.core.trip.Trip;
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
