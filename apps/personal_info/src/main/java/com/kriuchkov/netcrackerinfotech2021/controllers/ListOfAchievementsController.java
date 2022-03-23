package com.kriuchkov.netcrackerinfotech2021.controllers;

import com.kriuchkov.netcrackerinfotech2021.entities.ListOfAchievementsEntity;
import com.kriuchkov.netcrackerinfotech2021.services.ListOfAchievementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users/list_of_achievements")
public class ListOfAchievementsController {
    private final ListOfAchievementsService listOfAchievementsService;

    @Autowired
    ListOfAchievementsController(
            ListOfAchievementsService listOfAchievementsService
    ) {
        this.listOfAchievementsService = listOfAchievementsService;
    }

    @GetMapping
    public Set<ListOfAchievementsEntity> findAll() {
        return listOfAchievementsService.findAll();
    }

    @GetMapping("/strings")
    public Set<String> findAllString() {
        return listOfAchievementsService.findAll().stream().map(ListOfAchievementsEntity::toString).collect(Collectors.toSet());
    }
}
