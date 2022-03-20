package com.netcracker.challenge.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public class VotingDto {

    @JsonProperty("challenge_id")
    private Integer challengeId;

    @JsonProperty("start_datetime")
    private Instant startDatetime;

    @JsonProperty("end_datetime")
    private Instant endDatetime;

    public Integer getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(Integer challengeId) {
        this.challengeId = challengeId;
    }

    public Instant getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(Instant startDatetime) {
        this.startDatetime = startDatetime;
    }

    public Instant getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(Instant endDatetime) {
        this.endDatetime = endDatetime;
    }

}
