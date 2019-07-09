package com.kodilla.travelagency.controller.trip;


import com.kodilla.travelagency.api.trip.TripDTO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@Transactional
@RequestMapping("/v1/travel/trips")
public class TripController {

    @GetMapping(value = "getTrips")
    public List<TripDTO> getTrips() {
        return new ArrayList<>();
    }
}
