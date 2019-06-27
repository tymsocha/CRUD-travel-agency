package com.kodilla.travelagency.dto.flight;

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

    private String airline;

    private String origin;

    private String destination;

    private LocalDateTime departureDate;

    private LocalDateTime arrivalDate;

    private Long flightDuration;

    private String airplaneModel;

    private List<Ticket> ticketList;
}
