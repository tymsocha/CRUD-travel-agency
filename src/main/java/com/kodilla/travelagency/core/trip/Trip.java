package com.kodilla.travelagency.core.trip;

import com.kodilla.travelagency.core.car.CarReservation;
import com.kodilla.travelagency.core.flight.Flight;
import com.kodilla.travelagency.core.hotel.HotelReservation;
import com.kodilla.travelagency.core.places.Place;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity(name = "trip")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "trip_name")
    private String tripName;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "join_trips_with_hotels",
            joinColumns = {@JoinColumn(name = "trip_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "hotel_id", referencedColumnName = "id")}
    )
    private List<HotelReservation> hotelReservationList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "join_trips_with_flights",
            joinColumns = {@JoinColumn(name = "trip_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "flight_id", referencedColumnName = "id")}
    )
    private List<Flight> flightList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "join_trips_with_cars",
            joinColumns = {@JoinColumn(name = "trip_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "car_id", referencedColumnName = "id")}
    )
    private List<CarReservation> carReservationList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "join_trips_with_places",
            joinColumns = {@JoinColumn(name = "trip_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "place_id", referencedColumnName = "id")}
    )
    private List<Place> placeList;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    public BigDecimal setTotalPrice() {
        BigDecimal carsPrice = carReservationList.stream().map(CarReservation::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal flightsPrice = flightList.stream().map(Flight::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal hotelsPrice = hotelReservationList.stream().map(HotelReservation::getTotalCostOfStay).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal placesPrice = placeList.stream().map(Place::getCostToEnter).reduce(BigDecimal.ZERO, BigDecimal::add);
        return totalPrice = carsPrice.add(hotelsPrice).add(flightsPrice).add(placesPrice);
    }
}
