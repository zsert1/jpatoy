package com.soccerplay.evaluation.service;

import org.springframework.stereotype.Service;

import com.soccerplay.evaluation.entity.Player;
import com.soccerplay.evaluation.repository.PlayerRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DataScrapingService {

    

  
    
    private final PlayerRepository playerRepository;

    public void scrapeAndSaveData(List<Player> players) {
        System.out.println(players);
        for (Player player : players) {
               playerRepository.save(player);

          
        }
    }


}
