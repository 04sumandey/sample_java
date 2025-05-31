package com.suman.sample_java.application.user.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.suman.sample_java.domain.entity.User;

import lombok.Data;

@Data
public class UpdateUserRequestDto {
    @JsonAlias("first_name")
    private String FirstName;
    @JsonAlias("last_name")
    private String Lastname;
    @JsonAlias("email")
    private String Email;
    @JsonAlias("phone")
    private String Phone;

    public User MapToUserEntity(){
        return User.builder()
                .FirstName(this.FirstName)
                .LastName(this.Lastname)
                .Email(this.Email)
                .Phone(this.Phone)
                .build();
    }
}
