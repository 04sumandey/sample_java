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
    private String FirstName;
    @JsonAlias("last_name")
    private String LastName;
    @JsonAlias("phone_number")
    private String Phone;
    @JsonAlias("email_address")
    private String Email;
}
