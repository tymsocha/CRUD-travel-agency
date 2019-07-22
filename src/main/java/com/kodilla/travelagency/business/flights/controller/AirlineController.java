package com.kodilla.travelagency.business.flights.controller;

import com.kodilla.travelagency.business.flights.api.AirlineDTO;
import com.kodilla.travelagency.business.flights.facede.AirlineFacade;
import com.kodilla.travelagency.exceptions.AirlineNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Api(tags = "Airlines")
@CrossOrigin(origins = "*")
@RestController
@Transactional
@RequestMapping("v1/travel/airlines")
public class AirlineController {
    @Autowired
    private AirlineFacade facade;

    @ApiOperation(value = "Get All Airlines")
    @GetMapping(value = "getAll")
    public List<AirlineDTO> getAirlines() {
        return facade.getAirlines();
    }

    @ApiOperation(value = "Get Airline By Id")
    @GetMapping(value = "get/{airlineId}")
    public AirlineDTO getAirline(@PathVariable Long airlineId) throws AirlineNotFoundException {
        return facade.getAirline(airlineId);
    }

    @ApiOperation(value = "Find Airline By address, phone or name")
    @GetMapping(value = "getParameter/{parameter}")
    public AirlineDTO getAirlineByParameter(@PathVariable String parameter) throws AirlineNotFoundException {
        return facade.getAirlineByParameter(parameter);
    }

    @ApiOperation(value = "Add Airline to Base")
    @PostMapping(value = "add", consumes = APPLICATION_JSON_VALUE)
    public AirlineDTO addAirline(@RequestBody AirlineDTO airlineDTO) {
        return facade.addAirline(airlineDTO);
    }

    @ApiOperation(value = "Update Airline Details")
    @PutMapping(value = "update", consumes = APPLICATION_JSON_VALUE)
    public AirlineDTO updateAirline(@RequestBody AirlineDTO airlineDTO) {
        return facade.updateAirline(airlineDTO);
    }

    @ApiOperation(value = "Delete Airline")
    @DeleteMapping(value = "delete/{airlineId}")
    public void deleteAirline(@PathVariable Long airlineId) {
        facade.deleteAirline(airlineId);
    }
}
