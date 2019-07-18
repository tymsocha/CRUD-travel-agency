package com.kodilla.travelagency.business.car.facede;

import com.kodilla.travelagency.business.car.api.CarResApi;
import com.kodilla.travelagency.business.car.api.CarReservationDTO;
import com.kodilla.travelagency.business.car.mapper.CarReservationsMapper;
import com.kodilla.travelagency.business.car.service.CarReservationService;
import com.kodilla.travelagency.exceptions.CarCompanyNotFoundException;
import com.kodilla.travelagency.exceptions.CarReservationNotFoundException;
import com.kodilla.travelagency.exceptions.CarTypeNotFoundException;
import com.kodilla.travelagency.exceptions.TripNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarReservationFacade {
    @Autowired
    private CarReservationService service;

    @Autowired
    private CarReservationsMapper mapper;

    public List<CarReservationDTO> getCarReservations() {
        return mapper.mapCarListToCarDTOList(service.getAllCarReservations());
    }

    public CarReservationDTO getCarReservation(Long carReservationId) throws CarReservationNotFoundException {
        return mapper.mapCarToCarDTO(service.findCarReservationById(carReservationId));
    }

    public CarReservationDTO addCarReservation(CarReservationDTO carReservationDTO) {
        return mapper.mapCarToCarDTO(service.saveOrUpdateCarReservation(mapper.mapCarDTOToCar(carReservationDTO)));
    }

    public CarReservationDTO updateCarReservation(CarReservationDTO carReservationDTO) {
        return mapper.mapCarToCarDTO(service.saveOrUpdateCarReservation(mapper.mapCarDTOToCar(carReservationDTO)));
    }

    public void deleteCarReservation(Long carReservationId) throws CarReservationNotFoundException {
        service.deleteCarReservation(carReservationId);
    }

    public List<CarReservationDTO> getCarReservationsByCarType(Long carTypeId) throws CarTypeNotFoundException {
        return mapper.mapCarListToCarDTOList(service.getAllByCarType(carTypeId));
    }

    public List<CarReservationDTO> getCarReservationsByCompany(Long companyId) throws CarCompanyNotFoundException {
        return mapper.mapCarListToCarDTOList(service.getAllByCarCompany(companyId));
    }

    public List<CarReservationDTO> getCarReservationsByTrip(CarResApi api) throws TripNotFoundException {
        return mapper.mapCarListToCarDTOList(service.getAllByTrip(api.getTripName()));
    }

    public CarReservationDTO getCarReservationsRentDate(CarResApi api) throws CarReservationNotFoundException {
        return mapper.mapCarToCarDTO(service.getByRentStart(api.getRentStart()));
    }
}
