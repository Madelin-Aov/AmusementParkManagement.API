
package com.apm.API.entities;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class User {
    @Id
    private Integer id;
    private String password;
    private String userName;
    @OneToOne(mappedBy = "user")
    private Employee employee;
    

    public User(String password, String userName) {
        this.password = password;
        this.userName = userName;
    }
    
    
}
