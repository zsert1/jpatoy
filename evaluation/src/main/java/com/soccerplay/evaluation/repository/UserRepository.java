package com.soccerplay.evaluation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soccerplay.evaluation.entity.User;

import java.util.UUID;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, UUID>{
    public Optional<User> findByEmail(String email);

    public User findByUsername(String username);
}

