package com.soccerplay.evaluation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.soccerplay.evaluation.entity.Player;
import com.soccerplay.evaluation.repository.PlayerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlayerService {
    
    private final PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }
}