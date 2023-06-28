
package com.apm.API.entities;

import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {
    private String password;
    private String userName;
//    @OneToOne(mappedBy = "employee-id" )
    //private Employee employee;
    public User() {
    }

    public User(String password, String userName) {
        this.password = password;
        this.userName = userName;
    }
    
    
}
