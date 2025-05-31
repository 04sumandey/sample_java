package com.suman.sample_java.repository;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.suman.sample_java.domain.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class UserRepositoryImpl implements UserRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public User createUser(User user) {
        entityManager.persist(user);
        return user;
    }

    public User getById(UUID id){
        return entityManager.find(User.class, id);
    }
}
