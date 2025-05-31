package com.suman.sample_java.application.user.dto;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetUserResponseDto {
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
