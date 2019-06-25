package com.kodilla.travelagency.core.car;

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
@Entity(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "company")
    private String companyName;

    @Column(name = "rent_start")
    private LocalDateTime startRentDate;

    @Column(name = "rent_end")
    private LocalDateTime endRentDate;

    @Column(name = "days_of_rent")
    private BigDecimal numberOfRentDays;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = CarType.class)
    @JoinColumn(name = "car_type")
    private CarType carType;

    @Column(name = "daily_price")
    private BigDecimal pricePerDay;

    @Column(name = "total_price")
    private BigDecimal price;

    private String name;

    public BigDecimal getNumberOfRentDays() {
        return numberOfRentDays = new BigDecimal(ChronoUnit.DAYS.between(startRentDate, endRentDate));
    }

    public BigDecimal getPrice() {
        return price = pricePerDay.multiply(numberOfRentDays);
    }

    public String getName() {
        return name = "Car";
    }
}
