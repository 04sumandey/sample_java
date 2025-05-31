package com.suman.sample_java.application.user;

import java.util.UUID;

import com.suman.sample_java.application.user.dto.*;

public interface UserService {
    CreateUserResponseDto createUser(CreateUserRequestDto dto);
    GetUserResponseDto getUserById(UUID id);
    UpdateUserResponseDto updateUserById(UUID id, UpdateUserRequestDto dto);
    DeleteUserResponseDto deleteUserById(UUID id);
}
