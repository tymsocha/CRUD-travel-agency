package com.kodilla.travelagency.mappers;

import com.kodilla.travelagency.business.flights.FlightCabin;
import com.kodilla.travelagency.business.flights.api.TicketDTO;
import com.kodilla.travelagency.business.flights.domain.Ticket;
import com.kodilla.travelagency.business.flights.mapper.TicketMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TicketMapperTestSuite {
    @Autowired
    private TicketMapper mapper;

    @Test
    public void testMapTicketToTicketDTO() {
        //Given
        Ticket ticket = new Ticket(1L, "Tim", "Roth", FlightCabin.ECONOMY,
                "Burger", "3A", BigDecimal.TEN, null, null, null);
        //When
        TicketDTO ticketDTO = mapper.mapTicketToTicketDTO(ticket);
        //Then
        assertEquals("Tim", ticketDTO.getFirstName());
        assertEquals("Roth", ticketDTO.getLastName());
        assertEquals("Burger", ticketDTO.getMeal());
        assertEquals("3A", ticketDTO.getSeat());
    }

    @Test
    public void testMapTicketDTOToTicket() {
        //Given
        TicketDTO ticketDTO = new TicketDTO(1L, "Tim", "Roth", FlightCabin.ECONOMY,
                "Burger", "3A", BigDecimal.TEN, null, null, null);
        //When
        Ticket ticket = mapper.mapTicketDTOToTicket(ticketDTO);
        //Then
        assertEquals("Tim", ticket.getFirstName());
        assertEquals("Roth", ticket.getLastName());
        assertEquals("Burger", ticket.getMeal());
        assertEquals("3A", ticket.getSeat());
    }

    @Test
    public void testMapTicketDTOListToTicketList() {
        //Given
        TicketDTO ticketDTO = new TicketDTO(1L, "Tim", "Roth", FlightCabin.ECONOMY,
                "Burger", "3A", BigDecimal.TEN, null, null, null);
        TicketDTO ticketDTO1 = new TicketDTO(1L, "Brad", "Pitt", FlightCabin.ECONOMY,
                "Burger", "3A", BigDecimal.TEN, null, null, null);
        TicketDTO ticketDTO2 = new TicketDTO(1L, "Angelina", "Jolie", FlightCabin.ECONOMY,
                "Burger", "3A", BigDecimal.TEN, null, null, null);
        List<TicketDTO> ticketDTOList = new ArrayList<>();
        ticketDTOList.add(ticketDTO);
        ticketDTOList.add(ticketDTO1);
        ticketDTOList.add(ticketDTO2);
        //When
        List<Ticket> ticketList = mapper.mapTicketDTOListToTicketList(ticketDTOList);
        //Then
        assertEquals(3, ticketDTOList.size());
    }

    @Test
    public void testMapTicketListToTicketDTOList() {
        //Given
        Ticket ticket = new Ticket(1L, "Tim", "Roth", FlightCabin.ECONOMY,
                "Burger", "3A", BigDecimal.TEN, null, null, null);
        Ticket ticket1 = new Ticket(1L, "Brad", "Pitt", FlightCabin.ECONOMY,
                "Burger", "3A", BigDecimal.TEN, null, null, null);
        Ticket ticket2 = new Ticket(1L, "Angelina", "Jolie", FlightCabin.ECONOMY,
                "Burger", "3A", BigDecimal.TEN, null, null, null);
        List<Ticket> ticketList = new ArrayList<>();
        ticketList.add(ticket);
        ticketList.add(ticket1);
        ticketList.add(ticket2);
        //When
        List<TicketDTO> ticketDTOList = mapper.mapTicketListToTicketDTOList(ticketList);
        //Then
        assertEquals(3, ticketDTOList.size());
    }
}
