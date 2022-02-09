package com.kriuchkov.netcrackerinfotech2021.services;

import com.kriuchkov.netcrackerinfotech2021.entities.StatisticsEntity;
import com.kriuchkov.netcrackerinfotech2021.repositories.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class StatisticsService {
    private final StatisticsRepository statisticsRepository;

    @Autowired
    StatisticsService(StatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }

    public Set<StatisticsEntity> findAll() {
        return statisticsRepository.findAll();
    }

    public StatisticsEntity findById(Integer id) {
        return statisticsRepository.findById(id);
    }
}
