package com.kodilla.travelagency.business.flights.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "airlineId")
    private Airline airline;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;

    @Column(name = "dep_date")
    private LocalDateTime departureDate;

    @Column(name = "arr_date")
    private LocalDateTime arrivalDate;

    @Column(name = "duration")
    private Long flightDuration;

    @Column(name = "plane")
    private String airplaneModel;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "join_tickets_with_flights",
            joinColumns = {@JoinColumn(name = "flight_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "ticket_id", referencedColumnName = "id")}
    )
    private List<Ticket> ticketList;

    public Long getFlightDuration() {
        return flightDuration = Duration.between(departureDate.toLocalTime(), arrivalDate.toLocalTime()).toHours();
    }
}
