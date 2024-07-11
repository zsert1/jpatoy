package com.soccerplay.evaluation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soccerplay.evaluation.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
