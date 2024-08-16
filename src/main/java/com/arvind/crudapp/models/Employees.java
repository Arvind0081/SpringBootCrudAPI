package com.arvind.crudapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employees {
    private Long id;
    private String name;
    private String email;
    private String phone;

}

 
