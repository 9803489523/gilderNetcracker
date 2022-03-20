package com.netcracker.challenge.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VoteDto {

    @JsonProperty("voting_id")
    private Integer votingId;

    @JsonProperty("user_id")
    private Integer userId;

    public Integer getVotingId() {
        return votingId;
    }

    public void setVotingId(Integer votingId) {
        this.votingId = votingId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}
