package com.kodilla.travelagency.business.hotel.controller;

import com.kodilla.travelagency.business.hotel.api.HotelDTO;
import com.kodilla.travelagency.business.hotel.facede.HotelFacade;
import com.kodilla.travelagency.exceptions.HotelNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Api(tags = "Hotels")
@CrossOrigin(origins = "*")
@RestController
@Transactional
@RequestMapping("v1/travel/hotels")
public class HotelController {
    @Autowired
    private HotelFacade facade;

    @ApiOperation(value = "Get All Hotels")
    @GetMapping(value = "getAll")
    public List<HotelDTO> getHotels() {
        return facade.getHotels();
    }

    @ApiOperation(value = "Get Hotel By Id")
    @GetMapping(value = "get/{hotelId}")
    public HotelDTO getHotel(@PathVariable Long hotelId) throws HotelNotFoundException {
        return facade.getHotel(hotelId);
    }

    @ApiOperation(value = "Find Hotel By address, phone or name")
    @GetMapping(value = "get/{parameter}")
    public HotelDTO getHotel(@PathVariable String parameter) throws HotelNotFoundException {
        return facade.getHotel(parameter);
    }

    @ApiOperation(value = "Add Hotel to Base")
    @PostMapping(value = "add", consumes = APPLICATION_JSON_VALUE)
    public HotelDTO addHotel(@RequestBody HotelDTO hotelDTO) {
        return facade.addHotel(hotelDTO);
    }

    @ApiOperation(value = "Update Hotel Details")
    @PutMapping(value = "update", consumes = APPLICATION_JSON_VALUE)
    public HotelDTO updateHotel(@RequestBody HotelDTO hotelDTO) {
        return facade.updateHotel(hotelDTO);
    }

    @ApiOperation(value = "Delete Hotel")
    @DeleteMapping(value = "delete/{hotelId}")
    public void deleteHotel(@PathVariable Long hotelId) {
        facade.deleteHotel(hotelId);
    }
}
