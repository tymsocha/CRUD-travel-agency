package com.kodilla.travelagency.core.trip;

import com.kodilla.travelagency.core.car.Car;
import com.kodilla.travelagency.core.flight.Flight;
import com.kodilla.travelagency.core.hotel.Hotel;
import com.kodilla.travelagency.core.places.Place;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

   /* @ManyToMany(

    )
    private List<Hotel> hotelList;

    @ManyToMany(

    )
    private List<Flight> flightList;

    @ManyToMany(

    )
    private List<Car> carList;

    @ManyToMany(

    )
    private List<Place> placeList;

    @Column(name = "totalPrice")
    private BigDecimal totalPrice;

    public BigDecimal setTotalPrice() {
        BigDecimal carsPrice = carList.stream().map(Car::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal flightsPrice = flightList.stream().map(Flight::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal hotelsPrice = hotelList.stream().map(Hotel::getTotalCostOfStay).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal placesPrice = placeList.stream().map(Place::getCostToEnter).reduce(BigDecimal.ZERO, BigDecimal::add);
        return totalPrice = carsPrice.add(hotelsPrice).add(flightsPrice).add(placesPrice);
    }*/
}
