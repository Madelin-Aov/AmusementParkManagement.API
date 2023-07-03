package com.apm.API.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Employee extends Person implements Serializable {

   
    @ManyToOne()
    @JoinColumn(name = "game_id")
    @JsonBackReference
    private Game game;
    
    @OneToOne()
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;
    
    public Employee() {
    }

    public Employee(Game game, Integer id, String name, String lastName, String mail, String phone) {
        super(id, name, lastName, mail, phone);
        this.game = game;
    }

  

}
