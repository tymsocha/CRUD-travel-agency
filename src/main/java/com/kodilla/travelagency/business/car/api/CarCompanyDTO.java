package com.kodilla.travelagency.business.car.api;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CarCompanyDTO {
    private Long id;

    private String carCompanyName;

    private String address;

    private String phoneNumber;
}
