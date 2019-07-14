package com.kodilla.travelagency.business.flights.api;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonApi {
    @ApiModelProperty
    private String firstName;

    @ApiModelProperty
    private String lastName;
}
