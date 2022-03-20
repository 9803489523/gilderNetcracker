package com.netcracker.challenge.service.logic;

import com.netcracker.challenge.service.model.VoteDto;
import com.netcracker.challenge.service.model.VotingCreateDto;
import com.netcracker.challenge.service.model.VotingDto;

public interface VotingService {

    VotingDto startVoting(VotingCreateDto dto);

    void editVoting(VotingDto dto, int votingId);

    void deleteVotingById(int votingId);

    VotingDto getVotingById(int votingId);

    void vote(VoteDto dto);

}
