package com.kodilla.travelagency.business.hotel.mapper;

import com.kodilla.travelagency.business.hotel.api.HotelDTO;
import com.kodilla.travelagency.business.hotel.domain.Hotel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HotelMapper {
    public HotelDTO mapHotelToHotelDTO(Hotel hotel) {
        return HotelDTO.builder()
                .id(hotel.getId())
                .hotelName(hotel.getHotelName())
                .address(hotel.getAddress())
                .phoneNumber(hotel.getPhoneNumber())
                .build();
    }

    public Hotel mapHotelDTOToHotel(HotelDTO hotelDTO) {
        return Hotel.builder()
                .id(hotelDTO.getId())
                .hotelName(hotelDTO.getHotelName())
                .address(hotelDTO.getAddress())
                .phoneNumber(hotelDTO.getPhoneNumber())
                .build();
    }

    public List<Hotel> mapHotelDTOListToHotelList(List<HotelDTO> hotelDTOList) {
        return hotelDTOList.stream().map(hotelDTO -> Hotel.builder()
                    .id(hotelDTO.getId())
                    .hotelName(hotelDTO.getHotelName())
                    .address(hotelDTO.getAddress())
                    .phoneNumber(hotelDTO.getPhoneNumber())
                    .build())
                .collect(Collectors.toList());
    }

    public List<HotelDTO> mapHotelListToHotelDTOList(List<Hotel> hotelList) {
        return hotelList.stream().map(hotel -> HotelDTO.builder()
                    .id(hotel.getId())
                    .hotelName(hotel.getHotelName())
                    .address(hotel.getAddress())
                    .phoneNumber(hotel.getPhoneNumber())
                    .build())
                .collect(Collectors.toList());
    }
}
