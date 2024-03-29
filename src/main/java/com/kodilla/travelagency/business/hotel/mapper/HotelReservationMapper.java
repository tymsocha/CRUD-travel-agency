package com.kodilla.travelagency.business.hotel.mapper;

import com.kodilla.travelagency.business.hotel.api.HotelReservationDTO;
import com.kodilla.travelagency.business.hotel.domain.HotelReservation;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HotelReservationMapper {
    public HotelReservation mapHotelDTOToHotel(HotelReservationDTO hotelReservationDTO) {
        return HotelReservation.builder()
                .id(hotelReservationDTO.getId())
                .guestName(hotelReservationDTO.getGuestName())
                .hotel(hotelReservationDTO.getHotel())
                .checkIn(hotelReservationDTO.getCheckIn())
                .checkOut(hotelReservationDTO.getCheckOut())
                .isBreakfast(hotelReservationDTO.getIsBreakfast())
                .costPerNight(hotelReservationDTO.getCostPerNight())
                .numberOfDays(hotelReservationDTO.getNumberOfDays())
                .roomType(hotelReservationDTO.getRoomType())
                .totalCostOfStay(hotelReservationDTO.getTotalCostOfStay())
                .trip(hotelReservationDTO.getTrip())
                .build();
    }

    public HotelReservationDTO mapHotelToHotelDTO(HotelReservation hotelReservation) {
        return HotelReservationDTO.builder()
                .id(hotelReservation.getId())
                .guestName(hotelReservation.getGuestName())
                .hotel(hotelReservation.getHotel())
                .checkIn(hotelReservation.getCheckIn())
                .checkOut(hotelReservation.getCheckOut())
                .isBreakfast(hotelReservation.getIsBreakfast())
                .costPerNight(hotelReservation.getCostPerNight())
                .numberOfDays(hotelReservation.getNumberOfDays())
                .roomType(hotelReservation.getRoomType())
                .totalCostOfStay(hotelReservation.getTotalCostOfStay())
                .trip(hotelReservation.getTrip())
                .build();
    }

    public List<HotelReservation> mapHotleDTOListToHotelList(List<HotelReservationDTO> hotelReservationDTOList) {
        return hotelReservationDTOList.stream().map(hotelReservationDTO -> HotelReservation.builder()
                    .id(hotelReservationDTO.getId())
                    .guestName(hotelReservationDTO.getGuestName())
                    .hotel(hotelReservationDTO.getHotel())
                    .checkIn(hotelReservationDTO.getCheckIn())
                    .checkOut(hotelReservationDTO.getCheckOut())
                    .isBreakfast(hotelReservationDTO.getIsBreakfast())
                    .costPerNight(hotelReservationDTO.getCostPerNight())
                    .numberOfDays(hotelReservationDTO.getNumberOfDays())
                    .roomType(hotelReservationDTO.getRoomType())
                    .totalCostOfStay(hotelReservationDTO.getTotalCostOfStay())
                    .trip(hotelReservationDTO.getTrip())
                    .build())
                .collect(Collectors.toList());
    }

    public List<HotelReservationDTO> mapHotleListToHotelDTOList(List<HotelReservation> hotelReservationList) {
        return hotelReservationList.stream().map(hotelReservation -> HotelReservationDTO.builder()
                    .id(hotelReservation.getId())
                    .guestName(hotelReservation.getGuestName())
                    .hotel(hotelReservation.getHotel())
                    .checkIn(hotelReservation.getCheckIn())
                    .checkOut(hotelReservation.getCheckOut())
                    .isBreakfast(hotelReservation.getIsBreakfast())
                    .costPerNight(hotelReservation.getCostPerNight())
                    .numberOfDays(hotelReservation.getNumberOfDays())
                    .roomType(hotelReservation.getRoomType())
                    .totalCostOfStay(hotelReservation.getTotalCostOfStay())
                    .trip(hotelReservation.getTrip())
                    .build())
                .collect(Collectors.toList());
    }
}
