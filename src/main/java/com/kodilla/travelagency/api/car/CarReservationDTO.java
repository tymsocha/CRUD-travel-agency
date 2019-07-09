package com.kodilla.travelagency.api.car;

import com.kodilla.travelagency.core.car.CarCompany;
import com.kodilla.travelagency.core.car.CarType;
import com.kodilla.travelagency.core.trip.Trip;
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
