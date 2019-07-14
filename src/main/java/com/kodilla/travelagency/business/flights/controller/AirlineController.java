package com.kodilla.travelagency.business.flights.controller;

import com.kodilla.travelagency.business.flights.api.AirlineDTO;
import com.kodilla.travelagency.business.flights.mapper.AirlineMapper;
import com.kodilla.travelagency.business.flights.service.AirlineService;
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
    private AirlineService service;

    @Autowired
    private AirlineMapper mapper;

    @ApiOperation(value = "Get All Airlines")
    @GetMapping(value = "getAll")
    public List<AirlineDTO> getAirlines() {
        return mapper.mapAirlineListToAirlineDTOList(service.getAllAirlines());
    }

    @ApiOperation(value = "Get Airline By Id")
    @GetMapping(value = "get/{airlineId}")
    public AirlineDTO getAirline(@PathVariable Long airlineId) throws AirlineNotFoundException {
        return mapper.mapAirlineToAirlineDTO(service.findAirlineById(airlineId));
    }

    @ApiOperation(value = "Find Airline By address, phone or name")
    @GetMapping(value = "get/{parameter}")
    public AirlineDTO getAirline(@PathVariable String parameter) throws AirlineNotFoundException {
        return mapper.mapAirlineToAirlineDTO(service.findAirlineByParameter(parameter));
    }

    @ApiOperation(value = "Add Airline to Base")
    @PostMapping(value = "add", consumes = APPLICATION_JSON_VALUE)
    public AirlineDTO addAirline(@RequestBody AirlineDTO airlineDTO) {
        return mapper.mapAirlineToAirlineDTO(service.saveOrUpdateAirline(mapper.mapAirlineDTOToAirline(airlineDTO)));
    }

    @ApiOperation(value = "Update Airline Details")
    @PutMapping(value = "update", consumes = APPLICATION_JSON_VALUE)
    public AirlineDTO updateAirline(@RequestBody AirlineDTO airlineDTO) {
        return mapper.mapAirlineToAirlineDTO(service.saveOrUpdateAirline(mapper.mapAirlineDTOToAirline(airlineDTO)));
    }

    @ApiOperation(value = "Delete Airline")
    @DeleteMapping(value = "delete/{airlineId}")
    public void deleteHotel(@PathVariable Long airlineId) throws AirlineNotFoundException {
        service.deleteAirline(airlineId);
    }
}
