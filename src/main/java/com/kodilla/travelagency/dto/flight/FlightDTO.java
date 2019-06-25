package com.kodilla.travelagency.dto.flight;

import com.kodilla.travelagency.core.flight.FlightCabin;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlightDTO {
    private Long id;

    private FlightCabin flightCabin;

    private String meal;

    private String seat;

    private LocalDateTime departureDate;

    private LocalDateTime arrivalDate;

    private Long flightDuration;

    private String airplaneModel;

    private BigDecimal price;
}
