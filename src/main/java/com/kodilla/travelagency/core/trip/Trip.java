package com.kodilla.travelagency.core.trip;

import com.kodilla.travelagency.core.car.CarReservation;
import com.kodilla.travelagency.core.flight.Flight;
import com.kodilla.travelagency.core.flight.Ticket;
import com.kodilla.travelagency.core.hotel.HotelReservation;
import com.kodilla.travelagency.core.places.Place;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity(name = "trips")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "trip_name")
    private String tripName;

    @OneToMany(mappedBy = "trip")
    @LazyCollection(LazyCollectionOption.TRUE)
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "trip")
    @LazyCollection(LazyCollectionOption.TRUE)
    private List<CarReservation> carReservations;

    @OneToMany(mappedBy = "trip")
    @LazyCollection(LazyCollectionOption.TRUE)
    private List<HotelReservation> hotelReservations;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "join_trips_with_places",
            joinColumns = {@JoinColumn(name = "trip_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "place_id", referencedColumnName = "id")}
    )
    private List<Place> placeList;

    @Column(name = "total_price")
    private BigDecimal totalPrice;
}
