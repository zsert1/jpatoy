package com.soccerplay.evaluation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.soccerplay.evaluation.entity.GameRecord;
import com.soccerplay.evaluation.repository.GameRecordRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameRecordService {

  
    private final  GameRecordRepository gameRecordRepository;

    public List<GameRecord> getAllGameRecords() {
        return gameRecordRepository.findAll();
    }

    public GameRecord saveGameRecord(GameRecord gameRecord) {
        return gameRecordRepository.save(gameRecord);
    }

}
