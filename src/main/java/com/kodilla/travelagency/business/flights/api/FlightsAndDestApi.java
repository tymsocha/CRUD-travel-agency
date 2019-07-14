package com.kodilla.travelagency.business.flights.api;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlightsAndDestApi {
    @ApiModelProperty
    private String origin;

    @ApiModelProperty
    private String destination;

    @ApiModelProperty
    private String departureDate;

    @ApiModelProperty
    private String arrivalDate;
}
