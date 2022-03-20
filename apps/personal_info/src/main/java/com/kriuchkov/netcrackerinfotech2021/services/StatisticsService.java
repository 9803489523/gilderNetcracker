package com.kriuchkov.netcrackerinfotech2021.services;

import com.kriuchkov.netcrackerinfotech2021.entities.StatisticsEntity;
import com.kriuchkov.netcrackerinfotech2021.repositories.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

    public StatisticsEntity createStatistics(@RequestBody StatisticsEntity statistics) {
        return statisticsRepository.save(statistics);
    }

    public boolean updateStatistics(StatisticsEntity statistics, long id) {
        if (statisticsRepository.existsById(id)){
            statistics.setId(id);
            statisticsRepository.save(statistics);
            return true;
        }
        return false;
    }

    public boolean deleteStatistics(long id) {
        if (statisticsRepository.existsById(id)){
            statisticsRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public StatisticsEntity findById(Integer id) {
        return statisticsRepository.findById(id);
    }
}
