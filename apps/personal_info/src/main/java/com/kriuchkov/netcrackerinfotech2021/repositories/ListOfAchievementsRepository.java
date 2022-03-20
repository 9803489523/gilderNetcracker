package com.kriuchkov.netcrackerinfotech2021.repositories;

import com.kriuchkov.netcrackerinfotech2021.entities.ListOfAchievementsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ListOfAchievementsRepository extends CrudRepository<ListOfAchievementsEntity, Long> {
    ListOfAchievementsEntity findById(Integer id);
    Set<ListOfAchievementsEntity> findAll();
}
