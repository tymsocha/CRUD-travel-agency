package com.kodilla.travelagency.business.hotel.controller;

import com.kodilla.travelagency.business.hotel.RoomType;
import com.kodilla.travelagency.business.hotel.api.HotelReservationDTO;
import com.kodilla.travelagency.business.hotel.facede.HotelReservationsFacade;
import com.kodilla.travelagency.exceptions.HotelNotFoundException;
import com.kodilla.travelagency.exceptions.HotelReservationNotFound;
import com.kodilla.travelagency.exceptions.TripNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Api(tags = "Hotel Reservations")
@CrossOrigin(origins = "*")
@RestController
@Transactional
@RequestMapping("v1/travel/hotelRes")
public class HotelReservationsController {
    @Autowired
    private HotelReservationsFacade facade;

    @ApiOperation(value = "Get All Hotel Reservations")
    @GetMapping(value = "getAll")
    public List<HotelReservationDTO> getHotelReservations() {
        return facade.getHotelReservations();
    }

    @ApiOperation(value = "Get Hotel Reservation By Id")
    @GetMapping(value = "get/{hotelReservationId}")
    public HotelReservationDTO getHotelReservation(@PathVariable Long hotelReservationId) throws HotelReservationNotFound {
        return facade.getHotelReservation(hotelReservationId);
    }

    @ApiOperation(value = "Create Hotel Reservation")
    @PostMapping(value = "create", consumes = APPLICATION_JSON_VALUE)
    public HotelReservationDTO createHotelReservation(@RequestBody HotelReservationDTO hotelReservationDTO) {
        return facade.createHotelReservation(hotelReservationDTO);
    }

    @ApiOperation(value = "Update Hotel Reservation")
    @PutMapping(value = "update", consumes = APPLICATION_JSON_VALUE)
    public HotelReservationDTO updateHotelReservation(@RequestBody HotelReservationDTO hotelReservationDTO) {
        return facade.updateHotelReservation(hotelReservationDTO);
    }

    @ApiOperation(value = "Delete Hotel Reservation")
    @DeleteMapping(value = "delete/{hotelReservationId}")
    public void deleteHotelReservation(@PathVariable Long hotelReservationId) throws HotelReservationNotFound {
        facade.deleteHotelReservation(hotelReservationId);
    }

    @ApiOperation(value = "Get All Hotel Reservations in Hotel")
    @GetMapping(value = "getAll/hotel/{hotelId}")
    public List<HotelReservationDTO> getHotelReservationsByHotel(@PathVariable Long hotelId) throws HotelNotFoundException {
        return facade.getHotelReservationsByHotel(hotelId);
    }

    @ApiOperation(value = "Get All Hotel Reservations in Trip")
    @GetMapping(value = "getAll/hotel/{tripId}")
    public List<HotelReservationDTO> getHotelReservationsByTrip(@PathVariable Long tripId) throws TripNotFoundException {
        return facade.getHotelReservationsByTrip(tripId);
    }

    @ApiOperation(value = "Get All Hotel Reservations With Breakfast")
    @GetMapping(value = "getAll/breakfast/{isBreakfast}")
    public List<HotelReservationDTO> getHotelReservationsWithBreakFast(@PathVariable Boolean isBreakfast) {
        return facade.getHotelReservationsWithBreakFast(isBreakfast);
    }

    @ApiOperation(value = "Get All Hotel Reservations By RoomType")
    @GetMapping(value = "getAll/hotel/{roomType}")
    public List<HotelReservationDTO> getHotelsByRoomType(@PathVariable RoomType roomType) {
        return facade.getHotelsByRoomType(roomType);
    }

    @ApiOperation(value = "Get All Hotel Reservations For Guest")
    @GetMapping(value = "getAll/hotel/{guestName}")
    public List<HotelReservationDTO> getHotelsByGuestName(@PathVariable String guestName) {
        return facade.getHotelsByGuestName(guestName);
    }
}
