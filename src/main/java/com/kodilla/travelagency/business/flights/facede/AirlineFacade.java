package com.kodilla.travelagency.business.flights.facede;

import com.kodilla.travelagency.business.flights.api.AirlineDTO;
import com.kodilla.travelagency.business.flights.mapper.AirlineMapper;
import com.kodilla.travelagency.business.flights.service.AirlineService;
import com.kodilla.travelagency.exceptions.AirlineNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AirlineFacade {
    @Autowired
    private AirlineService service;

    @Autowired
    private AirlineMapper mapper;

    public List<AirlineDTO> getAirlines() {
        return mapper.mapAirlineListToAirlineDTOList(service.getAllAirlines());
    }

    public AirlineDTO getAirline(Long airlineId) throws AirlineNotFoundException {
        return mapper.mapAirlineToAirlineDTO(service.findAirlineById(airlineId));
    }

    public AirlineDTO getAirline(String parameter) throws AirlineNotFoundException {
        return mapper.mapAirlineToAirlineDTO(service.findAirlineByParameter(parameter));
    }

    public AirlineDTO addAirline(AirlineDTO airlineDTO) {
        return mapper.mapAirlineToAirlineDTO(service.saveOrUpdateAirline(mapper.mapAirlineDTOToAirline(airlineDTO)));
    }

    public AirlineDTO updateAirline(AirlineDTO airlineDTO) {
        return mapper.mapAirlineToAirlineDTO(service.saveOrUpdateAirline(mapper.mapAirlineDTOToAirline(airlineDTO)));
    }

    public void deleteAirline(Long airlineId) {
        service.deleteAirline(airlineId);
    }
}
