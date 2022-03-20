package com.netcracker.challenge.service.logic.impl;

import com.netcracker.challenge.db.entity.VotingEntity;
import com.netcracker.challenge.db.repository.VoteRepository;
import com.netcracker.challenge.db.repository.VotingRepository;
import com.netcracker.challenge.service.logic.VotingService;
import com.netcracker.challenge.service.mapper.VoteMapper;
import com.netcracker.challenge.service.mapper.VotingMapper;
import com.netcracker.challenge.service.model.VoteDto;
import com.netcracker.challenge.service.model.VotingCreateDto;
import com.netcracker.challenge.service.model.VotingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotingServiceImpl implements VotingService {

    private final VoteRepository voteRepository;
    private final VoteMapper voteMapper;
    private final VotingRepository repository;
    private final VotingMapper mapper;

    @Autowired
    public VotingServiceImpl(VoteRepository voteRepository,
                             VoteMapper voteMapper,
                             VotingRepository repository,
                             VotingMapper mapper) {
        this.voteRepository = voteRepository;
        this.voteMapper = voteMapper;
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public VotingDto startVoting(VotingCreateDto dto) {
        return mapper.fromEntity(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public void editVoting(VotingDto dto, int votingId) {
        VotingEntity entity = repository.findById(votingId).orElseThrow();
        mapper.merge(dto, entity);
        repository.save(entity);
    }

    @Override
    public void deleteVotingById(int votingId) {
        repository.deleteById(votingId);
    }

    @Override
    public VotingDto getVotingById(int votingId) {
        return mapper.fromEntity(repository.findById(votingId).orElseThrow());
    }

    @Override
    public void vote(VoteDto dto) {
        voteRepository.save(voteMapper.toEntity(dto));
    }

}
