package com.kodilla.travelagency.mappers;

import com.kodilla.travelagency.business.hotel.api.HotelDTO;
import com.kodilla.travelagency.business.hotel.domain.Hotel;
import com.kodilla.travelagency.business.hotel.mapper.HotelMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HotelMapperTestSuite {
    @Autowired
    private HotelMapper mapper;

    @Test
    public void testMapHotelToHotelDTO() {
        //Given
        Hotel radisson = new Hotel(1L, "Radisson", "London", "123456789");
        //When
        HotelDTO radissonDTO = mapper.mapHotelToHotelDTO(radisson);
        //Then
        assertEquals("Radisson", radissonDTO.getHotelName());
        assertEquals("London", radissonDTO.getAddress());
        assertEquals("123456789", radissonDTO.getPhoneNumber());
    }

    @Test
    public void testHotelDTOToHotel() {
        //Given
        HotelDTO radissonDTO = new HotelDTO(1L, "Radisson", "London", "123456789");
        //When
        Hotel radisson = mapper.mapHotelDTOToHotel(radissonDTO);
        //Then
        assertEquals("Radisson", radisson.getHotelName());
        assertEquals("London", radisson.getAddress());
        assertEquals("123456789", radisson.getPhoneNumber());
    }

    @Test
    public void testMapHotelListToHotelDTOList() {
        //Given
        Hotel radisson = new Hotel(1L, "Radisson", "London", "123456789");
        Hotel hilton = new Hotel(1L, "Hilton", "London", "123456789");
        Hotel marriott = new Hotel(1L, "Marriott", "London", "123456789");
        List<Hotel> hotelList = new ArrayList<>();
        hotelList.add(radisson);
        hotelList.add(hilton);
        hotelList.add(marriott);
        //When
        List<HotelDTO> hotelDTOS = mapper.mapHotelListToHotelDTOList(hotelList);
        //Then
        assertEquals(3, hotelDTOS.size());
    }

    @Test
    public void testMapHotelDTOListTOHotelList() {
        //Given
        HotelDTO radissonDTO = new HotelDTO(1L, "Radisson", "London", "123456789");
        HotelDTO hiltonDTO = new HotelDTO(1L, "Hilton", "London", "123456789");
        HotelDTO marriottDTO = new HotelDTO(1L, "Marriott", "London", "123456789");
        List<HotelDTO> hotelDTOList = new ArrayList<>();
        hotelDTOList.add(radissonDTO);
        hotelDTOList.add(hiltonDTO);
        hotelDTOList.add(marriottDTO);
        //When
        List<Hotel> hotelList = mapper.mapHotelDTOListToHotelList(hotelDTOList);
        //Then
        assertEquals(3, hotelList.size());

    }
}
