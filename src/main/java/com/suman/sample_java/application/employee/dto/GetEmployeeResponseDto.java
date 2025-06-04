package com.suman.sample_java.application.employee.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetEmployeeResponseDto {
    private UUID id;    
    @JsonAlias("first_name")
    private String firstName;
    @JsonAlias("last_name")
    private String lastName;
    @JsonAlias("phone_number")
    private String phone;
    @JsonAlias("email_address")
    private String email;
}
