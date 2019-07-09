package com.kodilla.travelagency.mapper.car;

import com.kodilla.travelagency.core.car.CarReservation;
import com.kodilla.travelagency.api.car.CarReservationDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarReservationsMapper {
    public CarReservationDTO mapCarToCarDTO(CarReservation carReservation) {
        return CarReservationDTO.builder()
                .id(carReservation.getId())
                .startRentDate(carReservation.getStartRentDate())
                .endRentDate(carReservation.getEndRentDate())
                .carType(carReservation.getCarType())
                .numberOfRentDays(carReservation.getNumberOfRentDays())
                .pricePerDay(carReservation.getPricePerDay())
                .price(carReservation.getPrice())
                .carCompany(carReservation.getCarCompany())
                .trip(carReservation.getTrip())
                .build();
    }

    public CarReservation mapCarDTOToCar(CarReservationDTO carReservationDTO) {
        return CarReservation.builder()
                .id(carReservationDTO.getId())
                .startRentDate(carReservationDTO.getStartRentDate())
                .endRentDate(carReservationDTO.getEndRentDate())
                .carType(carReservationDTO.getCarType())
                .numberOfRentDays(carReservationDTO.getNumberOfRentDays())
                .pricePerDay(carReservationDTO.getPricePerDay())
                .price(carReservationDTO.getPrice())
                .carCompany(carReservationDTO.getCarCompany())
                .trip(carReservationDTO.getTrip())
                .build();
    }

    public List<CarReservation> mapCarDTOListToCarList(List<CarReservationDTO> carReservationDTOList) {
        return carReservationDTOList.stream().map(carReservationDTO -> CarReservation.builder()
                    .id(carReservationDTO.getId())
                    .startRentDate(carReservationDTO.getStartRentDate())
                    .endRentDate(carReservationDTO.getEndRentDate())
                    .carType(carReservationDTO.getCarType())
                    .numberOfRentDays(carReservationDTO.getNumberOfRentDays())
                    .pricePerDay(carReservationDTO.getPricePerDay())
                    .price(carReservationDTO.getPrice())
                    .carCompany(carReservationDTO.getCarCompany())
                    .trip(carReservationDTO.getTrip())
                    .build())
                .collect(Collectors.toList());
    }

    public List<CarReservationDTO> mapCarListToCarDTOList(List<CarReservation> carReservationList) {
        return carReservationList.stream().map(carReservation -> CarReservationDTO.builder()
                    .id(carReservation.getId())
                    .startRentDate(carReservation.getStartRentDate())
                    .endRentDate(carReservation.getEndRentDate())
                    .carType(carReservation.getCarType())
                    .numberOfRentDays(carReservation.getNumberOfRentDays())
                    .pricePerDay(carReservation.getPricePerDay())
                    .price(carReservation.getPrice())
                    .carCompany(carReservation.getCarCompany())
                    .trip(carReservation.getTrip())
                    .build())
                .collect(Collectors.toList());
    }

}
