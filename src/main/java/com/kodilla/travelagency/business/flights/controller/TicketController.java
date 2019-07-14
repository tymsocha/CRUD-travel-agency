package com.kodilla.travelagency.business.flights.controller;

import com.kodilla.travelagency.business.flights.api.PersonApi;
import com.kodilla.travelagency.business.flights.api.TicketDTO;
import com.kodilla.travelagency.business.flights.mapper.TicketMapper;
import com.kodilla.travelagency.business.flights.service.TicketService;
import com.kodilla.travelagency.exceptions.AirlineNotFoundException;
import com.kodilla.travelagency.exceptions.TicketNotFoundException;
import com.kodilla.travelagency.exceptions.TripNotFoundException;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@Transactional
@RequestMapping("v1/travel/ticket")
public class TicketController {
    @Autowired
    private TicketService service;

    @Autowired
    private TicketMapper mapper;

    @ApiOperation(value = "Get All Tickets")
    @GetMapping(value = "getAll")
    public List<TicketDTO> getTickets() {
        return mapper.mapTicketListToTicketDTOList(service.getAllTickets());
    }

    @ApiOperation(value = "Get Ticket By Id")
    @GetMapping(value = "get/{ticketId}")
    public TicketDTO getTicket(@PathVariable Long ticketId) throws TicketNotFoundException {
        return mapper.mapTicketToTicketDTO(service.findTicketById(ticketId));
    }

    @ApiOperation(value = "Add Ticket to Base")
    @PostMapping(value = "add", consumes = APPLICATION_JSON_VALUE)
    public TicketDTO addTicket(@RequestBody TicketDTO ticketDTO) {
        return mapper.mapTicketToTicketDTO(service.saveOrUpdateTicket(mapper.mapTicketDTOToTicket(ticketDTO)));
    }

    @ApiOperation(value = "Update Ticket Details")
    @PutMapping(value = "update", consumes = APPLICATION_JSON_VALUE)
    public TicketDTO updateTicket(@RequestBody TicketDTO ticketDTO) {
        return mapper.mapTicketToTicketDTO(service.saveOrUpdateTicket(mapper.mapTicketDTOToTicket(ticketDTO)));
    }

    @ApiOperation(value = "Delete Ticket")
    @DeleteMapping(value = "delete/{ticketId}")
    public void deleteHotel(@PathVariable Long ticketId) throws TicketNotFoundException {
        service.deleteTicket(ticketId);
    }

    @ApiOperation(value = "Get All Tickets for Person")
    @GetMapping(value = "getAll/person")
    public List<TicketDTO> getTicketsForPerson(@RequestBody PersonApi api) {
        return mapper.mapTicketListToTicketDTOList(service.getTicketsByLastOrFirstName(api.getFirstName(), api.getLastName()));
    }

    @ApiOperation(value = "Get All Tickets By Airline")
    @GetMapping(value = "getAll/airline/{airlineId}")
    public List<TicketDTO> getTicketsByAirline(@PathVariable Long airlineId) throws AirlineNotFoundException {
        return mapper.mapTicketListToTicketDTOList(service.getAllByAirline(airlineId));
    }

    @ApiOperation(value = "Get All Tickets By Airline")
    @GetMapping(value = "getAll/airline/{airlineId}/trip/{tripId}")
    public List<TicketDTO> getTicketsByAirlineAndTrip(
            @PathVariable Long airlineId,
            @PathVariable Long tripId
    ) throws AirlineNotFoundException, TripNotFoundException {
        return mapper.mapTicketListToTicketDTOList(service.getAllByTripAndAirline(tripId, airlineId));
    }
}
