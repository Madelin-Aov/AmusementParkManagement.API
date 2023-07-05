package com.apm.API.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TicketOutputDTO implements Serializable {

    private Integer id;
    @JsonFormat(pattern = "dd-MM-yyyy:HH:mm")
    private Date dateTime;

    private Integer buyerId;
    private String buyerMail;

    private Integer gameId;
    private String gameName;

    public TicketOutputDTO(Integer id, Date dateTime, Integer buyerId, String buyerMail, Integer gameId, String gameName) {
        this.id = id;
        this.dateTime = dateTime;
        this.buyerId = buyerId;
        this.buyerMail = buyerMail;
        this.gameId = gameId;
        this.gameName = gameName;
    }

    public TicketOutputDTO() {
    }

}
