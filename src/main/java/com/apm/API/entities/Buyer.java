/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apm.API.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;


/**
 *
 * @author Administrator
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Buyer extends Person{


    public Buyer() {
    }

    public Buyer(Integer Id, String name, String lastName, String mail, String phone) {
        super(Id, name, lastName, mail, phone);
    }
    
    

   
}
