package com.suman.sample_java.application.user.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class UpdateUserResponseDto {
private UUID id;
@JsonAlias("first_name")
private String FirstName;
@JsonAlias("last_name")
private String LastName;
@JsonAlias("email")
private String Email;
@JsonAlias("phone")
private String Phone;

}
