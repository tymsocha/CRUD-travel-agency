package com.kodilla.travelagency.business.flights.mapper;

import com.kodilla.travelagency.business.flights.api.TicketDTO;
import com.kodilla.travelagency.business.flights.domain.Ticket;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TicketMapper {
    public TicketDTO mapTicketToTicketDTO(Ticket ticket) {
        return TicketDTO.builder()
                .id(ticket.getId())
                .firstName(ticket.getFirstName())
                .lastName(ticket.getLastName())
                .flightCabin(ticket.getFlightCabin())
                .seat(ticket.getSeat())
                .meal(ticket.getMeal())
                .price(ticket.getPrice())
                .trip(ticket.getTrip())
                .build();
    }

    public Ticket mapTicketDTOToTicket(TicketDTO ticketDTO) {
        return Ticket.builder()
                .id(ticketDTO.getId())
                .firstName(ticketDTO.getFirstName())
                .lastName(ticketDTO.getLastName())
                .flightCabin(ticketDTO.getFlightCabin())
                .seat(ticketDTO.getSeat())
                .meal(ticketDTO.getMeal())
                .price(ticketDTO.getPrice())
                .trip(ticketDTO.getTrip())
                .build();
    }

    public List<Ticket> mapTicketDTOListToTicketList(List<TicketDTO> ticketDTOList) {
        return ticketDTOList.stream().map(ticketDTO -> Ticket.builder()
                    .id(ticketDTO.getId())
                    .firstName(ticketDTO.getFirstName())
                    .lastName(ticketDTO.getLastName())
                    .flightCabin(ticketDTO.getFlightCabin())
                    .seat(ticketDTO.getSeat())
                    .meal(ticketDTO.getMeal())
                    .price(ticketDTO.getPrice())
                    .trip(ticketDTO.getTrip())
                    .build())
                .collect(Collectors.toList());
    }

    public List<TicketDTO> mapTicketListToTicketDTOList(List<Ticket> ticketList) {
        return ticketList.stream().map(ticket -> TicketDTO.builder()
                    .id(ticket.getId())
                    .firstName(ticket.getFirstName())
                    .lastName(ticket.getLastName())
                    .flightCabin(ticket.getFlightCabin())
                    .seat(ticket.getSeat())
                    .meal(ticket.getMeal())
                    .price(ticket.getPrice())
                    .trip(ticket.getTrip())
                    .build())
                .collect(Collectors.toList());
    }
}
