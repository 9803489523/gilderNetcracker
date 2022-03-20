package com.kriuchkov.netcrackerinfotech2021.services;

import com.kriuchkov.netcrackerinfotech2021.entities.AchievementsEntity;
import com.kriuchkov.netcrackerinfotech2021.repositories.AchievementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AchievementsService {
    private final AchievementsRepository achievementsRepository;

    @Autowired
    AchievementsService(AchievementsRepository achievementsRepository) {
        this.achievementsRepository = achievementsRepository;
    }

    public Set<AchievementsEntity> findAll() {
        return achievementsRepository.findAll();
    }

    public AchievementsEntity findById(Integer id) {
        return achievementsRepository.findById(id);
    }
}
