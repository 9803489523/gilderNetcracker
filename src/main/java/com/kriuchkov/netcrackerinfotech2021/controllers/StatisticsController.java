package com.kriuchkov.netcrackerinfotech2021.controllers;

import com.kriuchkov.netcrackerinfotech2021.entities.StatisticsEntity;
import com.kriuchkov.netcrackerinfotech2021.services.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<?> createStatistics(@RequestBody StatisticsEntity statistics){
        statisticsService.createStatistics(statistics);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") long id, @RequestBody StatisticsEntity statistics){
        final boolean update = statisticsService.updateStatistics(statistics, id);

        return update
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id){
        final boolean deleted = statisticsService.deleteStatistics(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping("/strings")
    public Set<String> findAllString() {
        return statisticsService.findAll().stream().map(StatisticsEntity::toString).collect(Collectors.toSet());
    }
}
