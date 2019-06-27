package com.kodilla.travelagency.dto.flight;

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
