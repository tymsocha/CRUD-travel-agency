package com.kodilla.travelagency.business.hotel.facede;

import com.kodilla.travelagency.business.hotel.api.HotelDTO;
import com.kodilla.travelagency.business.hotel.mapper.HotelMapper;
import com.kodilla.travelagency.business.hotel.service.HotelService;
import com.kodilla.travelagency.exceptions.HotelNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HotelFacade {
    @Autowired
    private HotelService hotelService;

    @Autowired
    private HotelMapper hotelMapper;

    public List<HotelDTO> getHotels() {
        return hotelMapper.mapHotelListToHotelDTOList(hotelService.getAllHotels());
    }

    public HotelDTO getHotel(Long hotelId) throws HotelNotFoundException {
        return hotelMapper.mapHotelToHotelDTO(hotelService.findHotelById(hotelId));
    }

    public HotelDTO getHotel(String parameter) throws HotelNotFoundException {
        return hotelMapper.mapHotelToHotelDTO(hotelService.findHotelByParameter(parameter));
    }

    public HotelDTO addHotel(HotelDTO hotelDTO) {
        return hotelMapper.mapHotelToHotelDTO(hotelService.saveOrUpdateHotel(hotelMapper.mapHotelDTOToHotel(hotelDTO)));
    }

    public HotelDTO updateHotel(HotelDTO hotelDTO) {
        return hotelMapper.mapHotelToHotelDTO(hotelService.saveOrUpdateHotel(hotelMapper.mapHotelDTOToHotel(hotelDTO)));
    }

    public void deleteHotel(Long hotelId) {
        hotelService.deleteHotel(hotelId);
    }

}
