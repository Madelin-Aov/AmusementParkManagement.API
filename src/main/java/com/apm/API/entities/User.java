
package com.apm.API.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)   
    private Integer id;
    private String password;
    private String userName;
    @OneToOne(mappedBy = "user")
    @JsonIgnore()
    private Employee employee;
    
    
    
    public User() {
    }
       
    public User(String password, String userName) {
        this.password = password;
        this.userName = userName;
    }
    
    
    
}
