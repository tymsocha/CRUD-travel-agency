package com.kodilla.travelagency.mappers;

import com.kodilla.travelagency.business.place.api.PlaceDTO;
import com.kodilla.travelagency.business.place.domain.Place;
import com.kodilla.travelagency.business.place.mapper.PlaceMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PlaceMapperTestSuite {
    @Autowired
    private PlaceMapper mapper;

    @Test
    public void testMapPlaceToPlaceDTO() {
        //Given
        Place toledoBeach = new Place(1L, "Beach", "Spain", "Blue Beach",
                BigDecimal.ONE, true, "Toledo", 26.2);
        //When
        PlaceDTO toledoBeachDTO = mapper.mapPlaceToPlaceDTO(toledoBeach);
        //Then
        assertEquals("Beach", toledoBeachDTO.getPlaceName());
        assertEquals("Spain", toledoBeachDTO.getCountry());
        assertEquals("Toledo", toledoBeachDTO.getNearestCity());
    }

    @Test
    public void testMapPlaceDTOToPlace() {
        //Given
        PlaceDTO toledoBeachDTO = new PlaceDTO(1L, "Beach", "Spain", "Blue Beach",
                BigDecimal.ONE, true, "Toledo", 26.2);
        //When
        Place toledoBeach = mapper.mapPlaceDTOToPlace(toledoBeachDTO);
        //Then
        assertEquals("Beach", toledoBeach.getPlaceName());
        assertEquals("Spain", toledoBeach.getCountry());
        assertEquals("Toledo", toledoBeach.getNearestCity());
    }

    @Test
    public void testMapPlaceListToPlaceDTOList() {
        //Given
        Place toledoBeach = new Place(1L, "Beach", "Spain", "Blue Beach",
                BigDecimal.ONE, true, "Toledo", 26.2);
        Place zakhyntosBeach = new Place(1L, "Beach", "Spain", "Blue Beach",
                BigDecimal.ONE, true, "Toledo", 26.2);
        Place budapestCastle = new Place(1L, "Beach", "Spain", "Blue Beach",
                BigDecimal.ONE, true, "Toledo", 26.2);
        List<Place> placeList = new ArrayList<>();
        placeList.add(toledoBeach);
        placeList.add(zakhyntosBeach);
        placeList.add(budapestCastle);
        //When
        List<PlaceDTO> placeDTOList = mapper.mapPlaceListToPlaceDTOList(placeList);
        //Then
        assertEquals(3, placeDTOList.size());
    }

    @Test
    public void testMapPlaceDTOListToPlaceList() {
        //Given
        PlaceDTO toledoBeachDTO = new PlaceDTO(1L, "Beach", "Spain", "Blue Beach",
                BigDecimal.ONE, true, "Toledo", 26.2);
        PlaceDTO zakhyntosBeachDTO = new PlaceDTO(1L, "Beach", "Spain", "Blue Beach",
                BigDecimal.ONE, true, "Toledo", 26.2);
        PlaceDTO budapestCastleDTO = new PlaceDTO(1L, "Beach", "Spain", "Blue Beach",
                BigDecimal.ONE, true, "Toledo", 26.2);
        List<PlaceDTO> placeListDTO = new ArrayList<>();
        placeListDTO.add(toledoBeachDTO);
        placeListDTO.add(zakhyntosBeachDTO);
        placeListDTO.add(budapestCastleDTO);
        //When
        List<Place> placeList = mapper.mapPlaceDTOListToPlaceList(placeListDTO);
        //Then
        assertEquals(3, placeList.size());
    }
}
