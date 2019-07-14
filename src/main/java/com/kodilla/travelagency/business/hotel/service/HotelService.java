package com.kodilla.travelagency.business.hotel.service;

import com.kodilla.travelagency.business.hotel.dao.HotelDAO;
import com.kodilla.travelagency.business.hotel.domain.Hotel;
import com.kodilla.travelagency.exceptions.HotelNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    @Autowired
    private HotelDAO hotelDAO;

    public List<Hotel> getAllHotels() {
        return hotelDAO.findAll();
    }

    public Hotel findHotelByParameter(String parameter) throws HotelNotFoundException {
        return hotelDAO.findByAddressOrHotelNameOrPhoneNumber(parameter, parameter, parameter)
                .orElseThrow(HotelNotFoundException::new);
    }

    public Hotel saveOrUpdateHotel(Hotel hotel) {
        return hotelDAO.save(hotel);
    }

    public Hotel findHotelById(Long hotelId) throws HotelNotFoundException {
        return hotelDAO.findById(hotelId).orElseThrow(HotelNotFoundException::new);
    }

    public void deleteHotel(Long hotelId) throws HotelNotFoundException {
        hotelDAO.deleteHotelById(hotelId).orElseThrow(HotelNotFoundException::new);
    }
}
