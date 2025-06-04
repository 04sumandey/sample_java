package com.suman.sample_java.application.employee.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.suman.sample_java.domain.entity.Employee;

import lombok.Data;

@Data
public class UpdateEmployeeRequestDto {
    @JsonAlias("first_name")
    private String firstName;
    @JsonAlias("last_name")
    private String lastName;
    @JsonAlias("email")
    private String email;
    @JsonAlias("phone")
    private String phone;
    public Employee MapToEmployeeEntity() {
        return Employee.builder()
            .FirstName(this.firstName)
            .LastName(this.lastName)
            .Phone(this.phone)
            .Email(this.email)
            .build();
    }
    
}


