package com.kodilla.travelagency.controller.places;

import com.kodilla.travelagency.api.places.PlaceDTO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@Transactional
@RequestMapping("v1/travel/places")
public class PlacesController {

    @GetMapping(value = "getPlaces")
    public List<PlaceDTO> getPlaces() {
        return new ArrayList<>();
    }

    @GetMapping(value = "getPlace/{placeId}")
    public PlaceDTO getPlace(@PathVariable Long placeId) {
        return new PlaceDTO();
    }

    @PostMapping(value = "savePlace", consumes = APPLICATION_JSON_VALUE)
    public PlaceDTO savePlace(@RequestBody PlaceDTO placeDTO) {
        return placeDTO;
    }

    @PutMapping(value = "updatePlace", consumes = APPLICATION_JSON_VALUE)
    public PlaceDTO updatePlace(@RequestBody PlaceDTO placeDTO) {
        return placeDTO;
    }

    @DeleteMapping(value = "deletePlace/{placeId}")
    public void deletePlace(@PathVariable Long placeId) {

    }
}
