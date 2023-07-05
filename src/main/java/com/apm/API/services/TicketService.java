package com.apm.API.services;

import com.apm.API.dtos.TicketDTO;
import com.apm.API.dtos.TicketOutputDTO;
import com.apm.API.entities.Game;
import com.apm.API.entities.Sale;
import com.apm.API.entities.Ticket;
import com.apm.API.repositories.SaleRepository;
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

    @Autowired
    GameService gameService;

    @Autowired
    SaleService saleService;

    public void createTicket(TicketDTO ticketsDTO) {
        Ticket ticket = new Ticket();
        ticket.setBuyer(buyerService.getBuyerById(ticketsDTO.getBuyerId()));
        ticket.setDateTime(ticketsDTO.getDateTime());

        ticketRespository.save(ticket);

    }

    public void deleteTicket(Integer id) throws Exception {
        Ticket ticketToDelete = ticketRespository.findById(id).orElse(null);
        Sale saleToUpdateTotalPrice = ticketToDelete.getSale();
        if (ticketToDelete == null) {
            throw new Exception("Ticket not found");
        }
        ticketRespository.deleteById(id);

        //RECALCULO EL PRECIO TOTAL DE LA VENTA
        saleService.updateTotalPrice(saleToUpdateTotalPrice);
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

    public void editTicket(TicketDTO ticketDTO) throws Exception {
        Ticket ticketToUpdate = ticketRespository.findById(ticketDTO.getId()).orElse(null);
        if (ticketToUpdate == null) {
            throw new Exception("Ticket not found");
        }
        ticketToUpdate.setDateTime(ticketDTO.getDateTime());

        ticketToUpdate.setBuyer(buyerService.getBuyerById(ticketDTO.getBuyerId()));
        ticketToUpdate.setGame(gameService.getById(ticketDTO.getGameId()));

        ticketRespository.save(ticketToUpdate);

        //RECALCULO EL PRECIO TOTAL DE LA VENTA
        saleService.updateTotalPrice(ticketToUpdate.getSale());
    }

}
