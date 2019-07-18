package com.kodilla.travelagency.business.car.controller;

import com.kodilla.travelagency.business.car.facede.CarCompanyFacade;
import com.kodilla.travelagency.business.car.mapper.CarCompanyMapper;
import com.kodilla.travelagency.business.car.api.CarCompanyDTO;
import com.kodilla.travelagency.business.car.service.CarCompanyService;
import com.kodilla.travelagency.exceptions.CarCompanyNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Api(tags = "Car Companies")
@CrossOrigin(origins = "*")
@RestController
@Transactional
@RequestMapping("v1/travel/carCompanies")
public class CarCompanyController {
    @Autowired
    private CarCompanyFacade facade;

    @ApiOperation(value = "Get All Car Companies")
    @GetMapping(value = "getAll")
    public List<CarCompanyDTO> getCarCompanies() {
        return facade.getCarCompanies();
    }

    @ApiOperation(value = "Get Car Company By Id")
    @GetMapping(value = "get/{carCompanyId}")
    public CarCompanyDTO getCarCompany(@PathVariable Long carCompanyId) throws CarCompanyNotFoundException {
        return facade.getCarCompany(carCompanyId);
    }

    @ApiOperation(value = "Find Car Company By address, phone or name")
    @GetMapping(value = "get/{parameter}")
    public CarCompanyDTO getCarCompany(@PathVariable String parameter) throws CarCompanyNotFoundException {
        return facade.getCarCompany(parameter);
    }

    @ApiOperation(value = "Add Car Company to Base")
    @PostMapping(value = "add", consumes = APPLICATION_JSON_VALUE)
    public CarCompanyDTO addCarCompany(@RequestBody CarCompanyDTO carCompanyDTO) {
        return facade.addCarCompany(carCompanyDTO);
    }

    @ApiOperation(value = "Update Car Company Details")
    @PutMapping(value = "update", consumes = APPLICATION_JSON_VALUE)
    public CarCompanyDTO updateCarCompany(@RequestBody CarCompanyDTO carCompanyDTO) {
        return facade.updateCarCompany(carCompanyDTO);
    }

    @ApiOperation(value = "Delete Car Company")
    @DeleteMapping(value = "delete/{carCompanyId}")
    public void deleteHotel(@PathVariable Long carCompanyId) throws CarCompanyNotFoundException {
        facade.deleteCarCompany(carCompanyId);
    }
}
