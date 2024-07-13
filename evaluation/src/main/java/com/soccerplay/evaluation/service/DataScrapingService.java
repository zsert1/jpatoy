package com.soccerplay.evaluation.service;

import org.springframework.stereotype.Service;

import com.soccerplay.evaluation.entity.GameRecord;
import com.soccerplay.evaluation.entity.Player;
import com.soccerplay.evaluation.repository.GameRecordRepository;
import com.soccerplay.evaluation.repository.PlayerRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DataScrapingService {

    

  
    private final  GameRecordRepository gameRecordRepository;
    
    private final PlayerRepository playerRepository;

    public void scrapeAndSaveData(List<Player> players, List<GameRecord> gameRecords) {
        for (Player player : players) {
            Player existingPlayer = playerRepository.findByName(player.getName());
            if (existingPlayer == null) {
                playerRepository.save(player);
            }
        }

        for (GameRecord gameRecord : gameRecords) {
            gameRecordRepository.save(gameRecord);
        }
    }


}
