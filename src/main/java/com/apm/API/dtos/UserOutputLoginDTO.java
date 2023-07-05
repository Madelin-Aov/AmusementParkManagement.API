package com.apm.API.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserOutputLoginDTO {
    
    private String userName;
    private String password;

    private String role;

    public UserOutputLoginDTO(String userName, String password, String role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public UserOutputLoginDTO() {
    }
    
    
}
