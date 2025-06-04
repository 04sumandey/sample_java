package com.suman.sample_java.application.employee.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CreateEmployeeResponseDto {
    @JsonAlias("id")
    private UUID id;
    @JsonAlias("first_name")
    private String firstName;
    @JsonAlias("last_name")
    private String lastName;
    @JsonAlias("email")
    private String email;
    @JsonAlias("phone")
    private String phone;
}
