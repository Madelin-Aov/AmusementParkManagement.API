
package com.apm.API.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.InheritanceType;
import javax.persistence.Inheritance;
import javax.persistence.MappedSuperclass;


@MappedSuperclass

public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String name;
    public String lastName;
    public String mail;
    public String phone;
   
    public Person() {
    }

    public Person(Integer id, String name, String lastName, String mail, String phone) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.mail = mail;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer Id) {
        this.id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
  
}
