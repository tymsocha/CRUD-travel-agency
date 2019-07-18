package com.kodilla.travelagency.business.car.controller;

import com.kodilla.travelagency.business.car.facede.CarReservationFacade;
import com.kodilla.travelagency.business.car.mapper.CarReservationsMapper;
import com.kodilla.travelagency.business.car.api.CarResApi;
import com.kodilla.travelagency.business.car.api.CarReservationDTO;
import com.kodilla.travelagency.business.car.service.CarReservationService;
import com.kodilla.travelagency.exceptions.CarCompanyNotFoundException;
import com.kodilla.travelagency.exceptions.CarReservationNotFoundException;
import com.kodilla.travelagency.exceptions.CarTypeNotFoundException;
import com.kodilla.travelagency.exceptions.TripNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Api(tags = "Car Reservations")
@CrossOrigin(origins = "*")
@RestController
@Transactional
@RequestMapping("v1/travel/carRes")
public class CarReservationController {
    @Autowired
    private CarReservationFacade facade;

    @ApiOperation(value = "Get All Car Reservations")
    @GetMapping(value = "getAll")
    public List<CarReservationDTO> getCarReservations() {
        return facade.getCarReservations();
    }

    @ApiOperation(value = "Get Car Reservation By Id")
    @GetMapping(value = "get/{carReservationId}")
    public CarReservationDTO getCarReservation(@PathVariable Long carReservationId) throws CarReservationNotFoundException {
        return facade.getCarReservation(carReservationId);
    }

    @ApiOperation(value = "Add Car Reservation to Base")
    @PostMapping(value = "add", consumes = APPLICATION_JSON_VALUE)
    public CarReservationDTO addCarReservation(@RequestBody CarReservationDTO carReservationDTO) {
        return facade.addCarReservation(carReservationDTO);
    }

    @ApiOperation(value = "Update Car Company Details")
    @PutMapping(value = "update", consumes = APPLICATION_JSON_VALUE)
    public CarReservationDTO updateCarReservation(@RequestBody CarReservationDTO carReservationDTO) {
        return updateCarReservation(carReservationDTO);
    }

    @ApiOperation(value = "Delete Car Company")
    @DeleteMapping(value = "delete/{carReservationId}")
    public void deleteCarReservation(@PathVariable Long carReservationId) throws CarReservationNotFoundException {
        facade.deleteCarReservation(carReservationId);
    }

    @ApiOperation(value = "Get All Car Reservations By Type")
    @GetMapping(value = "getAll/carType/{carTypeId}")
    public List<CarReservationDTO> getCarReservationsByCarType(@PathVariable Long carTypeId) throws CarTypeNotFoundException {
        return facade.getCarReservationsByCarType(carTypeId);
    }

    @ApiOperation(value = "Get All Car Reservations By Company")
    @GetMapping(value = "getAll/company/{companyId}")
    public List<CarReservationDTO> getCarReservationsByCompany(@PathVariable Long companyId) throws CarCompanyNotFoundException {
        return facade.getCarReservationsByCompany(companyId);
    }

    @ApiOperation(value = "Get All Car Reservations By Trip")
    @GetMapping(value = "getAll/trip")
    public List<CarReservationDTO> getCarReservationsByTrip(@RequestBody CarResApi api) throws TripNotFoundException {
        return facade.getCarReservationsByTrip(api);
    }

    @ApiOperation(value = "Get All Car Reservations By Rent Date")
    @GetMapping(value = "getAll/rentDate")
    public CarReservationDTO getCarReservationsRentDate(@RequestBody CarResApi api) throws CarReservationNotFoundException {
        return facade.getCarReservationsRentDate(api);
    }
}
