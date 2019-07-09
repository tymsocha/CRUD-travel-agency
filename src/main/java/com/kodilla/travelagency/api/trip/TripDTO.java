package com.kodilla.travelagency.api.trip;

import com.kodilla.travelagency.core.places.Place;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TripDTO {
    private Long id;

    private String tripName;

    private List<Place> placeList;

    private BigDecimal totalPrice;
}
