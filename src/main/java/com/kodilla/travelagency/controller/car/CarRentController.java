package com.kodilla.travelagency.controller.car;

import com.kodilla.travelagency.api.car.CarReservationDTO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@Transactional
@RequestMapping("v1/travel/cars")
public class CarRentController {
    @GetMapping(value = "getCarReservations")
    public List<CarReservationDTO> getCarReservations() {
        return new ArrayList<>();
    }

    @GetMapping(value = "getCarReservation/{carReservationId}")
    public CarReservationDTO getCarReservation(@PathVariable Long carReservationId) {
        return new CarReservationDTO();
    }

    @PostMapping(value = "saveCarReservation", consumes = APPLICATION_JSON_VALUE)
    public CarReservationDTO saveCarReservation(@RequestBody CarReservationDTO carReservationDTO) {
        return carReservationDTO;
    }

    @PutMapping(value = "updateCarReservation", consumes = APPLICATION_JSON_VALUE)
    public CarReservationDTO updateCarReservation(@RequestBody CarReservationDTO carReservationDTO) {
        return carReservationDTO;
    }

    @DeleteMapping(value = "deleteCarReservation/{carReservationId}")
    public void deleteCarReservation(@PathVariable Long carReservationId) {

    }
}
