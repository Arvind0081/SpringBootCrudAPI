package com.arvind.crudapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.arvind.crudapp.entities.EmployeeEntity;
import com.arvind.crudapp.models.Employees;
import com.arvind.crudapp.repository.EmployeeRepository;
import com.arvind.crudapp.services.iservices.IEmployeeServices;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServices implements IEmployeeServices{

   private final EmployeeRepository employeeRepository;

    @Override
    public String createEmployee(Employees employee) {
      EmployeeEntity employeeEntity=new EmployeeEntity();
      BeanUtils.copyProperties(employee,employeeEntity);
      employeeRepository.save(employeeEntity);
      // employees.add(employee);
       return "Employee Successfully added.";
    }

    @Override
    public List<Employees> getEmployees() {
      List<EmployeeEntity> employeeList = employeeRepository.findAll();
      List<Employees> employees = new ArrayList<>();
      //for loop
      for (int i = 0; i < employeeList.size(); i++) {
         Employees emp= new Employees();
         EmployeeEntity employeeEntity = employeeList.get(i);
         emp.setId(employeeEntity.getId());
         emp.setName(employeeEntity.getName());
         emp.setEmail(employeeEntity.getEmail());
         emp.setPhone(employeeEntity.getPhone());

         employees.add(emp);
      }

        //for each
      // for(EmployeeEntity employeeEntity: employeeList){
      //    Employees emp= new Employees();
      //    emp.setId(employeeEntity.getId());
      //    emp.setName(employeeEntity.getName());
      //    emp.setEmail(employeeEntity.getEmail());
      //    emp.setPhone(employeeEntity.getPhone());

      //    employees.add(emp);
      // }
       return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
      EmployeeEntity emp=employeeRepository.findById(id).get();
      employeeRepository.delete(emp);
       return true;
    }

   @Override
   public String updateEmployee(Long id, Employees employee) {
      EmployeeEntity employeeEntity= employeeRepository.findById(id).get();
      employeeEntity.setName(employee.getName());
      employeeEntity.setEmail(employee.getEmail());
      employeeEntity.setPhone(employee.getPhone());
      employeeRepository.save(employeeEntity);
     return "Employee Updated Successfully";
   }

   @Override
   public Employees getIndividualEmployee(Long id) {
      EmployeeEntity emp= employeeRepository.findById(id).get();
      Employees employee=new Employees();
      BeanUtils.copyProperties(emp,employee);
      return employee;

   }
 
}
