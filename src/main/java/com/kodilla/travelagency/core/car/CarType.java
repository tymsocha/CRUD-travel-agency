package com.kodilla.travelagency.core.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "carTypes")
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
