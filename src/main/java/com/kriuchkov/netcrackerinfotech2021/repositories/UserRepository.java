package com.kriuchkov.netcrackerinfotech2021.repositories;

import com.kriuchkov.netcrackerinfotech2021.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findById(String id);
    Set<UserEntity> findAll();
}
