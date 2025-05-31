package com.suman.sample_java.application.user;

import java.util.UUID;

import com.suman.sample_java.application.user.dto.*;
import com.suman.sample_java.common.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.suman.sample_java.domain.entity.User;
import com.suman.sample_java.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    public CreateUserResponseDto createUser(CreateUserRequestDto dto){
        try{
        User user = dto.MapToUserEntity();
        User createdUser = userRepository.createUser(user);
        return mapToResponseEntity(createdUser);
        }catch(Exception e){
            System.err.println(e);
            throw e;
        }
    }

    private CreateUserResponseDto mapToResponseEntity(User user){
        return CreateUserResponseDto.builder()
        .Id(user.getId())
        .FirstName(user.getFirstName())
        .Lastname(user.getLastName())
        .Email(user.getEmail())
        .Phone(user.getPhone())
        .build();
    }

    public GetUserResponseDto getUserById(UUID id){
        User user = userRepository.getById(id);
        if (user==null){
            throw new ResourceNotFoundException("User does not exists");
        }

        return GetUserResponseDto.builder()
        .Id(id)
        .FirstName(user.getFirstName())
        .Lastname(user.getLastName())
        .Email(user.getEmail())
        .Phone(user.getPhone())
        .build();
    }

    public UpdateUserResponseDto updateUserById(UUID id, UpdateUserRequestDto dto){
        User user = userRepository.getById(id);
        if (user == null) {
            throw new ResourceNotFoundException("User does not exist");
        }

        // Update fields
        user.setId(id);
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastname());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());

        // Save updated user
        User updatedUser = userRepository.updateById(user);

        return UpdateUserResponseDto.builder()
                .id(id)
                .FirstName(user.getFirstName())
                .LastName(user.getLastName())
                .Email(user.getEmail())
                .Phone(user.getPhone())
                .build();
    }

}
