package com.netcracker.challenge.service.logic.impl;

import com.netcracker.challenge.db.entity.ChallengeRecordEntity;
import com.netcracker.challenge.db.repository.ChallengeRecordRepository;
import com.netcracker.challenge.service.logic.ChallengeRecordService;
import com.netcracker.challenge.service.mapper.ChallengeRecordMapper;
import com.netcracker.challenge.service.model.ChallengeRecordCreateDto;
import com.netcracker.challenge.service.model.ChallengeRecordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChallengeRecordServiceImpl implements ChallengeRecordService {

    private final ChallengeRecordRepository repository;
    private final ChallengeRecordMapper mapper;

    @Autowired
    public ChallengeRecordServiceImpl(ChallengeRecordRepository repository,
                                      ChallengeRecordMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    //TODO: Ask about "is_completed"
    @Override
    public ChallengeRecordDto createChallenge(ChallengeRecordCreateDto dto) {
        ChallengeRecordEntity entity = mapper.toEntity(dto);
        entity.setCompleted(false);
        return mapper.fromEntity(repository.save(entity));
    }

    //TODO: Ask about "is_completed"
    @Override
    public void editChallenge(ChallengeRecordDto dto, int challengeId) {
        ChallengeRecordEntity entity = repository.findById(challengeId).orElseThrow();
        dto.setCompleted(false);
        entity.setCompleted(false);
        mapper.merge(dto, entity);
        repository.save(entity);
    }

    @Override
    public void deleteChallengeById(int challengeRecordId) {
        repository.deleteById(challengeRecordId);
    }

    @Override
    public ChallengeRecordDto getChallengeById(int challengeRecordId) {
        return mapper.fromEntity(repository.findById(challengeRecordId).orElseThrow());
    }

    @Override
    public void completeChallengeById(int challengeRecordId) {
        ChallengeRecordEntity entity = repository.findById(challengeRecordId).orElseThrow();
        entity.setCompleted(true);
        repository.save(entity);
    }

}
