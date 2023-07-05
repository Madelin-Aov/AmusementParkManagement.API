package com.apm.API.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserInputDTO {

    private Integer id;
    private String userName;
    private String password;

    private Integer employeeId;

    public UserInputDTO() {
    }

    public UserInputDTO(String password, String userName, Integer employeeId) {
        this.password = password;
        this.userName = userName;
        this.employeeId = employeeId;
    }

}
