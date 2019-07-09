package com.kodilla.travelagency.controller.flight;

import com.kodilla.travelagency.api.flight.FlightDTO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@Transactional
@RequestMapping("v1/travel/flights")
public class FlightController {
    @GetMapping(value = "getFlights")
    public List<FlightDTO> getFlights() {
        return new ArrayList<>();
    }

    @GetMapping(value = "getFlight/{flightId}")
    public FlightDTO getFlight(@PathVariable Long flightId) {
        return new FlightDTO();
    }

    @PostMapping(value = "saveFlight", consumes = APPLICATION_JSON_VALUE)
    public FlightDTO saveFlight(@RequestBody FlightDTO flightDTO) {
        return flightDTO;
    }

    @PutMapping(value = "updateFlight", consumes = APPLICATION_JSON_VALUE)
    public FlightDTO updateFlight(@RequestBody FlightDTO flightDTO) {
        return flightDTO;
    }

    @DeleteMapping(value = "deleteFlight/{flightId}")
    public void deleteFlight(@PathVariable Long flightId) {

    }
}
