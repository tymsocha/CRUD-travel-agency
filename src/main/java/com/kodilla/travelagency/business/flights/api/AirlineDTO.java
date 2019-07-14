package com.kodilla.travelagency.business.flights.api;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AirlineDTO {
    private Long id;

    private String name;

    private String address;

    private String phoneNumber;
}
