package com.kodilla.travelagency.mapper.flight;

import com.kodilla.travelagency.core.flight.Airline;
import com.kodilla.travelagency.api.flight.AirlineDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AirlineMapper {
    public AirlineDTO mapAirlineToAirlineDTO(Airline airline) {
        return AirlineDTO.builder()
                .id(airline.getId())
                .name(airline.getName())
                .address(airline.getAddress())
                .phoneNumber(airline.getPhoneNumber())
                .build();
    }

    public Airline mapAirlineDTOToAirline(AirlineDTO airlineDTO) {
        return Airline.builder()
                .id(airlineDTO.getId())
                .name(airlineDTO.getName())
                .address(airlineDTO.getAddress())
                .phoneNumber(airlineDTO.getPhoneNumber())
                .build();
    }

    public List<Airline> mapAirlineDTOListToAirlineList(List<AirlineDTO> airlineDTOList) {
        return airlineDTOList.stream().map(airlineDTO -> Airline.builder()
                    .id(airlineDTO.getId())
                    .name(airlineDTO.getName())
                    .address(airlineDTO.getAddress())
                    .phoneNumber(airlineDTO.getPhoneNumber())
                    .build())
                .collect(Collectors.toList());
    }

    public List<AirlineDTO> mapAirlineListToAirlineDTOList(List<Airline> airlineList) {
        return airlineList.stream().map(airline -> AirlineDTO.builder()
                    .id(airline.getId())
                    .name(airline.getName())
                    .address(airline.getAddress())
                    .phoneNumber(airline.getPhoneNumber())
                    .build())
                .collect(Collectors.toList());
    }
}
