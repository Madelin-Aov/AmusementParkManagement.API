package com.apm.API.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
//@Entity
//@PrimaryKeyJoinColumn(name = "id")
public class Employee extends Person {
    private Integer employeeId;
    private Game game;
    @OneToOne
    private User user;
}
