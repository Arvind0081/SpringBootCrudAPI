package com.arvind.crudapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arvind.crudapp.entities.EmployeeEntity;
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
    
}
