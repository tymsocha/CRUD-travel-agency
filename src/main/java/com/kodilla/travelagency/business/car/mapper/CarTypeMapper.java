package com.kodilla.travelagency.business.car.mapper;

import com.kodilla.travelagency.business.car.api.CarTypeDTO;
import com.kodilla.travelagency.business.car.domain.CarType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarTypeMapper {
    public CarType mapCarTypeDTOToCarType(CarTypeDTO carTypeDTO) {
        return CarType.builder()
                .id(carTypeDTO.getId())
                .isAutomatic(carTypeDTO.getIsAutomatic())
                .numberOfDoors(carTypeDTO.getNumberOfDoors())
                .withAC(carTypeDTO.getWithAC())
                .withGPS(carTypeDTO.getWithGPS())
                .build();
    }

    public CarTypeDTO mapCarTypeToCarTypeDTO(CarType carType) {
        return CarTypeDTO.builder()
                .id(carType.getId())
                .isAutomatic(carType.getIsAutomatic())
                .numberOfDoors(carType.getNumberOfDoors())
                .withAC(carType.getWithAC())
                .withGPS(carType.getWithGPS())
                .build();
    }

    public List<CarType> mapDTOListToCarTypeList(List<CarTypeDTO> carTypeDTOList) {
        return carTypeDTOList.stream().map(carTypeDTO -> CarType.builder()
                    .id(carTypeDTO.getId())
                    .isAutomatic(carTypeDTO.getIsAutomatic())
                    .numberOfDoors(carTypeDTO.getNumberOfDoors())
                    .withAC(carTypeDTO.getWithAC())
                    .withGPS(carTypeDTO.getWithGPS())
                    .build())
                .collect(Collectors.toList());
    }

    public List<CarTypeDTO> mapCarTypeListToDTOList(List<CarType> carTypeList) {
        return carTypeList.stream().map(carType -> CarTypeDTO.builder()
                    .id(carType.getId())
                    .isAutomatic(carType.getIsAutomatic())
                    .numberOfDoors(carType.getNumberOfDoors())
                    .withAC(carType.getWithAC())
                    .withGPS(carType.getWithGPS())
                    .build())
                .collect(Collectors.toList());
    }
}
