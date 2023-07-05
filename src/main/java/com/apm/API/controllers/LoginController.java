package com.apm.API.controllers;

import com.apm.API.dtos.UserInputLoginDTO;
import com.apm.API.dtos.UserOutputLoginDTO;
import com.apm.API.entities.User;
import com.apm.API.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public UserOutputLoginDTO login(@RequestBody UserInputLoginDTO user ) {
        return userService.getUser(user.getUserName(), user.getPassword());
    }

}
