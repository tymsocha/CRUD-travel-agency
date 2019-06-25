package com.kodilla.travelagency.core.places;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "country")
    private String country;

    @Column(name = "description")
    private String description;

    @Column(name = "cost")
    private BigDecimal costToEnter;

    @Column(name = "is_monument")
    private Boolean isMonument;

    @Column(name = "nearest_city")
    private String nearestCity;

    @Column(name = "distance_from_city")
    private Double distanceFromNearestCity;
}
