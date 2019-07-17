package com.kodilla.travelagency.business.car.controller;

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
    private CarTypeService service;

    @Autowired
    private CarTypeMapper mapper;

    @ApiOperation(value = "Get All Car Types")
    @GetMapping(value = "getAll")
    public List<CarTypeDTO> getCarCompanies() {
        return mapper.mapCarTypeListToDTOList(service.getAllCarTypes());
    }

    @ApiOperation(value = "Get Car Type By Id")
    @GetMapping(value = "get/{carTypeId}")
    public CarTypeDTO getCarType(@PathVariable Long carTypeId) throws CarTypeNotFoundException {
        return mapper.mapCarTypeToCarTypeDTO(service.findCarTypeById(carTypeId));
    }

    @ApiOperation(value = "Add Car Type to Base")
    @PostMapping(value = "add", consumes = APPLICATION_JSON_VALUE)
    public CarTypeDTO addCarType(@RequestBody CarTypeDTO carTypeDTO) {
        return mapper.mapCarTypeToCarTypeDTO(service.saveOrUpdateCarType(mapper.mapCarTypeDTOToCarType(carTypeDTO)));
    }

    @ApiOperation(value = "Update Car Type Details")
    @PutMapping(value = "update", consumes = APPLICATION_JSON_VALUE)
    public CarTypeDTO updateCarType(@RequestBody CarTypeDTO carTypeDTO) {
        return mapper.mapCarTypeToCarTypeDTO(service.saveOrUpdateCarType(mapper.mapCarTypeDTOToCarType(carTypeDTO)));
    }

    @ApiOperation(value = "Delete Car Type")
    @DeleteMapping(value = "delete/{carTypeId}")
    public void deleteHotel(@PathVariable Long carTypeId) throws CarTypeNotFoundException {
        service.deleteCarType(carTypeId);
    }

    @ApiOperation(value = "Get All Car Types with AC")
    @GetMapping(value = "getAll/ac/{withAc}")
    public List<CarTypeDTO> getCarCompaniesWithAC(@PathVariable Boolean withAC) {
        return mapper.mapCarTypeListToDTOList(service.getAllWithAC(withAC));
    }

    @ApiOperation(value = "Get All Car Types with GPS")
    @GetMapping(value = "getAll/gps/{withGPS}")
    public List<CarTypeDTO> getCarCompaniesWithGPS(@PathVariable Boolean withGPS) {
        return mapper.mapCarTypeListToDTOList(service.getAllWithGPS(withGPS));
    }

    @ApiOperation(value = "Get All Car Types with Automatic")
    @GetMapping(value = "getAll/auto/{isAuto}")
    public List<CarTypeDTO> getCarCompaniesWithAutomaticTransition(@PathVariable Boolean isAuto) {
        return mapper.mapCarTypeListToDTOList(service.getAllWithAutomaticTrans(isAuto));
    }

    @ApiOperation(value = "Get All Car Types By Number of Doors")
    @GetMapping(value = "getAll/doors/{numberOfDoors}")
    public List<CarTypeDTO> getCarCompanies(@PathVariable Integer numberOfDoors) {
        return mapper.mapCarTypeListToDTOList(service.getAllByNumberOfDoors(numberOfDoors));
    }
}
