
package com.apm.API.services;

import com.apm.API.dtos.TicketsDTO;
import com.apm.API.entities.Ticket;
import com.apm.API.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRespository;
    @Autowired
    BuyerService buyerService;
    
    public void createTicket(TicketsDTO ticketsDTO) {
        Ticket ticket = new Ticket();
        ticket.setBuyer(buyerService.getBuyerById(ticketsDTO.getBuyerId()));
        ticket.setDateTime(ticketsDTO.getDateTime());
                
        ticketRespository.save(ticket);

    }
}
