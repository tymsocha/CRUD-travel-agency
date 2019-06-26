package com.kodilla.travelagency.mapper.car;

import com.kodilla.travelagency.core.car.CarReservation;
import com.kodilla.travelagency.dto.car.CarReservationDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarReservationsMapper {
    public CarReservationDTO mapCarToCarDTO(CarReservation carReservation) {
        return CarReservationDTO.builder()
                .id(carReservation.getId())
                .companyName(carReservation.getCompanyName())
                .startRentDate(carReservation.getStartRentDate())
                .endRentDate(carReservation.getEndRentDate())
                .carType(carReservation.getCarType())
                .numberOfRentDays(carReservation.getNumberOfRentDays())
                .pricePerDay(carReservation.getPricePerDay())
                .price(carReservation.getPrice())
                .build();
    }

    public CarReservation mapCarDTOToCar(CarReservationDTO carReservationDTO) {
        return CarReservation.builder()
                .id(carReservationDTO.getId())
                .companyName(carReservationDTO.getCompanyName())
                .startRentDate(carReservationDTO.getStartRentDate())
                .endRentDate(carReservationDTO.getEndRentDate())
                .carType(carReservationDTO.getCarType())
                .numberOfRentDays(carReservationDTO.getNumberOfRentDays())
                .pricePerDay(carReservationDTO.getPricePerDay())
                .price(carReservationDTO.getPrice())
                .build();
    }

    public List<CarReservation> mapCarDTOListToCarList(List<CarReservationDTO> carReservationDTOList) {
        return carReservationDTOList.stream().map(carReservationDTO -> CarReservation.builder()
                    .id(carReservationDTO.getId())
                    .companyName(carReservationDTO.getCompanyName())
                    .startRentDate(carReservationDTO.getStartRentDate())
                    .endRentDate(carReservationDTO.getEndRentDate())
                    .carType(carReservationDTO.getCarType())
                    .numberOfRentDays(carReservationDTO.getNumberOfRentDays())
                    .pricePerDay(carReservationDTO.getPricePerDay())
                    .price(carReservationDTO.getPrice())
                    .build())
                .collect(Collectors.toList());
    }

    public List<CarReservationDTO> mapCarListToCarDTOList(List<CarReservation> carReservationList) {
        return carReservationList.stream().map(carReservation -> CarReservationDTO.builder()
                    .id(carReservation.getId())
                    .companyName(carReservation.getCompanyName())
                    .startRentDate(carReservation.getStartRentDate())
                    .endRentDate(carReservation.getEndRentDate())
                    .carType(carReservation.getCarType())
                    .numberOfRentDays(carReservation.getNumberOfRentDays())
                    .pricePerDay(carReservation.getPricePerDay())
                    .price(carReservation.getPrice())
                    .build())
                .collect(Collectors.toList());
    }

}
