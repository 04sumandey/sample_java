package com.suman.sample_java.application.user;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.suman.sample_java.application.user.dto.CreateUserRequestDto;
import com.suman.sample_java.application.user.dto.CreateUserResponseDto;
import com.suman.sample_java.application.user.dto.GetUserResponseDto;
import com.suman.sample_java.common.ResponseUtil.Util;
import com.suman.sample_java.common.ResponseUtil.dto.Response;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final Util util;

    @PostMapping("/user")
    public ResponseEntity<Response<CreateUserResponseDto>> createUser(@RequestBody CreateUserRequestDto dto){
        try {
            CreateUserResponseDto respDto = userService.createUser(dto);
            return util.SuccessBuilder(respDto).toEntity();
        } catch (Exception e) {
            return util.<CreateUserResponseDto>FailureBuilder(e).toEntity();
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Response<GetUserResponseDto>> getUser(@PathVariable UUID id) {
        try {
            GetUserResponseDto respDto = userService.getUserById(id);
            return util.SuccessBuilder(respDto).toEntity();
        } catch (Exception e) {
            return util.<GetUserResponseDto>FailureBuilder(e).toEntity();
        }
    }
}

