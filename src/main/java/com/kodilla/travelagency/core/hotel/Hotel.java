package com.kodilla.travelagency.core.hotel;

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
@Entity(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "hotel_name")
    private String hotelName;

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

    private String name;

    public BigDecimal getNumberOfDays() {
        return numberOfDays = new BigDecimal(ChronoUnit.DAYS.between(checkIn, checkOut));
    }

    public BigDecimal getTotalCostOfStay() {
        return totalCostOfStay = costPerNight.multiply(numberOfDays);
    }

    public String getName() {
        return name = "Hotel";
    }
}
