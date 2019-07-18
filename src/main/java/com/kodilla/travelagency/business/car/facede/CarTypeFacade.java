package com.kodilla.travelagency.business.car.facede;

import com.kodilla.travelagency.business.car.api.CarTypeDTO;
import com.kodilla.travelagency.business.car.mapper.CarTypeMapper;
import com.kodilla.travelagency.business.car.service.CarTypeService;
import com.kodilla.travelagency.exceptions.CarTypeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarTypeFacade {
    @Autowired
    private CarTypeService service;

    @Autowired
    private CarTypeMapper mapper;

    public List<CarTypeDTO> getCarTypes() {
        return mapper.mapCarTypeListToDTOList(service.getAllCarTypes());
    }

    public CarTypeDTO getCarType(Long carTypeId) throws CarTypeNotFoundException {
        return mapper.mapCarTypeToCarTypeDTO(service.findCarTypeById(carTypeId));
    }

    public CarTypeDTO addCarType(CarTypeDTO carTypeDTO) {
        return mapper.mapCarTypeToCarTypeDTO(service.saveOrUpdateCarType(mapper.mapCarTypeDTOToCarType(carTypeDTO)));
    }

    public CarTypeDTO updateCarType(CarTypeDTO carTypeDTO) {
        return mapper.mapCarTypeToCarTypeDTO(service.saveOrUpdateCarType(mapper.mapCarTypeDTOToCarType(carTypeDTO)));
    }

    public void deleteCarType(Long carTypeId) throws CarTypeNotFoundException {
        service.deleteCarType(carTypeId);
    }

    public List<CarTypeDTO> getCarTypesWithAC(Boolean withAC) {
        return mapper.mapCarTypeListToDTOList(service.getAllWithAC(withAC));
    }
    
    public List<CarTypeDTO> getCarTypesWithGPS(Boolean withGPS) {
        return mapper.mapCarTypeListToDTOList(service.getAllWithGPS(withGPS));
    }

    public List<CarTypeDTO> getCarTypesWithAutomaticTransition(Boolean isAuto) {
        return mapper.mapCarTypeListToDTOList(service.getAllWithAutomaticTrans(isAuto));
    }

    public List<CarTypeDTO> getCarTypesByNumberOfDoors(Integer numberOfDoors) {
        return mapper.mapCarTypeListToDTOList(service.getAllByNumberOfDoors(numberOfDoors));
    }
}
