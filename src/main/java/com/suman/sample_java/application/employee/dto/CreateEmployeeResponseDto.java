package com.suman.sample_java.application.employee.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CreateEmployeeResponseDto {
    @JsonAlias("id")
    private UUID Id;
    @JsonAlias("first_name")
    private String FirstName;
    @JsonAlias("last_name")
    private String Lastname;
    @JsonAlias("email")
    private String Email;
    @JsonAlias("phone")
    private String Phone;
}
