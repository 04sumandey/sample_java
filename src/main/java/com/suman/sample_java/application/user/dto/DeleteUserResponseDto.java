package com.suman.sample_java.application.user.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteUserResponseDto {
    @JsonAlias("message")
    private String message;
}
