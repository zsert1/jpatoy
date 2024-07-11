package com.soccerplay.evaluation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soccerplay.evaluation.entity.GameRecord;

public interface GameRecordRepository extends JpaRepository<GameRecord, Long> {
}