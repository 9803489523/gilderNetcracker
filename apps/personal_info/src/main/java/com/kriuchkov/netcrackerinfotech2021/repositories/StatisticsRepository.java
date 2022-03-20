package com.kriuchkov.netcrackerinfotech2021.repositories;

import com.kriuchkov.netcrackerinfotech2021.entities.StatisticsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface StatisticsRepository extends CrudRepository<StatisticsEntity, Long> {
    StatisticsEntity findById(Integer id);
    Set<StatisticsEntity> findAll();
}
