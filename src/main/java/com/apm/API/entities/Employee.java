package com.apm.API.entities;

import com.apm.API.enums.EmployeeRole;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Employee extends Person implements Serializable {

   
    @ManyToOne()
    @JoinColumn(name = "game_id")
    @JsonIgnore()
    private Game game;
    
    @OneToOne()
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    @JsonIgnore()
    private User user;
    
    @Enumerated(EnumType.STRING)
    private EmployeeRole type;
    
    public Employee() {
    }

    public Employee(Game game, Integer id, String name, String lastName, String mail, String phone,EmployeeRole type) {
        super(id, name, lastName, mail, phone);
        this.game = game;
        this.type = type;
    }

  

}
