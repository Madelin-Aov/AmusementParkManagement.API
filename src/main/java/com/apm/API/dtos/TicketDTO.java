
package com.apm.API.dtos;

import com.apm.API.entities.Buyer;
import com.apm.API.entities.Sale;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TicketDTO {
    private Integer id;
    @JsonFormat(pattern="dd-MM-yyyy:HH:mm")
    private Date dateTime;
    
    private Integer buyerId;
    
    private Integer gameId;

    public TicketDTO() {
    }
    
      
}
