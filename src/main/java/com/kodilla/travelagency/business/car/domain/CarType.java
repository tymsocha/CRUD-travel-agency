package com.kodilla.travelagency.business.car.domain;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
@Getter
@Entity(name = "car_types")
public class CarType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "is_automatic")
    private Boolean isAutomatic;

    @Column(name = "door_number")
    private Integer numberOfDoors;

    @Column(name = "is_ac")
    private Boolean withAC;

    @Column(name = "is_gps")
    private Boolean withGPS;
}
