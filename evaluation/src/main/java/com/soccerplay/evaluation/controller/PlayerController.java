package com.soccerplay.evaluation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soccerplay.evaluation.entity.Player;
import com.soccerplay.evaluation.service.PlayerService;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/players")
@RequiredArgsConstructor
public class PlayerController {
   final private PlayerService playerService;

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @PostMapping
    public Player addPlayer(@RequestBody Player player) {
        return playerService.savePlayer(player);
    }

}
