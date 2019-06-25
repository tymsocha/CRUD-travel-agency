package com.kodilla.travelagency.core.flight;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
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

    @Column(name = "cabin")
    private FlightCabin flightCabin;

    @Column(name = "meal")
    private String meal;

    @Column(name = "seat")
    private String seat;

    @Column(name = "departure_date")
    private LocalDateTime departureDate;

    @Column(name = "arrival_date")
    private LocalDateTime arrivalDate;

    @Column(name = "duration")
    private Long flightDuration;

    @Column(name = "plane")
    private String airplaneModel;

    @Column(name = "price")
    private BigDecimal price;

    private String name;

    public Long getFlightDuration() {
        return flightDuration = ChronoUnit.MINUTES.between(departureDate, arrivalDate);
    }

    public String getName() {
        return name = "Flight";
    }
}
