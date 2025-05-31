package com.suman.sample_java.application.user;

import java.util.UUID;

import com.suman.sample_java.application.user.dto.CreateUserRequestDto;
import com.suman.sample_java.application.user.dto.CreateUserResponseDto;
import com.suman.sample_java.application.user.dto.GetUserResponseDto;

public interface UserService {
    CreateUserResponseDto createUser(CreateUserRequestDto dto);
    GetUserResponseDto getUserById(UUID id);
}
