package com.arvind.crudapp.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arvind.crudapp.models.Employees;
import com.arvind.crudapp.services.iservices.IEmployeeServices;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@CrossOrigin("http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class EmployeeController {

  private final IEmployeeServices employeeService;

  // // Constructor Dependency injection ctor
  // public EmployeeController(IEmployeeServices employeeServices) {
  //   this.employeeService=employeeServices;
  // }


    @GetMapping("/employees")
    public ResponseEntity<List<Employees>> getAllEmployees(){
       List<Employees> res =employeeService.getEmployees();
        return new ResponseEntity<>(res,HttpStatus.OK);
    }
    
    @PostMapping("/employees")
    public ResponseEntity<String> createEmployee(@Valid @RequestBody Employees emp) {
       String res = employeeService.createEmployee(emp);
       return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
      boolean response = employeeService.deleteEmployee(id);
      return new ResponseEntity<>(response?"Record Deleted Successfully":"Error while deleting", HttpStatus.OK);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id,@Valid @RequestBody Employees employee){
      String res= employeeService.updateEmployee(id, employee);
      return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employees> getIndicidualEmployee(@PathVariable Long id){
      Employees emp=employeeService.getIndividualEmployee(id);
      return new ResponseEntity<>(emp,HttpStatus.OK);
    }

     @GetMapping("/employees/employeeByEmail/{email}")
    public ResponseEntity<Employees> getEmployeeByEmail(@PathVariable String email) {
      Employees emp= employeeService.getEmployeeByEmail(email);
        return new ResponseEntity<>(emp,HttpStatus.OK);
    }

    @GetMapping("/employees/employeeByNameFromHeader")
    public ResponseEntity<Employees> getEmployeeByName(@RequestHeader String name) {
      Employees emp= employeeService.getEmployeeByName(name);
        return new ResponseEntity<>(emp,HttpStatus.OK);
    }

// to display the annotation message
     @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
