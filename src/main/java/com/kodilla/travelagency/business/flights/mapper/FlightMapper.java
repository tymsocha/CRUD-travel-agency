package com.kodilla.travelagency.business.flights.mapper;

import com.kodilla.travelagency.business.flights.api.FlightDTO;
import com.kodilla.travelagency.business.flights.domain.Flight;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FlightMapper {
    public Flight mapFlightDTOToFlight(FlightDTO flightDTO) {
        return Flight.builder()
                .id(flightDTO.getId())
                .airplaneModel(flightDTO.getAirplaneModel())
                .origin(flightDTO.getOrigin())
                .destination(flightDTO.getDestination())
                .departureDate(flightDTO.getDepartureDate())
                .arrivalDate(flightDTO.getArrivalDate())
                .airplaneModel(flightDTO.getAirplaneModel())
                .flightDuration(flightDTO.getFlightDuration())
                .ticketList(flightDTO.getTicketList())
                .build();
    }

    public FlightDTO mapFlightToFlightDTO(Flight flight) {
        return FlightDTO.builder()
                .id(flight.getId())
                .origin(flight.getOrigin())
                .destination(flight.getDestination())
                .airline(flight.getAirline())
                .departureDate(flight.getDepartureDate())
                .arrivalDate(flight.getArrivalDate())
                .airplaneModel(flight.getAirplaneModel())
                .flightDuration(flight.getFlightDuration())
                .ticketList(flight.getTicketList())
                .build();
    }

    public List<Flight> mapFlightDTOListToFlightList(List<FlightDTO> flightDTOList) {
        return flightDTOList.stream().map(flightDTO -> Flight.builder()
                    .id(flightDTO.getId())
                    .origin(flightDTO.getOrigin())
                    .destination(flightDTO.getDestination())
                    .airline(flightDTO.getAirline())
                    .departureDate(flightDTO.getDepartureDate())
                    .arrivalDate(flightDTO.getArrivalDate())
                    .airplaneModel(flightDTO.getAirplaneModel())
                    .flightDuration(flightDTO.getFlightDuration())
                    .ticketList(flightDTO.getTicketList())
                    .build())
                .collect(Collectors.toList());
    }

    public List<FlightDTO> mapFlightListToFlightDTOList(List<Flight> flightList) {
        return flightList.stream().map(flight -> FlightDTO.builder()
                    .id(flight.getId())
                    .airline(flight.getAirline())
                    .origin(flight.getOrigin())
                    .destination(flight.getDestination())
                    .departureDate(flight.getDepartureDate())
                    .arrivalDate(flight.getArrivalDate())
                    .airplaneModel(flight.getAirplaneModel())
                    .flightDuration(flight.getFlightDuration())
                    .ticketList(flight.getTicketList())
                    .build())
                .collect(Collectors.toList());
    }
}
