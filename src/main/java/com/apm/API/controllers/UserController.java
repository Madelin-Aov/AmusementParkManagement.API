
package com.apm.API.controllers;

import com.apm.API.entities.User;
import com.apm.API.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")

@RestController
public class UserController {
    @Autowired 
    UserService userService;
    
    @PostMapping("/create")
    public void createUser(@RequestBody User user) {
        userService.createUser(user);

    }
    
    @DeleteMapping("/delete")
    public void deleteUser(@RequestParam Integer id) throws Exception{
        userService.deleteUser(id);
    }
}
