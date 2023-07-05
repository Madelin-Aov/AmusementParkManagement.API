package com.apm.API.services;

import com.apm.API.dtos.UserInputDTO;
import com.apm.API.entities.Employee;
import com.apm.API.entities.User;
import com.apm.API.repositories.EmployeeRepository;
import com.apm.API.repositories.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    

    public void createUser(UserInputDTO user) {
       Employee employee = employeeRepository.findById(user.getEmployeeId()).orElse(null);
       User newUser = new User(user.getUserName(),user.getPassword());
       userRepository.save(newUser);
       
       employee.setUser(newUser);
       employeeRepository.save(employee);
    }
    
    public void deleteUser(Integer id) throws Exception {
        if (userRepository.findById(id).orElse(null) == null) {
            throw new Exception("User not found");
        }
        userRepository.deleteById(id);

    }
    
    public List<User> getUser(){
        return userRepository.findAll();
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUserName())
                .password(user.getPassword())
                .roles(user.getEmployee().getType().toString())
                //.roles("ADMIN")
                .build();
    }
}
