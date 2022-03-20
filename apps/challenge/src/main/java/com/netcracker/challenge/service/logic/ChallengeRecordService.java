package com.netcracker.challenge.service.logic;

import com.netcracker.challenge.service.model.ChallengeRecordCreateDto;
import com.netcracker.challenge.service.model.ChallengeRecordDto;

public interface ChallengeRecordService {

    ChallengeRecordDto createChallenge(ChallengeRecordCreateDto dto);

    void editChallenge(ChallengeRecordDto dto, int challengeId);

    void deleteChallengeById(int challengeRecordId);

    ChallengeRecordDto getChallengeById(int challengeRecordId);

    void completeChallengeById(int challengeRecordId);

}
