package com.kodilla.travelagency.business.car.controller;

import com.kodilla.travelagency.business.car.domain.CarType;
import com.kodilla.travelagency.business.car.facede.CarTypeFacade;
import com.kodilla.travelagency.business.car.mapper.CarTypeMapper;
import com.kodilla.travelagency.business.car.api.CarTypeDTO;
import com.kodilla.travelagency.business.car.service.CarTypeService;
import com.kodilla.travelagency.exceptions.CarTypeNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Api(tags = "Car Types")
@CrossOrigin(origins = "*")
@RestController
@Transactional
@RequestMapping("v1/travel/carTypes")
public class CarTypeController {
    @Autowired
    private CarTypeFacade facade;

    @ApiOperation(value = "Get All Car Types")
    @GetMapping(value = "getAll")
    public List<CarTypeDTO> getCarTypes() {
        return facade.getCarTypes();
    }

    @ApiOperation(value = "Get Car Type By Id")
    @GetMapping(value = "get/{carTypeId}")
    public CarTypeDTO getCarType(@PathVariable Long carTypeId) throws CarTypeNotFoundException {
        return facade.getCarType(carTypeId);
    }

    @ApiOperation(value = "Add Car Type to Base")
    @PostMapping(value = "add", consumes = APPLICATION_JSON_VALUE)
    public CarTypeDTO addCarType(@RequestBody CarTypeDTO carTypeDTO) {
        return facade.addCarType(carTypeDTO);
    }

    @ApiOperation(value = "Update Car Type Details")
    @PutMapping(value = "update", consumes = APPLICATION_JSON_VALUE)
    public CarTypeDTO updateCarType(@RequestBody CarTypeDTO carTypeDTO) {
        return facade.updateCarType(carTypeDTO);
    }

    @ApiOperation(value = "Delete Car Type")
    @DeleteMapping(value = "delete/{carTypeId}")
    public void deleteCarType(@PathVariable Long carTypeId) throws CarTypeNotFoundException {
        facade.deleteCarType(carTypeId);
    }

    @ApiOperation(value = "Get All Car Types with AC")
    @GetMapping(value = "getAll/ac/{withAC}")
    public List<CarTypeDTO> getCarTypesWithAC(@PathVariable Boolean withAC) {
        return facade.getCarTypesWithAC(withAC);
    }

    @ApiOperation(value = "Get All Car Types with GPS")
    @GetMapping(value = "getAll/gps/{withGPS}")
    public List<CarTypeDTO> getCarTypesWithGPS(@PathVariable Boolean withGPS) {
        return facade.getCarTypesWithGPS(withGPS);
    }

    @ApiOperation(value = "Get All Car Types with Automatic")
    @GetMapping(value = "getAll/auto/{isAuto}")
    public List<CarTypeDTO> getCarTypesWithAutomaticTransition(@PathVariable Boolean isAuto) {
        return facade.getCarTypesWithAutomaticTransition(isAuto);
    }

    @ApiOperation(value = "Get All Car Types By Number of Doors")
    @GetMapping(value = "getAll/doors/{numberOfDoors}")
    public List<CarTypeDTO> getCarTypes(@PathVariable Integer numberOfDoors) {
        return facade.getCarTypesByNumberOfDoors(numberOfDoors);
    }
}
