package com.kriuchkov.netcrackerinfotech2021.repositories;

import com.kriuchkov.netcrackerinfotech2021.entities.FriendshipEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface FriendshipRepository extends CrudRepository<FriendshipEntity, Long> {
    FriendshipEntity findById(Integer id);
    Set<FriendshipEntity> findAll();
}
