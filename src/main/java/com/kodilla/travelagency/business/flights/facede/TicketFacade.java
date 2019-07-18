package com.kodilla.travelagency.business.flights.facede;

import com.kodilla.travelagency.business.flights.api.PersonApi;
import com.kodilla.travelagency.business.flights.api.TicketDTO;
import com.kodilla.travelagency.business.flights.mapper.TicketMapper;
import com.kodilla.travelagency.business.flights.service.TicketService;
import com.kodilla.travelagency.exceptions.AirlineNotFoundException;
import com.kodilla.travelagency.exceptions.TicketNotFoundException;
import com.kodilla.travelagency.exceptions.TripNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
public class TicketFacade {
    @Autowired
    private TicketService service;

    @Autowired
    private TicketMapper mapper;

    public List<TicketDTO> getTickets() {
        return mapper.mapTicketListToTicketDTOList(service.getAllTickets());
    }

    public TicketDTO getTicket(Long ticketId) throws TicketNotFoundException {
        return mapper.mapTicketToTicketDTO(service.findTicketById(ticketId));
    }

    public TicketDTO addTicket(TicketDTO ticketDTO) {
        return mapper.mapTicketToTicketDTO(service.saveOrUpdateTicket(mapper.mapTicketDTOToTicket(ticketDTO)));
    }

    public TicketDTO updateTicket(TicketDTO ticketDTO) {
        return mapper.mapTicketToTicketDTO(service.saveOrUpdateTicket(mapper.mapTicketDTOToTicket(ticketDTO)));
    }

    public void deleteHotel(Long ticketId) throws TicketNotFoundException {
        service.deleteTicket(ticketId);
    }

    public List<TicketDTO> getTicketsForPerson(PersonApi api) {
        return mapper.mapTicketListToTicketDTOList(service.getTicketsByLastOrFirstName(api.getFirstName(), api.getLastName()));
    }

    public List<TicketDTO> getTicketsByAirline(@PathVariable Long airlineId) throws AirlineNotFoundException {
        return mapper.mapTicketListToTicketDTOList(service.getAllByAirline(airlineId));
    }

    public List<TicketDTO> getTicketsByAirlineAndTrip(Long airlineId, Long tripId
    ) throws AirlineNotFoundException, TripNotFoundException {
        return mapper.mapTicketListToTicketDTOList(service.getAllByTripAndAirline(tripId, airlineId));
    }
}
