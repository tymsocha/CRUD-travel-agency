package com.kodilla.travelagency.controller.hotel;

import com.kodilla.travelagency.api.hotel.HotelReservationDTO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@Transactional
@RequestMapping("v1/travel/hotels")
public class HotelController {
    @GetMapping(value = "getHotelReservations")
    public List<HotelReservationDTO> getHotelReservations() {
        return new ArrayList<>();
    }

    @GetMapping(value = "getHotelReservation/{hotelReservationId}")
    public HotelReservationDTO getHotelReservation(@PathVariable Long hotelReservationId) {
        return new HotelReservationDTO();
    }

    @PostMapping(value = "saveHotelReservation", consumes = APPLICATION_JSON_VALUE)
    public HotelReservationDTO saveHotelReservation(@RequestBody HotelReservationDTO hotelReservationDTO) {
        return hotelReservationDTO;
    }

    @PutMapping(value = "updateHotelReservation", consumes = APPLICATION_JSON_VALUE)
    public HotelReservationDTO updateHotelReservation(@RequestBody HotelReservationDTO hotelReservationDTO) {
        return hotelReservationDTO;
    }

    @DeleteMapping(value = "deleteHotelReservation/{hotelReservationId}")
    public void deleteHotelReservation(@PathVariable Long hotelReservationId) {

    }
}
