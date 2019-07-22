package com.kodilla.travelagency.controllers;

import com.google.gson.Gson;
import com.kodilla.travelagency.business.flights.api.AirlineDTO;
import com.kodilla.travelagency.business.flights.controller.AirlineController;
import com.kodilla.travelagency.business.flights.facede.AirlineFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AirlineController.class)
public class AirlineControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AirlineFacade facade;

    @Test
    public void shouldFetchAll() throws Exception {
        //Given
        AirlineDTO airline = AirlineDTO.builder().name("LH").address("FRA").phoneNumber("123").build();
        AirlineDTO airline1 = AirlineDTO.builder().name("LO").address("WAW").phoneNumber("456").build();
        AirlineDTO airline2 = AirlineDTO.builder().name("BA").address("LON").phoneNumber("789").build();
        List<AirlineDTO> airlineDTOS = new ArrayList<>();
        airlineDTOS.add(airline);
        airlineDTOS.add(airline1);
        airlineDTOS.add(airline2);
        //When
        when(facade.getAirlines()).thenReturn(airlineDTOS);
        //Then
        mockMvc.perform(get("/v1/travel/airlines/getAll")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    public void shouldFetchAirline() throws Exception {
        //Given
        AirlineDTO airline = AirlineDTO.builder().name("LH").address("FRA").phoneNumber("123").build();
        //When
        when(facade.getAirline(Matchers.any())).thenReturn(airline);
        //Then
        mockMvc.perform(get("/v1/travel/airlines/get/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("LH")));
    }

    @Test
    public void shouldFetchAirlineByParameter() throws Exception {
        //Given
        AirlineDTO airline = AirlineDTO.builder().name("LH").address("FRA").phoneNumber("123").build();
        //When
        when(facade.getAirlineByParameter(Matchers.any())).thenReturn(airline);
        //Then
        mockMvc.perform(get("/v1/travel/airlines/getParameter/param").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("LH")));
    }

    @Test
    public void shouldAddAirline() throws Exception {
        //Given
        AirlineDTO airline = AirlineDTO.builder().name("LH").address("FRA").phoneNumber("123").build();
        //When
        when(facade.addAirline(Matchers.any(AirlineDTO.class))).thenReturn(airline);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(airline);
        //Then
        mockMvc.perform(post("/v1/travel/airlines/add")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(jsonPath("$.name", is("LH")));
    }

    @Test
    public void shouldUpdatePlace() throws Exception {
        //Given
        AirlineDTO airline = AirlineDTO.builder().name("LH").address("FRA").phoneNumber("123").build();
        //When
        when(facade.updateAirline(Matchers.any(AirlineDTO.class))).thenReturn(airline);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(airline);
        //Then
        mockMvc.perform(put("/v1/travel/airlines/update")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(jsonPath("$.name", is("LH")));
    }

    @Test
    public void shouldDeletePlace() throws Exception {
        //Given, When and Then
        mockMvc.perform(delete("/v1/travel/airlines/delete/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
