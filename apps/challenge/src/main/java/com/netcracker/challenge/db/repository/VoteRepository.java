package com.netcracker.challenge.db.repository;

import com.netcracker.challenge.db.entity.VoteEntity;
import com.netcracker.challenge.db.entity.VotingUserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends CrudRepository<VoteEntity, VotingUserId>, JpaRepository<VoteEntity, VotingUserId>, JpaSpecificationExecutor<VoteEntity> {
}
