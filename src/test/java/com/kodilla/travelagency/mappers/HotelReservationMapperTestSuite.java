package com.kodilla.travelagency.mappers;

import com.kodilla.travelagency.business.hotel.RoomType;
import com.kodilla.travelagency.business.hotel.api.HotelReservationDTO;
import com.kodilla.travelagency.business.hotel.domain.HotelReservation;
import com.kodilla.travelagency.business.hotel.mapper.HotelReservationMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HotelReservationMapperTestSuite {

    @Autowired
    private HotelReservationMapper mapper;

    @Test
    public void testMapHotelResToHotelResDTO() {
        //Given
        HotelReservation hotelReservation = new HotelReservation(1L, "Tim Roth", RoomType.STANDARD,
                true, LocalDateTime.now(), LocalDateTime.of(2019, 7, 17, 5, 12),
                BigDecimal.ONE, BigDecimal.TEN, BigDecimal.ZERO, null, null);
        //When
        HotelReservationDTO hotelReservationDTO = mapper.mapHotelToHotelDTO(hotelReservation);
        //Then
        assertEquals("Tim Roth", hotelReservationDTO.getGuestName());
    }

    @Test
    public void testMapHotelResDTOToHotelRes() {
        //Given
        HotelReservationDTO hotelReservationDTO = new HotelReservationDTO(1L, "Tim Roth", RoomType.STANDARD,
                true, LocalDateTime.now(), LocalDateTime.of(2019, 7, 17, 5, 12),
                BigDecimal.ONE, BigDecimal.TEN, BigDecimal.ZERO, null, null);
        //When
        HotelReservation hotelReservation = mapper.mapHotelDTOToHotel(hotelReservationDTO);
        //Then
        assertEquals("Tim Roth", hotelReservation.getGuestName());
    }

    @Test
    public void testMapHotelResDTOListToHotelResList() {
        //Given
        HotelReservationDTO hotelReservationDTO = new HotelReservationDTO(1L, "Tim Roth", RoomType.STANDARD,
                true, LocalDateTime.now(), LocalDateTime.of(2019, 7, 17, 5, 12),
                BigDecimal.ONE, BigDecimal.TEN, BigDecimal.ZERO, null, null);
        HotelReservationDTO hotelReservationDTO1 = new HotelReservationDTO(1L, "Brad Pitt", RoomType.STANDARD,
                true, LocalDateTime.now(), LocalDateTime.of(2019, 7, 17, 5, 12),
                BigDecimal.ONE, BigDecimal.TEN, BigDecimal.ZERO, null, null);
        HotelReservationDTO hotelReservationDTO2 = new HotelReservationDTO(1L, "Angelina Jolie", RoomType.STANDARD,
                true, LocalDateTime.now(), LocalDateTime.of(2019, 7, 17, 5, 12),
                BigDecimal.ONE, BigDecimal.TEN, BigDecimal.ZERO, null, null);
        List<HotelReservationDTO> hotelReservationDTOList = new ArrayList<>();
        hotelReservationDTOList.add(hotelReservationDTO);
        hotelReservationDTOList.add(hotelReservationDTO1);
        hotelReservationDTOList.add(hotelReservationDTO2);
        //When
        List<HotelReservation> hotelReservationList = mapper.mapHotleDTOListToHotelList(hotelReservationDTOList);
        //Then
        assertEquals(3, hotelReservationList.size());
    }

    @Test
    public void testMapHotelResListToHotelResDTOList() {
        //Given
        HotelReservation hotelReservation = new HotelReservation(1L, "Tim Roth", RoomType.STANDARD,
                true, LocalDateTime.now(), LocalDateTime.of(2019, 7, 17, 5, 12),
                BigDecimal.ONE, BigDecimal.TEN, BigDecimal.ZERO, null, null);
        HotelReservation hotelReservation1 = new HotelReservation(1L, "Brad Pitt", RoomType.STANDARD,
                true, LocalDateTime.now(), LocalDateTime.of(2019, 7, 17, 5, 12),
                BigDecimal.ONE, BigDecimal.TEN, BigDecimal.ZERO, null, null);
        HotelReservation hotelReservation2 = new HotelReservation(1L, "Angelina Jolie", RoomType.STANDARD,
                true, LocalDateTime.now(), LocalDateTime.of(2019, 7, 17, 5, 12),
                BigDecimal.ONE, BigDecimal.TEN, BigDecimal.ZERO, null, null);
        List<HotelReservation> hotelReservationList = new ArrayList<>();
        hotelReservationList.add(hotelReservation);
        hotelReservationList.add(hotelReservation1);
        hotelReservationList.add(hotelReservation2);
        //When
        List<HotelReservationDTO> hotelReservationDTOList = mapper.mapHotleListToHotelDTOList(hotelReservationList);
        //Then
        assertEquals(3, hotelReservationDTOList.size());
    }
}
