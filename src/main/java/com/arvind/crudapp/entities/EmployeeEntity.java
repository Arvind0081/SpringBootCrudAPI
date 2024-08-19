package com.arvind.crudapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name="EmployeeEntity")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

     @NotNull
    @Size(min = 1, max = 20)
    private String name;

    @NotNull
    @Email
    private String email;
    
    @NotNull
    @Pattern(regexp="(^$|\\d{10})")
    private String phone;
  
}
