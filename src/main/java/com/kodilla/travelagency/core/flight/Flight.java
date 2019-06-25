package com.kodilla.travelagency.core.flight;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "airline")
    private String airline;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;

    @Column(name = "cabin")
    private FlightCabin flightCabin;

    @Column(name = "meal")
    private String meal;

    @Column(name = "seat")
    private String seat;

    @Column(name = "dep_date")
    private LocalDateTime departureDate;

    @Column(name = "arr_date")
    private LocalDateTime arrivalDate;

    @Column(name = "duration")
    private Long flightDuration;

    @Column(name = "plane")
    private String airplaneModel;

    @Column(name = "price")
    private BigDecimal price;

    private String name;

    public Long getFlightDuration() {
        return flightDuration = Duration.between(departureDate.toLocalTime(), arrivalDate.toLocalTime()).toHours();
    }

    public String getName() {
        return name = "Flight";
    }
}
