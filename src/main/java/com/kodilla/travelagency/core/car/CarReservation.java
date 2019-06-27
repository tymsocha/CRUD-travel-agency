package com.kodilla.travelagency.core.car;

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
@Entity(name = "car_reservations")
public class CarReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "rent_start")
    private LocalDateTime startRentDate;

    @Column(name = "rent_end")
    private LocalDateTime endRentDate;

    @Column(name = "days_of_rent")
    private BigDecimal numberOfRentDays;

    @Column(name = "daily_price")
    private BigDecimal pricePerDay;

    @Column(name = "total_price")
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = CarType.class)
    @JoinColumn(name = "car_type_id")
    private CarType carType;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = CarCompany.class)
    @JoinColumn(name = "company_id")
    private CarCompany carCompany;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Trip.class)
    @JoinColumn(name = "trip_id")
    private Trip trip;

    public BigDecimal getNumberOfRentDays() {
        return numberOfRentDays = new BigDecimal(ChronoUnit.DAYS.between(startRentDate, endRentDate));
    }

    public BigDecimal getPrice() {
        return price = pricePerDay.multiply(numberOfRentDays);
    }
}
