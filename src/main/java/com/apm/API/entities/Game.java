package com.apm.API.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;


@Entity
@Getter @Setter
public class Game implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    
    @OneToMany(mappedBy = "game")
    @JsonManagedReference 
    private List<Employee> employeesList;
    
    @OneToMany(mappedBy = "game")
    @JsonManagedReference
    private List<Schedule> schedules;
    
    private Integer price;
    
    @OneToMany(mappedBy = "game")
    @JsonManagedReference
    private List<Ticket> tickets;
    
    public Game() {
    }

    public Game(Integer id, String name, List<Employee> employeesList, List<Schedule> schedules, Integer price, List<Ticket> tickets) {
        this.id = id;
        this.name = name;
        this.employeesList = employeesList;
        this.schedules = schedules;
        this.price = price;
        this.tickets = tickets;
    }
    
    
}
