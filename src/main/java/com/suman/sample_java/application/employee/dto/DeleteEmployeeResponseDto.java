package com.suman.sample_java.application.employee.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteEmployeeResponseDto {
    @JsonAlias("message")
    private String message;

}
