package com.kriuchkov.netcrackerinfotech2021.controllers;

import com.kriuchkov.netcrackerinfotech2021.entities.StatisticsEntity;
import com.kriuchkov.netcrackerinfotech2021.services.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users/statistics")
public class StatisticsController {
    private final StatisticsService statisticsService;

    @Autowired
    StatisticsController(
            StatisticsService statisticsService
    ) {
        this.statisticsService = statisticsService;
    }

    @GetMapping
    public Set<StatisticsEntity> findAll() {
        return statisticsService.findAll();
    }

    @GetMapping("/strings")
    public Set<String> findAllString() {
        return statisticsService.findAll().stream().map(StatisticsEntity::toString).collect(Collectors.toSet());
    }
}
