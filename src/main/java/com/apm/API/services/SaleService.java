package com.apm.API.services;

import com.apm.API.dtos.SaleDTO;
import com.apm.API.dtos.TicketDTO;
import com.apm.API.entities.Game;
import com.apm.API.entities.Sale;
import com.apm.API.entities.Ticket;
import com.apm.API.repositories.SaleRepository;
import com.apm.API.repositories.TicketRepository;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService {
    
    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private BuyerService buyerService;
    @Autowired
    private TicketRepository ticketRepository;
    
    @Autowired
    private GameService gameService;
    
    public void createSale(SaleDTO saleDto) {
        
        Sale sale = new Sale();
        sale.setSaleDate(saleDto.getSaleDate());
        Integer totalPrice = 0;
        for (TicketDTO ticketDTO : saleDto.getTicketsDto()) {
            Game game = gameService.getById(ticketDTO.getGameId());
            totalPrice = game.getPrice() + totalPrice;
        }
        sale.setTotalPrice(totalPrice);
        saleRepository.save(sale);
        
        for (TicketDTO ticketDTO : saleDto.getTicketsDto()) {
            Ticket ticket = new Ticket();
            ticket.setDateTime(ticketDTO.getDateTime());
            ticket.setBuyer(buyerService.getBuyerById(ticketDTO.getBuyerId()));
            ticket.setGame(gameService.getById(ticketDTO.getGameId()));
            ticket.setSale(sale);
            ticketRepository.save(ticket);
        }
        
    }
    
    public void deleteSale(Integer id) throws Exception {
        Sale saleToDelete = saleRepository.findById(id).orElse(null);
        if (saleToDelete == null) {
            throw new Exception("Sale not found");
        }
        
        for (Ticket ticket : saleToDelete.getTickets()) {
            ticketRepository.deleteById(ticket.getId());
        }
        
        saleRepository.deleteById(id);
        
    }
    
    public List<Sale> getSales() {
        return saleRepository.findAll();
    }
    
    public void editDate(LocalDate saleDate, Integer id) throws Exception {
        Sale sale = saleRepository.findById(id).orElse(null);
        if (sale == null) {
            throw new Exception("Sale not found");
        }
        sale.setSaleDate(saleDate);
        saleRepository.save(sale);
    }
    
    public Sale getById(Integer id){
        return saleRepository.findById(id).orElse(null);
    }
    
    public void updateTotalPrice(Sale sale){
        Integer totalPrice = 0;
        for (Ticket ticket : sale.getTickets()) {
            totalPrice = ticket.getGame().getPrice() + totalPrice;
        }
        sale.setTotalPrice(totalPrice);
        saleRepository.save(sale);
    }
}
