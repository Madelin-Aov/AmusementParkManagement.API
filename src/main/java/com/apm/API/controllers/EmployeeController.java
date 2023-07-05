
package com.apm.API.controllers;


import com.apm.API.entities.Employee;
import com.apm.API.services.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/employee")

@RestController
public class EmployeeController {
    
    @Autowired
    EmployeeService employeeService;
    
    @PostMapping("/create")
    public void createEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);

    }
    
     @DeleteMapping("/delete")
     public void deleteEmployee(@RequestParam Integer id) throws Exception {
        employeeService.deleteEmployee(id);
    }
    
    @GetMapping("/getAll")
    public List<Employee> getAll(){
    
     return  employeeService.getAll();
    } 
}
