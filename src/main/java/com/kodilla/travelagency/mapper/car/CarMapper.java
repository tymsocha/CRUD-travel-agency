package com.kodilla.travelagency.mapper.car;

import com.kodilla.travelagency.core.car.Car;
import com.kodilla.travelagency.dto.car.CarDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarMapper {
    public CarDTO mapCarToCarDTO(Car car) {
        return CarDTO.builder()
                .id(car.getId())
                .companyName(car.getCompanyName())
                .startRentDate(car.getStartRentDate())
                .endRentDate(car.getEndRentDate())
                .carType(car.getCarType())
                .numberOfRentDays(car.getNumberOfRentDays())
                .pricePerDay(car.getPricePerDay())
                .price(car.getPrice())
                .build();
    }

    public Car mapCarDTOToCar(CarDTO carDTO) {
        return Car.builder()
                .id(carDTO.getId())
                .companyName(carDTO.getCompanyName())
                .startRentDate(carDTO.getStartRentDate())
                .endRentDate(carDTO.getEndRentDate())
                .carType(carDTO.getCarType())
                .numberOfRentDays(carDTO.getNumberOfRentDays())
                .pricePerDay(carDTO.getPricePerDay())
                .price(carDTO.getPrice())
                .build();
    }

    public List<Car> mapCarDTOListToCarList(List<CarDTO> carDTOList) {
        return carDTOList.stream().map(carDTO -> Car.builder()
                    .id(carDTO.getId())
                    .companyName(carDTO.getCompanyName())
                    .startRentDate(carDTO.getStartRentDate())
                    .endRentDate(carDTO.getEndRentDate())
                    .carType(carDTO.getCarType())
                    .numberOfRentDays(carDTO.getNumberOfRentDays())
                    .pricePerDay(carDTO.getPricePerDay())
                    .price(carDTO.getPrice())
                    .build())
                .collect(Collectors.toList());
    }

    public List<CarDTO> mapCarListToCarDTOList(List<Car> carList) {
        return carList.stream().map(car -> CarDTO.builder()
                    .id(car.getId())
                    .companyName(car.getCompanyName())
                    .startRentDate(car.getStartRentDate())
                    .endRentDate(car.getEndRentDate())
                    .carType(car.getCarType())
                    .numberOfRentDays(car.getNumberOfRentDays())
                    .pricePerDay(car.getPricePerDay())
                    .price(car.getPrice())
                    .build())
                .collect(Collectors.toList());
    }

}
