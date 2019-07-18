package com.kodilla.travelagency.services;

import com.kodilla.travelagency.business.hotel.dao.HotelDAO;
import com.kodilla.travelagency.business.hotel.domain.Hotel;
import com.kodilla.travelagency.business.hotel.service.HotelService;
import com.kodilla.travelagency.exceptions.HotelNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HotelServiceTestSuite {
    @Autowired
    private HotelService service;

    @Autowired
    private HotelDAO dao;

    @Test
    public void shouldGetAllHotels() {
        //Given
        Hotel hotel = Hotel.builder().hotelName("Radisson").address("FRA").phoneNumber("321").build();
        Hotel hotel1 = Hotel.builder().hotelName("Marriott").address("LON").phoneNumber("123").build();
        Hotel hotel2 = Hotel.builder().hotelName("Hilton").address("GVA").phoneNumber("789").build();
        dao.save(hotel);
        dao.save(hotel1);
        dao.save(hotel2);
        //When
        List<Hotel> hotels = service.getAllHotels();
        //Then
        assertEquals(3, hotels.size());
        //CleanUp
        dao.delete(hotel);
        dao.delete(hotel1);
        dao.delete(hotel2);
    }

    @Test
    public void shouldFindHotelById() {
        //Given
        Hotel hotel = Hotel.builder().hotelName("Hilton").address("GVA").phoneNumber("789").build();
        Hotel savedHotel = dao.save(hotel);
        //When and then
        try {
            Hotel foundHotel = service.findHotelById(savedHotel.getId());
            assertEquals("GVA", foundHotel.getAddress());
            assertEquals("789", foundHotel.getPhoneNumber());
            assertEquals("Hilton", foundHotel.getHotelName());
        } catch (HotelNotFoundException e) {
            e.printStackTrace();
        }
        //Clean Up
        dao.delete(savedHotel);
    }

    @Test
    public void shouldDeleteHotel() {
        //Given
        Hotel hotel = Hotel.builder().hotelName("Hilton").address("GVA").phoneNumber("789").build();
        Hotel savedHotel = dao.save(hotel);
        //When
        service.deleteHotel(savedHotel.getId());
        List<Hotel> hotels = service.getAllHotels();
        //Then
        assertEquals(0, hotels.size());
    }
}
