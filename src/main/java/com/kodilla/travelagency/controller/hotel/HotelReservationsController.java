package com.kodilla.travelagency.controller.hotel;

import com.kodilla.travelagency.api.hotel.HotelDTO;
import com.kodilla.travelagency.api.hotel.HotelReservationDTO;
import com.kodilla.travelagency.core.hotel.HotelReservation;
import com.kodilla.travelagency.core.hotel.RoomType;
import com.kodilla.travelagency.exceptions.HotelNotFoundException;
import com.kodilla.travelagency.exceptions.HotelReservationNotFound;
import com.kodilla.travelagency.exceptions.TripNotFoundException;
import com.kodilla.travelagency.mapper.hotel.HotelReservationMapper;
import com.kodilla.travelagency.service.hotel.HotelReservationService;
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
    private HotelReservationService hotelService;

    @Autowired
    private HotelReservationMapper hotelMapper;

    @ApiOperation(value = "Get All Hotel Reservations")
    @GetMapping(value = "getAll")
    public List<HotelReservationDTO> getHotelReservations() {
        return hotelMapper.mapHotleListToHotelDTOList(hotelService.getAllHotelReservations());
    }

    @ApiOperation(value = "Get Hotel Reservation By Id")
    @GetMapping(value = "get/{hotelReservationId}")
    public HotelReservationDTO getHotelReservation(@PathVariable Long hotelReservationId) throws HotelReservationNotFound {
        return hotelMapper.mapHotelToHotelDTO(hotelService.findHotelReservationById(hotelReservationId));
    }

    @ApiOperation(value = "Create Hotel Reservation")
    @PostMapping(value = "create", consumes = APPLICATION_JSON_VALUE)
    public HotelReservationDTO createHotelReservation(@RequestBody HotelReservationDTO hotelReservationDTO) {
        return hotelMapper.mapHotelToHotelDTO(hotelService.createHotelReservation(hotelMapper.mapHotelDTOToHotel(hotelReservationDTO)));
    }

    @ApiOperation(value = "Update Hotel Reservation")
    @PutMapping(value = "update", consumes = APPLICATION_JSON_VALUE)
    public HotelReservationDTO updateHotelReservation(@RequestBody HotelReservationDTO hotelReservationDTO) {
        return hotelMapper.mapHotelToHotelDTO(hotelService.createHotelReservation(hotelMapper.mapHotelDTOToHotel(hotelReservationDTO)));
    }

    @ApiOperation(value = "Delete Hotel Reservation")
    @DeleteMapping(value = "delete/{hotelReservationId}")
    public void deleteHotelReservation(@PathVariable Long hotelReservationId) throws HotelReservationNotFound {
        hotelService.deleteHotelReservation(hotelReservationId);
    }

    @ApiOperation(value = "Get All Hotel Reservations in Hotel")
    @GetMapping(value = "getAll/hotel/{hotelId}")
    public List<HotelReservationDTO> getHotelReservationsByHotel(@PathVariable Long hotelId) throws HotelNotFoundException {
        return hotelMapper.mapHotleListToHotelDTOList(hotelService.getAllHotelReservationsByHotel(hotelId));
    }

    @ApiOperation(value = "Get All Hotel Reservations in Trip")
    @GetMapping(value = "getAll/hotel/{tripId}")
    public List<HotelReservationDTO> getHotelReservationsByTrip(@PathVariable Long tripId) throws TripNotFoundException {
        return hotelMapper.mapHotleListToHotelDTOList(hotelService.getAllHotelReservationsByTrip(tripId));
    }

    @ApiOperation(value = "Get All Hotel Reservations With Breakfast")
    @GetMapping(value = "getAll/breakfast/{isBreakfast}")
    public List<HotelReservationDTO> getHotelReservationsWithBreakFast(@PathVariable Boolean isBreakfast) {
        return hotelMapper.mapHotleListToHotelDTOList(hotelService.getAllHotelReservationsByBreakfast(isBreakfast));
    }

    @ApiOperation(value = "Get All Hotel Reservations By RoomType")
    @GetMapping(value = "getAll/hotel/{roomType}")
    public List<HotelReservationDTO> getHotelsByRoomType(@PathVariable RoomType roomType) {
        return hotelMapper.mapHotleListToHotelDTOList(hotelService.getAllHotelReservationsByRoomType(roomType));
    }

    @ApiOperation(value = "Get All Hotel Reservations For Guest")
    @GetMapping(value = "getAll/hotel/{guestName}")
    public List<HotelReservationDTO> getHotelsByRoomType(@PathVariable String guestName) {
        return hotelMapper.mapHotleListToHotelDTOList(hotelService.findHotelReservationByGuestName(guestName));
    }
}
