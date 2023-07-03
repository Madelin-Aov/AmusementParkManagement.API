package com.apm.API.controllers;

import com.apm.API.dtos.TicketsDTO;
import com.apm.API.entities.Ticket;
import com.apm.API.services.TicketService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/ticket")

@RestController
public class TicketController {
    @Autowired
    TicketService ticketService;
    
    @PostMapping("/create")
    public void createTicket(@RequestBody TicketsDTO ticketsDTO) {
        ticketService.createTicket(ticketsDTO);

    }
    
   @DeleteMapping("/delete")
    public void deleteTicket(@RequestParam Integer id) throws Exception {
        ticketService.deleteTicket(id);
    }
    
     @GetMapping("/getAll")
    public List<Ticket>getTickets(){
    
     return  ticketService.getTickets();
    }
    
}
