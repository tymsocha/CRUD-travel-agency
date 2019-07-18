package com.kodilla.travelagency.business.place.api;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaceDTO {
    private Long id;

    private String placeName;

    private String country;

    private String description;

    private BigDecimal costToEnter;

    private Boolean isMonument;

    private String nearestCity;

    private Double distanceFromNearestCity;
}
