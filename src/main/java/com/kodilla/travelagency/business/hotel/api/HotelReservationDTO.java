package com.kodilla.travelagency.business.hotel.api;

import com.kodilla.travelagency.business.hotel.RoomType;
import com.kodilla.travelagency.business.hotel.domain.Hotel;
import com.kodilla.travelagency.business.trip.domain.Trip;
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

    private String guestName;

    private RoomType roomType;

    private Boolean isBreakfast;

    private LocalDateTime checkIn;

    private LocalDateTime checkOut;

    private BigDecimal numberOfDays;

    private BigDecimal costPerNight;

    private BigDecimal totalCostOfStay;

    private Hotel hotel;
    
    private Trip trip;
}
