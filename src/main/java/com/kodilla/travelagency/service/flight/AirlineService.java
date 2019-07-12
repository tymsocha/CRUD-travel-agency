package com.kodilla.travelagency.service.flight;

import com.kodilla.travelagency.core.flight.Airline;
import com.kodilla.travelagency.dao.flight.AirlineDAO;
import com.kodilla.travelagency.exceptions.AirlineNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineService {
    @Autowired
    private AirlineDAO airlineDAO;

    public List<Airline> getAllAirlines() {
        return airlineDAO.findAll();
    }

    public Airline findAirlineByParameter(String parameter) throws AirlineNotFoundException {
        return airlineDAO.findByAddressOrNameOrPhoneNumber(parameter, parameter, parameter)
                .orElseThrow(AirlineNotFoundException::new);
    }

    public Airline saveOrUpdateAirline(Airline airline) {
        return airlineDAO.save(airline);
    }

    public Airline findAirlineById(Long airlineId) throws AirlineNotFoundException {
        return airlineDAO.findById(airlineId).orElseThrow(AirlineNotFoundException::new);
    }

    public void deleteAirline(Long airlineId) throws AirlineNotFoundException {
        airlineDAO.deleteAirlineById(airlineId).orElseThrow(AirlineNotFoundException::new);
    }
}
