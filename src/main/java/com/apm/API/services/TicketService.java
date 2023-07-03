package com.apm.API.services;

import com.apm.API.dtos.TicketsDTO;
import com.apm.API.entities.Ticket;
import com.apm.API.repositories.TicketRepository;
import java.util.List;
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

    public void deleteTicket(Integer id) throws Exception {
        if (ticketRespository.findById(id).orElse(null) == null) {
            throw new Exception("Ticket not found");
        }
        ticketRespository.deleteById(id);
    }
    
      public List<Ticket> getTickets() {
        return ticketRespository.findAll();
    }
      
}
