package com.kodilla.travelagency.mapper.hotel;

import com.kodilla.travelagency.core.hotel.Hotel;
import com.kodilla.travelagency.dto.hotel.HotelDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HotelMapper {
    public Hotel mapHotelDTOToHotel(HotelDTO hotelDTO) {
        return Hotel.builder()
                .id(hotelDTO.getId())
                .checkIn(hotelDTO.getCheckIn())
                .checkOut(hotelDTO.getCheckOut())
                .isBreakfast(hotelDTO.getIsBreakfast())
                .costPerNight(hotelDTO.getCostPerNight())
                .numberOfDays(hotelDTO.getNumberOfDays())
                .roomType(hotelDTO.getRoomType())
                .totalCostOfStay(hotelDTO.getTotalCostOfStay())
                .build();
    }

    public HotelDTO mapHotelToHotelDTO(Hotel hotel) {
        return HotelDTO.builder()
                .id(hotel.getId())
                .checkIn(hotel.getCheckIn())
                .checkOut(hotel.getCheckOut())
                .isBreakfast(hotel.getIsBreakfast())
                .costPerNight(hotel.getCostPerNight())
                .numberOfDays(hotel.getNumberOfDays())
                .roomType(hotel.getRoomType())
                .totalCostOfStay(hotel.getTotalCostOfStay())
                .build();
    }

    public List<Hotel> mapHotleDTOListToHotelList(List<HotelDTO> hotelDTOList) {
        return hotelDTOList.stream().map(hotelDTO -> Hotel.builder()
                    .id(hotelDTO.getId())
                    .checkIn(hotelDTO.getCheckIn())
                    .checkOut(hotelDTO.getCheckOut())
                    .isBreakfast(hotelDTO.getIsBreakfast())
                    .costPerNight(hotelDTO.getCostPerNight())
                    .numberOfDays(hotelDTO.getNumberOfDays())
                    .roomType(hotelDTO.getRoomType())
                    .totalCostOfStay(hotelDTO.getTotalCostOfStay())
                    .build())
                .collect(Collectors.toList());
    }

    public List<HotelDTO> mapHotleListToHotelDTOList(List<Hotel> hotelList) {
        return hotelList.stream().map(hotel -> HotelDTO.builder()
                .id(hotel.getId())
                .checkIn(hotel.getCheckIn())
                .checkOut(hotel.getCheckOut())
                .isBreakfast(hotel.getIsBreakfast())
                .costPerNight(hotel.getCostPerNight())
                .numberOfDays(hotel.getNumberOfDays())
                .roomType(hotel.getRoomType())
                .totalCostOfStay(hotel.getTotalCostOfStay())
                .build())
                .collect(Collectors.toList());
    }
}
