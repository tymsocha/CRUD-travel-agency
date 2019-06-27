package com.kodilla.travelagency.mapper.car;

import com.kodilla.travelagency.core.car.CarCompany;
import com.kodilla.travelagency.dto.car.CarCompanyDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarCompanyMapper {
    public CarCompanyDTO mapCarCompanyToDTO(CarCompany carCompany) {
        return CarCompanyDTO.builder()
                .id(carCompany.getId())
                .address(carCompany.getAddress())
                .carCompanyName(carCompany.getCarCompanyName())
                .phoneNumber(carCompany.getPhoneNumber())
                .build();
    }

    public CarCompany mapDTOToCarCompany(CarCompanyDTO carCompanyDTO) {
        return CarCompany.builder()
                .id(carCompanyDTO.getId())
                .address(carCompanyDTO.getAddress())
                .carCompanyName(carCompanyDTO.getCarCompanyName())
                .phoneNumber(carCompanyDTO.getPhoneNumber())
                .build();
    }

    public List<CarCompany> mapDTOListToCarCompanyList(List<CarCompanyDTO> carCompanyDTOList) {
        return carCompanyDTOList.stream().map(carCompanyDTO -> CarCompany.builder()
                    .id(carCompanyDTO.getId())
                    .address(carCompanyDTO.getAddress())
                    .carCompanyName(carCompanyDTO.getCarCompanyName())
                    .phoneNumber(carCompanyDTO.getPhoneNumber())
                    .build())
                .collect(Collectors.toList());
    }

    public List<CarCompany> mapCarCompanyListToDTOList(List<CarCompanyDTO> carCompanyDTOList) {
        return carCompanyDTOList.stream().map(carCompanyDTO -> CarCompany.builder()
                    .id(carCompanyDTO.getId())
                    .address(carCompanyDTO.getAddress())
                    .carCompanyName(carCompanyDTO.getCarCompanyName())
                    .phoneNumber(carCompanyDTO.getPhoneNumber())
                    .build())
                .collect(Collectors.toList());
    }
}
