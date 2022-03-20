package com.kriuchkov.netcrackerinfotech2021.services;

import com.kriuchkov.netcrackerinfotech2021.entities.ListOfAchievementsEntity;
import com.kriuchkov.netcrackerinfotech2021.repositories.ListOfAchievementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ListOfAchievementsService {
    private final ListOfAchievementsRepository listOfAchievementsRepository;

    @Autowired
    ListOfAchievementsService(ListOfAchievementsRepository listOfAchievementsRepository) {
        this.listOfAchievementsRepository = listOfAchievementsRepository;
    }

    public Set<ListOfAchievementsEntity> findAll() {
        return listOfAchievementsRepository.findAll();
    }

    public ListOfAchievementsEntity findById(Integer id) {
        return listOfAchievementsRepository.findById(id);
    }
}
