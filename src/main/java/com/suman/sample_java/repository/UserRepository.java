package com.suman.sample_java.repository;

import java.util.UUID;

import com.suman.sample_java.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UUID> {
}
