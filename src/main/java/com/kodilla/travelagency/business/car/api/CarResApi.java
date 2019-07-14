package com.kodilla.travelagency.business.car.api;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CarResApi {
    @ApiModelProperty
    private String tripName;

    @ApiModelProperty
    private String rentStart;
}
