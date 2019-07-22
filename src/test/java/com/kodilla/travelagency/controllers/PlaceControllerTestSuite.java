package com.kodilla.travelagency.controllers;

import com.google.gson.Gson;
import com.kodilla.travelagency.business.place.api.PlaceDTO;
import com.kodilla.travelagency.business.place.controller.PlacesController;
import com.kodilla.travelagency.business.place.facede.PlacesFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PlacesController.class)
public class PlaceControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlacesFacade facade;

    @Test
    public void shouldFetchAllPlaces() throws Exception {
        //Given
        PlaceDTO place = PlaceDTO.builder().placeName("Beach").country("Spain").nearestCity("Barcelona").build();
        PlaceDTO place1 = PlaceDTO.builder().placeName("Castle").country("England").nearestCity("Birmingham").build();
        PlaceDTO place2 = PlaceDTO.builder().placeName("Church").country("France").nearestCity("Paris").build();
        List<PlaceDTO> placeDTOList = new ArrayList<>();
        placeDTOList.add(place);
        placeDTOList.add(place1);
        placeDTOList.add(place2);
        //When
        when(facade.getPlaces()).thenReturn(placeDTOList);
        //Then
        mockMvc.perform(get("/v1/travel/places/getAll").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].placeName", is("Beach")))
                .andExpect(jsonPath("$[1].placeName", is("Castle")))
                .andExpect(jsonPath("$[2].placeName", is("Church")));
    }

    @Test
    public void shouldFetchPlace() throws Exception {
        //Given
        PlaceDTO place = PlaceDTO.builder().placeName("Beach").country("Spain").nearestCity("Barcelona").id(1L).build();
        //When
        when(facade.getPlace(Matchers.any())).thenReturn(place);
        //Then
        mockMvc.perform(get("/v1/travel/places/get/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.placeName", is("Beach")));
    }

    @Test
    public void shouldFetchPlaceByName() throws Exception {
        //Given
        PlaceDTO place = PlaceDTO.builder().placeName("Beach").country("Spain").nearestCity("Barcelona").id(1L).build();
        //When
        when(facade.getPlaceByName(Matchers.any())).thenReturn(place);
        //Then
        mockMvc.perform(get("/v1/travel/places/getName/Beach").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.placeName", is("Beach")));
    }

    @Test
    public void shouldSavePlace() throws Exception {
        //Given
        PlaceDTO place = PlaceDTO.builder().placeName("Beach").country("Spain").nearestCity("Barcelona").id(1L).build();
        //When
        when(facade.savePlace(Matchers.any(PlaceDTO.class))).thenReturn(place);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(place);
        //Then
        mockMvc.perform(post("/v1/travel/places/save")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(jsonPath("$.placeName", is("Beach")));
    }

    @Test
    public void shouldUpdatePlace() throws Exception {
        //Given
        PlaceDTO place = PlaceDTO.builder()
                .placeName("Beach")
                .country("Spain")
                .nearestCity("Barcelona")
                .id(1L)
                .costToEnter(BigDecimal.TEN)
                .description("Blue beach")
                .distanceFromNearestCity(26.2)
                .isMonument(true)
                .build();
        //When
        when(facade.updatePlace(Matchers.any(PlaceDTO.class))).thenReturn(place);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(place);
        //Then
        mockMvc.perform(put("/v1/travel/places/update")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(jsonPath("$.placeName", is("Beach")));
    }

    @Test
    public void shouldDeletePlace() throws Exception {
        //Given, When and Then
        mockMvc.perform(delete("/v1/travel/places/delete/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldFetchAllPlacesByCost() throws Exception {
        //Given
        PlaceDTO place = PlaceDTO.builder().placeName("Beach").country("Spain").nearestCity("Barcelona").build();
        PlaceDTO place1 = PlaceDTO.builder().placeName("Castle").country("England").nearestCity("Birmingham").build();
        PlaceDTO place2 = PlaceDTO.builder().placeName("Church").country("France").nearestCity("Paris").build();
        List<PlaceDTO> placeDTOList = new ArrayList<>();
        placeDTOList.add(place);
        placeDTOList.add(place1);
        placeDTOList.add(place2);
        //When
        when(facade.getPlacesByCost(Matchers.any())).thenReturn(placeDTOList);
        //Then
        mockMvc.perform(get("/v1/travel/places/getCost/23")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].placeName", is("Beach")))
                .andExpect(jsonPath("$[1].placeName", is("Castle")))
                .andExpect(jsonPath("$[2].placeName", is("Church")));
    }

    @Test
    public void shouldFetchAllPlacesByCountry() throws Exception {
        //Given
        PlaceDTO place = PlaceDTO.builder().placeName("Beach").country("Spain").nearestCity("Barcelona").build();
        PlaceDTO place1 = PlaceDTO.builder().placeName("Castle").country("England").nearestCity("Birmingham").build();
        PlaceDTO place2 = PlaceDTO.builder().placeName("Church").country("France").nearestCity("Paris").build();
        List<PlaceDTO> placeDTOList = new ArrayList<>();
        placeDTOList.add(place);
        placeDTOList.add(place1);
        placeDTOList.add(place2);
        //When
        when(facade.getPlacesByCountry(Matchers.any())).thenReturn(placeDTOList);
        //Then
        mockMvc.perform(get("/v1/travel/places/getAll/country/France")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].placeName", is("Beach")))
                .andExpect(jsonPath("$[1].placeName", is("Castle")))
                .andExpect(jsonPath("$[2].placeName", is("Church")));
    }

    @Test
    public void shouldFetchAllPlacesByCity() throws Exception {
        //Given
        PlaceDTO place = PlaceDTO.builder().placeName("Beach").country("Spain").nearestCity("Barcelona").build();
        PlaceDTO place1 = PlaceDTO.builder().placeName("Castle").country("England").nearestCity("Birmingham").build();
        PlaceDTO place2 = PlaceDTO.builder().placeName("Church").country("France").nearestCity("Paris").build();
        List<PlaceDTO> placeDTOList = new ArrayList<>();
        placeDTOList.add(place);
        placeDTOList.add(place1);
        placeDTOList.add(place2);
        //When
        when(facade.getPlacesByNearestCity(Matchers.any())).thenReturn(placeDTOList);
        //Then
        mockMvc.perform(get("/v1/travel/places/get/city/Paris")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].placeName", is("Beach")))
                .andExpect(jsonPath("$[1].placeName", is("Castle")))
                .andExpect(jsonPath("$[2].placeName", is("Church")));
    }

    @Test
    public void shouldFetchAllPlacesByCityAndDistance() throws Exception {
        //Given
        PlaceDTO place = PlaceDTO.builder().placeName("Beach").country("Spain").nearestCity("Barcelona").build();
        PlaceDTO place1 = PlaceDTO.builder().placeName("Castle").country("England").nearestCity("Birmingham").build();
        PlaceDTO place2 = PlaceDTO.builder().placeName("Church").country("France").nearestCity("Paris").build();
        List<PlaceDTO> placeDTOList = new ArrayList<>();
        placeDTOList.add(place);
        placeDTOList.add(place1);
        placeDTOList.add(place2);
        //When
        when(facade.getPlacesByNearestCityAndDistance(Matchers.any(), Matchers.any())).thenReturn(placeDTOList);
        //Then
        mockMvc.perform(get("/v1/travel/places/get/city/Paris/dist/26")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].placeName", is("Beach")))
                .andExpect(jsonPath("$[1].placeName", is("Castle")))
                .andExpect(jsonPath("$[2].placeName", is("Church")));
    }

    @Test
    public void shouldFetchAllPlacesByMonument() throws Exception {
        //Given
        PlaceDTO place = PlaceDTO.builder().placeName("Beach").country("Spain").nearestCity("Barcelona").build();
        PlaceDTO place1 = PlaceDTO.builder().placeName("Castle").country("England").nearestCity("Birmingham").build();
        PlaceDTO place2 = PlaceDTO.builder().placeName("Church").country("France").nearestCity("Paris").build();
        List<PlaceDTO> placeDTOList = new ArrayList<>();
        placeDTOList.add(place);
        placeDTOList.add(place1);
        placeDTOList.add(place2);
        //When
        when(facade.getPlacesByMonumentStatus(Matchers.any())).thenReturn(placeDTOList);
        //Then
        mockMvc.perform(get("/v1/travel/places/get/monument/true")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].placeName", is("Beach")))
                .andExpect(jsonPath("$[1].placeName", is("Castle")))
                .andExpect(jsonPath("$[2].placeName", is("Church")));
    }
}
