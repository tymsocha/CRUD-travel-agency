package com.kodilla.travelagency.api.flight;

import com.kodilla.travelagency.core.flight.Airline;
import com.kodilla.travelagency.core.flight.Ticket;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlightDTO {
    private Long id;

    private Airline airline;

    private String origin;

    private String destination;

    private LocalDateTime departureDate;

    private LocalDateTime arrivalDate;

    private Long flightDuration;

    private String airplaneModel;

    private List<Ticket> ticketList;
}
