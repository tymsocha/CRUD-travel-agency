package com.kodilla.travelagency.business.flights.domain;

import com.kodilla.travelagency.business.flights.FlightCabin;
import com.kodilla.travelagency.business.trip.domain.Trip;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "cabin")
    private FlightCabin flightCabin;

    @Column(name = "meal")
    private String meal;

    @Column(name = "seat")
    private String seat;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Trip.class)
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Airline.class)
    @JoinColumn(name = "airline_id")
    private Airline airline;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "ticketList")
    private List<Flight> flights;
}
