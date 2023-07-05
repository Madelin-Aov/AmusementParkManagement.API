package com.apm.API.services;

import com.apm.API.dtos.TicketDTO;
import com.apm.API.dtos.TicketOutputDTO;
import com.apm.API.entities.Ticket;
import com.apm.API.repositories.TicketRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRespository;
    @Autowired
    BuyerService buyerService;

    public void createTicket(TicketDTO ticketsDTO) {
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

    public List<TicketOutputDTO> getTickets() {
        List<TicketOutputDTO> tickets = new ArrayList();
        for (Ticket ticket : ticketRespository.findAll()) {
            TicketOutputDTO ticketOutputDTO = new TicketOutputDTO(
                    ticket.getId(), ticket.getDateTime(), ticket.getBuyer().getId(),
                    ticket.getBuyer().getMail(), ticket.getGame().getId(), ticket.getGame().getName());
            tickets.add(ticketOutputDTO);
        }
        return tickets;
    }

}
