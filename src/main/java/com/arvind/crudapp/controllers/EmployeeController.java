package com.arvind.crudapp.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arvind.crudapp.models.Employees;
import com.arvind.crudapp.services.iservices.IEmployeeServices;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

  private final IEmployeeServices employeeService;

  // // Constructor Dependency injection ctor
  // public EmployeeController(IEmployeeServices employeeServices) {
  //   this.employeeService=employeeServices;
  // }


    @GetMapping("employees")
    public List<Employees> getAllEmployees(){
        return employeeService.getEmployees();
    }
    
    @PostMapping("employees")
    public String createEmployee(@RequestBody Employees emp) {
       return employeeService.createEmployee(emp);
        
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable Long id){
      boolean response = employeeService.deleteEmployee(id);
      if(response)
      {
        return "Record Deleted Successfully";
      }else{
        return "Error while deleting";
      }
    }

    @PutMapping("employees/{ids}")
    public String updateEmployee(@PathVariable Long ids,@RequestBody Employees employee){
      
      return employeeService.updateEmployee(ids, employee);
    }

    @GetMapping("employees/{id}")
    public Employees getIndicidualEmployee(@PathVariable Long id){
      return employeeService.getIndividualEmployee(id);
    }
}
