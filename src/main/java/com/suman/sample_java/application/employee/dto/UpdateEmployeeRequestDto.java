package com.suman.sample_java.application.employee.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.suman.sample_java.domain.entity.Employee;

import lombok.Data;

@Data
public class UpdateEmployeeRequestDto {
    @JsonAlias("first_name")
    private String FirstName;
    @JsonAlias("last_name")
    private String LastName;
    @JsonAlias("email")
    private String Email;
    @JsonAlias("phone")
    private String Phone;
    public Employee MapToEmployeeEntity() {
        return Employee.builder()
            .FirstName(this.FirstName)
            .LastName(this.LastName)
            .Phone(this.Phone)
            .Email(this.Email)
            .build();
    }
    
}


