package com.apm.API.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter @Setter
public class Game implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
//    @OneToMany
//    private List<Employee> employeesList;
    @OneToMany(mappedBy = "game")
    @JsonManagedReference
    private List<Schedule> schedules;
    private Integer price;
    public Game() {
    }

    public Game(Integer id, String name, List<Schedule> schedules, Integer price) {
        this.id = id;
        this.name = name;
        this.schedules = schedules;
        this.price = price;
    }

   

   


    
    
    
}
