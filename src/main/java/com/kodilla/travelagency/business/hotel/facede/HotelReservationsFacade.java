package com.kodilla.travelagency.business.hotel.facede;

import com.kodilla.travelagency.business.hotel.RoomType;
import com.kodilla.travelagency.business.hotel.api.HotelReservationDTO;
import com.kodilla.travelagency.business.hotel.mapper.HotelReservationMapper;
import com.kodilla.travelagency.business.hotel.service.HotelReservationService;
import com.kodilla.travelagency.exceptions.HotelNotFoundException;
import com.kodilla.travelagency.exceptions.HotelReservationNotFound;
import com.kodilla.travelagency.exceptions.TripNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HotelReservationsFacade {
    @Autowired
    private HotelReservationService hotelService;

    @Autowired
    private HotelReservationMapper hotelMapper;

    public List<HotelReservationDTO> getHotelReservations() {
        return hotelMapper.mapHotleListToHotelDTOList(hotelService.getAllHotelReservations());
    }

    public HotelReservationDTO getHotelReservation(Long hotelReservationId) throws HotelReservationNotFound {
        return hotelMapper.mapHotelToHotelDTO(hotelService.findHotelReservationById(hotelReservationId));
    }

    public HotelReservationDTO createHotelReservation(HotelReservationDTO hotelReservationDTO) {
        return hotelMapper.mapHotelToHotelDTO(hotelService.createOrUpdateHotelReservation(hotelMapper.mapHotelDTOToHotel(hotelReservationDTO)));
    }

    public HotelReservationDTO updateHotelReservation(HotelReservationDTO hotelReservationDTO) {
        return hotelMapper.mapHotelToHotelDTO(hotelService.createOrUpdateHotelReservation(hotelMapper.mapHotelDTOToHotel(hotelReservationDTO)));
    }

    public void deleteHotelReservation(Long hotelReservationId) throws HotelReservationNotFound {
        hotelService.deleteHotelReservation(hotelReservationId);
    }

    public List<HotelReservationDTO> getHotelReservationsByHotel(Long hotelId) throws HotelNotFoundException {
        return hotelMapper.mapHotleListToHotelDTOList(hotelService.getAllHotelReservationsByHotel(hotelId));
    }

    public List<HotelReservationDTO> getHotelReservationsByTrip(Long tripId) throws TripNotFoundException {
        return hotelMapper.mapHotleListToHotelDTOList(hotelService.getAllHotelReservationsByTrip(tripId));
    }

    public List<HotelReservationDTO> getHotelReservationsWithBreakFast(Boolean isBreakfast) {
        return hotelMapper.mapHotleListToHotelDTOList(hotelService.getAllHotelReservationsByBreakfast(isBreakfast));
    }

    public List<HotelReservationDTO> getHotelsByRoomType(RoomType roomType) {
        return hotelMapper.mapHotleListToHotelDTOList(hotelService.getAllHotelReservationsByRoomType(roomType));
    }

    public List<HotelReservationDTO> getHotelsByGuestName(String guestName) {
        return hotelMapper.mapHotleListToHotelDTOList(hotelService.findHotelReservationByGuestName(guestName));
    }
}
