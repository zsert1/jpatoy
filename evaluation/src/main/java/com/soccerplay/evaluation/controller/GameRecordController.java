package com.soccerplay.evaluation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.soccerplay.evaluation.entity.GameRecord;
import com.soccerplay.evaluation.service.GameRecordService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/gamerecords")
@RequiredArgsConstructor
public class GameRecordController {
    final private GameRecordService gameRecordService;
     @GetMapping
    public List<GameRecord> getAllGameRecords() {
        return gameRecordService.getAllGameRecords();
    }

    @PostMapping
    public GameRecord addGameRecord(@RequestBody GameRecord gameRecord) {
        return gameRecordService.saveGameRecord(gameRecord);
    }

}
