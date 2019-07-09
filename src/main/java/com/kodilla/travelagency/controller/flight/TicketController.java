package com.kodilla.travelagency.controller.flight;

import com.kodilla.travelagency.api.flight.TicketDTO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@Transactional
@RequestMapping("v1/travel/ticket")
public class TicketController {
    @GetMapping(value = "getTickets")
    public List<TicketDTO> getTickets() {
        return new ArrayList<>();
    }

    @GetMapping(value = "getTicket/{ticketId}")
    public TicketDTO getTicket(@PathVariable Long ticketId) {
        return new TicketDTO();
    }

    @PostMapping(value = "saveTicket", consumes = APPLICATION_JSON_VALUE)
    public TicketDTO saveTicket(@RequestBody TicketDTO ticketDTO) {
        return ticketDTO;
    }

    @PutMapping(value = "updateTicket", consumes = APPLICATION_JSON_VALUE)
    public TicketDTO updateTicket(@RequestBody TicketDTO ticketDTO) {
        return ticketDTO;
    }

    @DeleteMapping(value = "deleteTicket/{ticketId}")
    public void deleteTicket(@PathVariable Long ticketId) {

    }
}
