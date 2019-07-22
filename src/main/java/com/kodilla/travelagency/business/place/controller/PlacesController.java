package com.kodilla.travelagency.business.place.controller;

import com.kodilla.travelagency.business.place.api.PlaceDTO;
import com.kodilla.travelagency.business.place.facede.PlacesFacade;
import com.kodilla.travelagency.business.place.mapper.PlaceMapper;
import com.kodilla.travelagency.business.place.service.PlacesService;
import com.kodilla.travelagency.exceptions.PlaceNotFoundException;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Api(tags = "Places")
@CrossOrigin(origins = "*")
@RestController
@Transactional
@RequestMapping("v1/travel/places")
public class PlacesController {
    @Autowired
    private PlacesFacade facade;

    @ApiOperation(value = "Get All Places")
    @GetMapping(value = "getAll")
    public List<PlaceDTO> getPlaces() {
        return facade.getPlaces();
    }

    @ApiOperation(value = "Get Place")
    @GetMapping(value = "get/{placeId}")
    public PlaceDTO getPlace(@PathVariable Long placeId) throws PlaceNotFoundException {
        return facade.getPlace(placeId);
    }

    @ApiOperation(value = "Get Place By Name")
    @GetMapping(value = "getName/{placeName}")
    public PlaceDTO getPlaceByName(@PathVariable String placeName) throws PlaceNotFoundException {
        return facade.getPlaceByName(placeName);
    }

    @ApiOperation(value = "Save Place")
    @PostMapping(value = "save", consumes = APPLICATION_JSON_VALUE)
    public PlaceDTO savePlace(@RequestBody PlaceDTO placeDTO) {
        return facade.savePlace(placeDTO);
    }

    @ApiOperation(value = "Update Place")
    @PutMapping(value = "update", consumes = APPLICATION_JSON_VALUE)
    public PlaceDTO updatePlace(@RequestBody PlaceDTO placeDTO) {
        return facade.updatePlace(placeDTO);
    }

    @ApiOperation(value = "Delete Place")
    @DeleteMapping(value = "delete/{placeId}")
    public void deletePlace(@PathVariable Long placeId) throws PlaceNotFoundException {
        facade.deletePlace(placeId);
    }

    @ApiOperation(value = "Get Places By Country")
    @GetMapping(value = "getAll/country/{country}")
    public List<PlaceDTO> getPlacesByCountry(@PathVariable String country) {
        return facade.getPlacesByCountry(country);
    }

    @ApiOperation(value = "Get Places By City")
    @GetMapping(value = "get/city/{city}")
    public List<PlaceDTO> getPlacesByNearestCity(@PathVariable String city) {
        return facade.getPlacesByNearestCity(city);
    }

    @ApiOperation(value = "Get Places By City And Distance")
    @GetMapping(value = "get/city/{city}/dist/{distance}")
    public List<PlaceDTO> getPlacesByNearestCityAndDistance(@PathVariable String city, @PathVariable Double distance) {
        return facade.getPlacesByNearestCityAndDistance(city, distance);
    }

    @ApiOperation(value = "Get Places By Cost")
    @GetMapping(value = "getCost/{cost}")
    public List<PlaceDTO> getPlacesByCost(@PathVariable Long cost) {
        return facade.getPlacesByCost(cost);
    }

    @ApiOperation(value = "Get Places By Monument Status")
    @GetMapping(value = "get/monument/{status}")
    public List<PlaceDTO> getPlacesByMonumentStatus(@PathVariable Boolean status) {
        return facade.getPlacesByMonumentStatus(status);
    }
}
