package com.kodilla.travelagency.core.hotel;

import com.kodilla.travelagency.core.trip.Trip;
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
@Entity(name = "hotel_reservations")
public class HotelReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "room_type")
    private RoomType roomType;

    @Column(name = "is_breakfast")
    private Boolean isBreakfast;

    @Column(name = "check_in")
    private LocalDateTime checkIn;

    @Column(name = "check_out")
    private LocalDateTime checkOut;

    @Column(name = "days_of_the_stay")
    private BigDecimal numberOfDays;

    @Column(name = "night_cost")
    private BigDecimal costPerNight;

    @Column(name = "total_cost")
    private BigDecimal totalCostOfStay;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Hotel.class)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Trip.class)
    @JoinColumn(name = "trip_id")
    private Trip trip;

    public BigDecimal getNumberOfDays() {
        return numberOfDays = new BigDecimal(ChronoUnit.DAYS.between(checkIn, checkOut));
    }

    public BigDecimal getTotalCostOfStay() {
        return totalCostOfStay = costPerNight.multiply(numberOfDays);
    }
}
