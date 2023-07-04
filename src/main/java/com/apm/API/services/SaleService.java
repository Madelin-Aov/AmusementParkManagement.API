package com.apm.API.services;

import com.apm.API.dtos.SaleDTO;
import com.apm.API.dtos.TicketsDTO;
import com.apm.API.entities.Game;
import com.apm.API.entities.Sale;
import com.apm.API.entities.Ticket;
import com.apm.API.repositories.SaleRepository;
import com.apm.API.repositories.TicketRepository;
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
        for (TicketsDTO ticketDTO : saleDto.getTicketsDto()) {
            Game game = gameService.getById(ticketDTO.getGameId());
            totalPrice = game.getPrice() + totalPrice;
        }
        sale.setTotalPrice(totalPrice);
        saleRepository.save(sale);

        for (TicketsDTO ticketDTO : saleDto.getTicketsDto()) {
            Ticket ticket = new Ticket();
            ticket.setDateTime(ticketDTO.getDateTime());
            ticket.setBuyer(buyerService.getBuyerById(ticketDTO.getBuyerId()));
            ticket.setSale(sale);
            ticketRepository.save(ticket);
        }

    }

    public void deleteSale(Integer id) throws Exception {
        if (saleRepository.findById(id).orElse(null) == null) {
            throw new Exception("Sale not found");
        }
        saleRepository.deleteById(id);

    }

    public List<Sale> getSales() {
        return saleRepository.findAll();
    }

}
