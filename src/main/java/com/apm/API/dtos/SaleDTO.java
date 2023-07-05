package com.apm.API.dtos;

import com.apm.API.entities.Ticket;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SaleDTO {

    private Integer id;
   
    private List<TicketDTO> ticketsDto;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate saleDate;

    public SaleDTO() {
    }

   

}
