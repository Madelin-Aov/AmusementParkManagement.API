package com.apm.API.services;

import com.apm.API.entities.Employee;
import com.apm.API.entities.Game;
import com.apm.API.entities.User;
import com.apm.API.repositories.EmployeeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);

    }

    public void deleteEmployee(Integer id) throws Exception {
        if (employeeRepository.findById(id).orElse(null) == null) {
            throw new Exception("Employee not found");
        }
        employeeRepository.deleteById(id);
    }
    
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
    
    public Employee getById(Integer id){
        return employeeRepository.findById(id).orElse(null);
    }
    
}
