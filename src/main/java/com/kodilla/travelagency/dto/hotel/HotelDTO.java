package com.kodilla.travelagency.dto.hotel;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelDTO {
    private Long id;

    private String hotelName;

    private String address;

    private String phoneNumber;
}
