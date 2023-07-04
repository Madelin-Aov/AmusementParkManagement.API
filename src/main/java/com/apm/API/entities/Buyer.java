/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apm.API.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author Administrator
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Buyer extends Person {

    @OneToMany(mappedBy = "buyer")
    @JsonIgnore()    
    private List<Ticket> tickets;

    public Buyer() {
    }

    public Buyer(Integer Id, String name, String lastName, String mail, String phone) {
        super(Id, name, lastName, mail, phone);
    }

}
