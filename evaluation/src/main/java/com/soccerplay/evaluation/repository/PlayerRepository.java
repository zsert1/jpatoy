package com.soccerplay.evaluation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soccerplay.evaluation.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
