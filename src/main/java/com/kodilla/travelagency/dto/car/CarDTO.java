package com.kodilla.travelagency.dto.car;

import com.kodilla.travelagency.core.car.CarType;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDTO {
    private Long id;

    private String companyName;

    private LocalDateTime startRentDate;

    private LocalDateTime endRentDate;

    private BigDecimal numberOfRentDays;

    private CarType carType;

    private BigDecimal pricePerDay;

    private BigDecimal price;

    public BigDecimal getNumberOfRentDays() {
        return new BigDecimal(ChronoUnit.DAYS.between(startRentDate, endRentDate));
    }

    public BigDecimal getPrice() {
        return price = pricePerDay.multiply(numberOfRentDays);
    }
}
