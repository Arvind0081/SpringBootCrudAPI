package com.arvind.crudapp.services.iservices;



import java.util.List;

import com.arvind.crudapp.models.Employees;

public interface IEmployeeServices {

    String createEmployee(Employees employee);
    List<Employees> getEmployees();
    boolean deleteEmployee(Long id);
    String updateEmployee(Long id,Employees employee);
    Employees getIndividualEmployee(Long id);
}
