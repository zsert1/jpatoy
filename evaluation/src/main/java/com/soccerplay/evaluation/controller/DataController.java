package com.soccerplay.evaluation.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soccerplay.evaluation.entity.GameRecord;
import com.soccerplay.evaluation.entity.Player;
import com.soccerplay.evaluation.service.DataScrapingService;

import lombok.RequiredArgsConstructor;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/data")
public class DataController {

    private final DataScrapingService dataScrapingService;

    @PostMapping("/scrape")
    public String scrapeAndSaveData(@RequestBody List<Player> players, @RequestBody List<GameRecord> gameRecords) {
        dataScrapingService.scrapeAndSaveData(players, gameRecords);
        return "Data scraped and saved successfully!";
    }
}