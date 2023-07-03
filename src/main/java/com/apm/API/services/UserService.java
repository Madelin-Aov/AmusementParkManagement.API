package com.apm.API.services;

import com.apm.API.entities.User;
import com.apm.API.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    

    public void createUser(User user) {
       userRepository.save(user);

    }
    
    public void deleteUser(Integer id) throws Exception {
        if (userRepository.findById(id).orElse(null) == null) {
            throw new Exception("User not found");
        }
        userRepository.deleteById(id);

    }
}
