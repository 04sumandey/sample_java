package com.suman.sample_java.repository;

import java.util.UUID;

import com.suman.sample_java.domain.entity.User;

public interface UserRepository {
    User createUser(User user);
    User getById(UUID id);
    User updateById(User user);
}
