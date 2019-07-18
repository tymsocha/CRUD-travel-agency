package com.kodilla.travelagency.business.car.facede;

import com.kodilla.travelagency.business.car.api.CarCompanyDTO;
import com.kodilla.travelagency.business.car.mapper.CarCompanyMapper;
import com.kodilla.travelagency.business.car.service.CarCompanyService;
import com.kodilla.travelagency.exceptions.CarCompanyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarCompanyFacade {
    @Autowired
    private CarCompanyService service;

    @Autowired
    private CarCompanyMapper mapper;

    public List<CarCompanyDTO> getCarCompanies() {
        return mapper.mapCarCompanyListToDTOList(service.getAllCarCompanies());
    }

    public CarCompanyDTO getCarCompany(Long carCompanyId) throws CarCompanyNotFoundException {
        return mapper.mapCarCompanyToDTO(service.findCarCompanyById(carCompanyId));
    }

    public CarCompanyDTO getCarCompany(String parameter) throws CarCompanyNotFoundException {
        return mapper.mapCarCompanyToDTO(service.findCarCompanyByParameter(parameter));
    }

    public CarCompanyDTO addCarCompany(CarCompanyDTO carCompanyDTO) {
        return mapper.mapCarCompanyToDTO(service.saveOrUpdateCarCompany(mapper.mapDTOToCarCompany(carCompanyDTO)));
    }

    public CarCompanyDTO updateCarCompany(CarCompanyDTO carCompanyDTO) {
        return mapper.mapCarCompanyToDTO(service.saveOrUpdateCarCompany(mapper.mapDTOToCarCompany(carCompanyDTO)));
    }

    public void deleteCarCompany(Long carCompanyId) {
        service.delete(carCompanyId);
    }
}
