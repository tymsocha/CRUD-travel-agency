package com.kodilla.travelagency.business.hotel.api;

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
