package com.kodilla.travelagency.business.car.mapper;

import com.kodilla.travelagency.business.car.api.CarCompanyDTO;
import com.kodilla.travelagency.business.car.domain.CarCompany;
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

    public List<CarCompanyDTO> mapCarCompanyListToDTOList(List<CarCompany> carCompanies) {
        return carCompanies.stream().map(carCompany -> CarCompanyDTO.builder()
                    .id(carCompany.getId())
                    .address(carCompany.getAddress())
                    .carCompanyName(carCompany.getCarCompanyName())
                    .phoneNumber(carCompany.getPhoneNumber())
                    .build())
                .collect(Collectors.toList());
    }
}
