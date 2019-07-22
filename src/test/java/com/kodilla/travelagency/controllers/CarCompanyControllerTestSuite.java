package com.kodilla.travelagency.controllers;

import com.google.gson.Gson;
import com.kodilla.travelagency.business.car.api.CarCompanyDTO;
import com.kodilla.travelagency.business.car.controller.CarCompanyController;
import com.kodilla.travelagency.business.car.domain.CarCompany;
import com.kodilla.travelagency.business.car.facede.CarCompanyFacade;
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
@WebMvcTest(CarCompanyController.class)
public class CarCompanyControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarCompanyFacade facade;

    @Test
    public void shouldFetchAll() throws Exception {
        //Given
        CarCompanyDTO carCompany = CarCompanyDTO.builder().carCompanyName("LH").address("FRA").phoneNumber("123").build();
        CarCompanyDTO carCompany1 = CarCompanyDTO.builder().carCompanyName("LO").address("WAW").phoneNumber("456").build();
        CarCompanyDTO carCompany2 = CarCompanyDTO.builder().carCompanyName("BA").address("LON").phoneNumber("789").build();
        List<CarCompanyDTO> carCompanyDTOS = new ArrayList<>();
        carCompanyDTOS.add(carCompany);
        carCompanyDTOS.add(carCompany1);
        carCompanyDTOS.add(carCompany2);
        //When
        when(facade.getCarCompanies()).thenReturn(carCompanyDTOS);
        //Then
        mockMvc.perform(get("/v1/travel/carCompanies/getAll")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    public void shouldFetchCarCompany() throws Exception {
        //Given
        CarCompanyDTO carCompany = CarCompanyDTO.builder().carCompanyName("LH").address("FRA").phoneNumber("123").build();
        //When
        when(facade.getCarCompany(Matchers.any())).thenReturn(carCompany);
        //Then
        mockMvc.perform(get("/v1/travel/carCompanies/get/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.carCompanyName", is("LH")));
    }

    @Test
    public void shouldFetchCarCompanyByName() throws Exception {
        //Given
        CarCompanyDTO carCompany = CarCompanyDTO.builder().carCompanyName("LH").address("FRA").phoneNumber("123").build();
        //When
        when(facade.getCarCompanyByName(Matchers.any())).thenReturn(carCompany);
        //Then
        mockMvc.perform(get("/v1/travel/carCompanies/getParameter/param").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.carCompanyName", is("LH")));
    }

    @Test
    public void shouldAddCarCompany() throws Exception {
        //Given
        CarCompanyDTO carCompany = CarCompanyDTO.builder().carCompanyName("LH").address("FRA").phoneNumber("123").build();
        //When
        when(facade.addCarCompany(Matchers.any(CarCompanyDTO.class))).thenReturn(carCompany);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(carCompany);
        //Then
        mockMvc.perform(post("/v1/travel/carCompanies/add")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(jsonPath("$.carCompanyName", is("LH")));
    }

    @Test
    public void shouldUpdateCarCompany() throws Exception {
        //Given
        CarCompanyDTO carCompany = CarCompanyDTO.builder().carCompanyName("LH").address("FRA").phoneNumber("123").build();
        //When
        when(facade.updateCarCompany(Matchers.any(CarCompanyDTO.class))).thenReturn(carCompany);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(carCompany);
        //Then
        mockMvc.perform(put("/v1/travel/carCompanies/update")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(jsonPath("$.carCompanyName", is("LH")));
    }

    @Test
    public void shouldDeleteCarCompany() throws Exception {
        //Given, When and Then
        mockMvc.perform(delete("/v1/travel/carCompanies/delete/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
