package com.kodilla.travelagency.mapper.hotel;

import com.kodilla.travelagency.core.hotel.HotelReservation;
import com.kodilla.travelagency.dto.hotel.HotelReservationDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HotelReservationMapper {
    public HotelReservation mapHotelDTOToHotel(HotelReservationDTO hotelReservationDTO) {
        return HotelReservation.builder()
                .id(hotelReservationDTO.getId())
                .hotelName(hotelReservationDTO.getHotelName())
                .checkIn(hotelReservationDTO.getCheckIn())
                .checkOut(hotelReservationDTO.getCheckOut())
                .isBreakfast(hotelReservationDTO.getIsBreakfast())
                .costPerNight(hotelReservationDTO.getCostPerNight())
                .numberOfDays(hotelReservationDTO.getNumberOfDays())
                .roomType(hotelReservationDTO.getRoomType())
                .totalCostOfStay(hotelReservationDTO.getTotalCostOfStay())
                .build();
    }

    public HotelReservationDTO mapHotelToHotelDTO(HotelReservation hotelReservation) {
        return HotelReservationDTO.builder()
                .id(hotelReservation.getId())
                .hotelName(hotelReservation.getHotelName())
                .checkIn(hotelReservation.getCheckIn())
                .checkOut(hotelReservation.getCheckOut())
                .isBreakfast(hotelReservation.getIsBreakfast())
                .costPerNight(hotelReservation.getCostPerNight())
                .numberOfDays(hotelReservation.getNumberOfDays())
                .roomType(hotelReservation.getRoomType())
                .totalCostOfStay(hotelReservation.getTotalCostOfStay())
                .build();
    }

    public List<HotelReservation> mapHotleDTOListToHotelList(List<HotelReservationDTO> hotelReservationDTOList) {
        return hotelReservationDTOList.stream().map(hotelReservationDTO -> HotelReservation.builder()
                    .id(hotelReservationDTO.getId())
                    .hotelName(hotelReservationDTO.getHotelName())
                    .checkIn(hotelReservationDTO.getCheckIn())
                    .checkOut(hotelReservationDTO.getCheckOut())
                    .isBreakfast(hotelReservationDTO.getIsBreakfast())
                    .costPerNight(hotelReservationDTO.getCostPerNight())
                    .numberOfDays(hotelReservationDTO.getNumberOfDays())
                    .roomType(hotelReservationDTO.getRoomType())
                    .totalCostOfStay(hotelReservationDTO.getTotalCostOfStay())
                    .build())
                .collect(Collectors.toList());
    }

    public List<HotelReservationDTO> mapHotleListToHotelDTOList(List<HotelReservation> hotelReservationList) {
        return hotelReservationList.stream().map(hotelReservation -> HotelReservationDTO.builder()
                .id(hotelReservation.getId())
                .hotelName(hotelReservation.getHotelName())
                .checkIn(hotelReservation.getCheckIn())
                .checkOut(hotelReservation.getCheckOut())
                .isBreakfast(hotelReservation.getIsBreakfast())
                .costPerNight(hotelReservation.getCostPerNight())
                .numberOfDays(hotelReservation.getNumberOfDays())
                .roomType(hotelReservation.getRoomType())
                .totalCostOfStay(hotelReservation.getTotalCostOfStay())
                .build())
                .collect(Collectors.toList());
    }
}
