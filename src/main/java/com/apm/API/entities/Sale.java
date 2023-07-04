package com.apm.API.entities;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.time.LocalDate;
import javax.persistence.Entity;

import java.util.Date;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter @Setter
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToMany(mappedBy = "sale")
     @JsonManagedReference
    private List<Ticket> tickets;
     @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate saleDate;
    
    private Integer totalPrice;
    
    public Sale() {
    }
 
    
}
