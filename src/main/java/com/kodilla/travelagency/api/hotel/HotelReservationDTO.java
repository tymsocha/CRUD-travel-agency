package com.kodilla.travelagency.api.hotel;

import com.kodilla.travelagency.core.hotel.Hotel;
import com.kodilla.travelagency.core.hotel.RoomType;
import com.kodilla.travelagency.core.trip.Trip;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelReservationDTO {
    private Long id;

    private Hotel hotel;

    private RoomType roomType;

    private Boolean isBreakfast;

    private LocalDateTime checkIn;

    private LocalDateTime checkOut;

    private BigDecimal numberOfDays;

    private BigDecimal costPerNight;

    private BigDecimal totalCostOfStay;

    private Trip trip;
}
