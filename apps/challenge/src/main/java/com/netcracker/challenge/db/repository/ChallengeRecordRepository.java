package com.netcracker.challenge.db.repository;

import com.netcracker.challenge.db.entity.ChallengeRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengeRecordRepository extends CrudRepository<ChallengeRecordEntity, Integer>, JpaRepository<ChallengeRecordEntity, Integer>, JpaSpecificationExecutor<ChallengeRecordEntity> {
}
