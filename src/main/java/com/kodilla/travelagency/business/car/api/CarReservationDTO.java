package com.kodilla.travelagency.business.car.api;

import com.kodilla.travelagency.business.car.domain.CarCompany;
import com.kodilla.travelagency.business.car.domain.CarType;
import com.kodilla.travelagency.business.trip.domain.Trip;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CarReservationDTO {
    private Long id;

    private LocalDateTime startRentDate;

    private LocalDateTime endRentDate;

    private BigDecimal numberOfRentDays;

    private BigDecimal pricePerDay;

    private BigDecimal price;

    private CarType carType;

    private CarCompany carCompany;

    private Trip trip;
}
