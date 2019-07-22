package com.kodilla.travelagency.controllers;

import com.google.gson.Gson;
import com.kodilla.travelagency.business.car.api.CarCompanyDTO;
import com.kodilla.travelagency.business.car.api.CarTypeDTO;
import com.kodilla.travelagency.business.car.controller.CarTypeController;
import com.kodilla.travelagency.business.car.domain.CarType;
import com.kodilla.travelagency.business.car.facede.CarTypeFacade;
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
@WebMvcTest(CarTypeController.class)
public class CarTypeControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarTypeFacade facade;

    @Test
    public void shouldFetchAllCarTypes() throws Exception {
        //Given
        CarTypeDTO carType = CarTypeDTO.builder()
                .isAutomatic(true).numberOfDoors(5).withAC(true).withGPS(false).build();
        CarTypeDTO carType1 = CarTypeDTO.builder()
                .isAutomatic(true).numberOfDoors(3).withAC(true).withGPS(false).build();
        CarTypeDTO carType2 = CarTypeDTO.builder()
                .isAutomatic(true).numberOfDoors(5).withAC(true).withGPS(true).build();
        List<CarTypeDTO> carTypeDTOS = new ArrayList<>();
        carTypeDTOS.add(carType);
        carTypeDTOS.add(carType1);
        carTypeDTOS.add(carType2);
        //When
        when(facade.getCarTypes()).thenReturn(carTypeDTOS);
        //Then
        mockMvc.perform(get("/v1/travel/carTypes/getAll")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    public void shouldFetchCarType() throws Exception {
        //Given
        CarTypeDTO carType = CarTypeDTO.builder()
                .isAutomatic(true).numberOfDoors(5).withAC(true).withGPS(false).id(1L).build();
        //When
        when(facade.getCarType(Matchers.any())).thenReturn(carType);
        //Then
        mockMvc.perform(get("/v1/travel/carTypes/get/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)));
    }

    @Test
    public void shouldAddCarCompany() throws Exception {
        //Given
        CarTypeDTO carType = CarTypeDTO.builder()
                .isAutomatic(true).numberOfDoors(5).withAC(true).withGPS(false).id(1L).build();
        //When
        when(facade.addCarType(Matchers.any(CarTypeDTO.class))).thenReturn(carType);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(carType);
        //Then
        mockMvc.perform(post("/v1/travel/carTypes/add")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(jsonPath("$.id", is(1)));
    }

    @Test
    public void shouldUpdateCarCompany() throws Exception {
        //Given
        CarTypeDTO carType = CarTypeDTO.builder()
                .isAutomatic(true).numberOfDoors(5).withAC(true).withGPS(false).id(1L).build();
        //When
        when(facade.updateCarType(Matchers.any(CarTypeDTO.class))).thenReturn(carType);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(carType);
        //Then
        mockMvc.perform(put("/v1/travel/carTypes/update")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(jsonPath("$.id", is(1)));
    }

    @Test
    public void shouldDeleteCarCompany() throws Exception {
        //Given, When and Then
        mockMvc.perform(delete("/v1/travel/carTypes/delete/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldFetchAllCarTypesByAutomaticTrans() throws Exception {
        //Given
        CarTypeDTO carType = CarTypeDTO.builder()
                .isAutomatic(true).numberOfDoors(5).withAC(true).withGPS(false).build();
        CarTypeDTO carType1 = CarTypeDTO.builder()
                .isAutomatic(true).numberOfDoors(3).withAC(true).withGPS(false).build();
        CarTypeDTO carType2 = CarTypeDTO.builder()
                .isAutomatic(true).numberOfDoors(5).withAC(true).withGPS(true).build();
        List<CarTypeDTO> carTypeDTOS = new ArrayList<>();
        carTypeDTOS.add(carType);
        carTypeDTOS.add(carType1);
        carTypeDTOS.add(carType2);
        //When
        when(facade.getCarTypesWithAutomaticTransition(Matchers.any())).thenReturn(carTypeDTOS);
        //Then
        mockMvc.perform(get("/v1/travel/carTypes/getAll/auto/true")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    public void shouldFetchAllCarTypesByACPresent() throws Exception {
        //Given
        CarTypeDTO carType = CarTypeDTO.builder()
                .isAutomatic(true).numberOfDoors(5).withAC(true).withGPS(false).build();
        CarTypeDTO carType1 = CarTypeDTO.builder()
                .isAutomatic(true).numberOfDoors(3).withAC(true).withGPS(false).build();
        CarTypeDTO carType2 = CarTypeDTO.builder()
                .isAutomatic(true).numberOfDoors(5).withAC(true).withGPS(true).build();
        List<CarTypeDTO> carTypeDTOS = new ArrayList<>();
        carTypeDTOS.add(carType);
        carTypeDTOS.add(carType1);
        carTypeDTOS.add(carType2);
        //When
        when(facade.getCarTypesWithAC(Matchers.any())).thenReturn(carTypeDTOS);
        //Then
        mockMvc.perform(get("/v1/travel/carTypes/getAll/ac/true")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    public void shouldFetchAllCarTypesByNumberOfDoors() throws Exception {
        //Given
        CarTypeDTO carType = CarTypeDTO.builder()
                .isAutomatic(true).numberOfDoors(5).withAC(true).withGPS(false).build();
        CarTypeDTO carType1 = CarTypeDTO.builder()
                .isAutomatic(true).numberOfDoors(3).withAC(true).withGPS(false).build();
        CarTypeDTO carType2 = CarTypeDTO.builder()
                .isAutomatic(true).numberOfDoors(5).withAC(true).withGPS(true).build();
        List<CarTypeDTO> carTypeDTOS = new ArrayList<>();
        carTypeDTOS.add(carType);
        carTypeDTOS.add(carType1);
        carTypeDTOS.add(carType2);
        //When
        when(facade.getCarTypesByNumberOfDoors(Matchers.any())).thenReturn(carTypeDTOS);
        //Then
        mockMvc.perform(get("/v1/travel/carTypes/getAll/doors/5")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    public void shouldFetchAllCarTypesWithGPS() throws Exception {
        //Given
        CarTypeDTO carType = CarTypeDTO.builder()
                .isAutomatic(true).numberOfDoors(5).withAC(true).withGPS(false).build();
        CarTypeDTO carType1 = CarTypeDTO.builder()
                .isAutomatic(true).numberOfDoors(3).withAC(true).withGPS(false).build();
        CarTypeDTO carType2 = CarTypeDTO.builder()
                .isAutomatic(true).numberOfDoors(5).withAC(true).withGPS(true).build();
        List<CarTypeDTO> carTypeDTOS = new ArrayList<>();
        carTypeDTOS.add(carType);
        carTypeDTOS.add(carType1);
        carTypeDTOS.add(carType2);
        //When
        when(facade.getCarTypesWithGPS(Matchers.any())).thenReturn(carTypeDTOS);
        //Then
        mockMvc.perform(get("/v1/travel/carTypes/getAll/gps/true")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }
}
