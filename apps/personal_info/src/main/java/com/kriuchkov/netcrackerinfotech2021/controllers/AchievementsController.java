package com.kriuchkov.netcrackerinfotech2021.controllers;

import com.kriuchkov.netcrackerinfotech2021.entities.AchievementsEntity;
import com.kriuchkov.netcrackerinfotech2021.services.AchievementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users/achievements")
public class AchievementsController {
    private final AchievementsService achievementsService;

    @Autowired
    AchievementsController(
            AchievementsService achievementsService
    ) {
        this.achievementsService = achievementsService;
    }

    @GetMapping
    public Set<AchievementsEntity> findAll() {
        return achievementsService.findAll();
    }

    @GetMapping("/strings")
    public Set<String> findAllString() {
        return achievementsService.findAll().stream().map(AchievementsEntity::toString).collect(Collectors.toSet());
    }
}
