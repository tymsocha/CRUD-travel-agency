package com.kodilla.travelagency.business.car.api;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CarTypeDTO {
    private Long id;

    private Boolean isAutomatic;

    private Integer numberOfDoors;

    private Boolean withAC;

    private Boolean withGPS;
}
