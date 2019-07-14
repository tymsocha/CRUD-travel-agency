package com.kodilla.travelagency.business.car.service;

import com.kodilla.travelagency.business.car.domain.CarCompany;
import com.kodilla.travelagency.business.car.domain.CarReservation;
import com.kodilla.travelagency.business.car.domain.CarType;
import com.kodilla.travelagency.business.car.dao.CarReservationsDAO;
import com.kodilla.travelagency.business.trip.domain.Trip;
import com.kodilla.travelagency.exceptions.CarCompanyNotFoundException;
import com.kodilla.travelagency.exceptions.CarReservationNotFoundException;
import com.kodilla.travelagency.exceptions.CarTypeNotFoundException;
import com.kodilla.travelagency.exceptions.TripNotFoundException;
import com.kodilla.travelagency.business.trip.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CarReservationService {
    @Autowired
    private CarReservationsDAO carReservationsDAO;

    @Autowired
    private CarCompanyService carCompanyService;

    @Autowired
    private CarTypeService carTypeService;

    @Autowired
    private TripService tripService;

    public List<CarReservation> getAllCarReservations() {
        return carReservationsDAO.findAll();
    }

    public CarReservation saveOrUpdateCarReservation(CarReservation carReservation) {
        return carReservationsDAO.save(carReservation);
    }

    public CarReservation findCarReservationById(Long carTypeId) throws CarReservationNotFoundException {
        return carReservationsDAO.findById(carTypeId).orElseThrow(CarReservationNotFoundException::new);
    }

    public void deleteCarReservation(Long carTypeId) throws CarReservationNotFoundException {
        carReservationsDAO.deleteCarReservationById(carTypeId).orElseThrow(CarReservationNotFoundException::new);
    }

    public List<CarReservation> getAllByCarType(Long carTypeId) throws CarTypeNotFoundException {
        CarType carType = carTypeService.findCarTypeById(carTypeId);
        return carReservationsDAO.findAllByCarType(carType);
    }

    public List<CarReservation> getAllByCarCompany(Long carCompanyId) throws CarCompanyNotFoundException {
        CarCompany carCompany = carCompanyService.findCarCompanyById(carCompanyId);
        return carReservationsDAO.findAllByCarCompany(carCompany);
    }

    public List<CarReservation> getAllByTrip(String tripName) throws TripNotFoundException {
        Trip trip = tripService.findTripByTripName(tripName);
        return carReservationsDAO.findAllByTrip(trip);
    }

    public CarReservation getByRentStart(String dateString) throws CarReservationNotFoundException {
        LocalDateTime dateTimeFromString = LocalDateTime.parse(dateString);
        return carReservationsDAO.findByStartRentDate(dateTimeFromString).orElseThrow(CarReservationNotFoundException::new);
    }
}
