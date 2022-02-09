package com.kriuchkov.netcrackerinfotech2021.repositories;

import com.kriuchkov.netcrackerinfotech2021.entities.AchievementsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AchievementsRepository extends CrudRepository<AchievementsEntity, Long> {
    AchievementsEntity findById(Integer id);
    Set<AchievementsEntity> findAll();
}
