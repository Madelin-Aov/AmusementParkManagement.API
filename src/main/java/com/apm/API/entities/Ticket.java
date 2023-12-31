
package com.apm.API.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter @Setter
public class Ticket implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @JsonFormat(pattern="dd-MM-yyyy:HH:mm")
    private Date dateTime;
    
    @ManyToOne()
    @JoinColumn(name = "buyer_id")
    @JsonIgnore()
    private Buyer buyer;
    
    @ManyToOne()
    @JoinColumn(name="sale_id")
    @JsonBackReference
    private Sale sale;
         
    @ManyToOne()
    @JoinColumn(name="game_id")
    @JsonBackReference
    private Game game;
        
    public Ticket() {
    }

    public Ticket(Integer id, Date dateTime, Buyer buyer, Sale sale) {
        this.id = id;
        this.dateTime = dateTime;
        this.buyer = buyer;
        this.sale = sale;
    }

   
    
    
}
