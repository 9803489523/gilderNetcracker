package com.netcracker.challenge.db.repository;

import com.netcracker.challenge.db.entity.VotingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotingRepository extends CrudRepository<VotingEntity, Integer>, JpaRepository<VotingEntity, Integer>, JpaSpecificationExecutor<VotingEntity> {
}
