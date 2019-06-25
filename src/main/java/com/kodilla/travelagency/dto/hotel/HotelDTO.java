package com.kodilla.travelagency.dto.hotel;

import com.kodilla.travelagency.core.hotel.RoomType;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelDTO {
    private Long id;

    private RoomType roomType;

    private Boolean isBreakfast;

    private LocalDateTime checkIn;

    private LocalDateTime checkOut;

    private BigDecimal costPerNight;

    private BigDecimal numberOfDays;

    private BigDecimal totalCostOfStay;

    public BigDecimal getNumberOfDays() {
        return numberOfDays = new BigDecimal(ChronoUnit.DAYS.between(checkIn, checkOut));
    }

    public BigDecimal getTotalCostOfStay() {
        return totalCostOfStay = costPerNight.multiply(numberOfDays);
    }
}
