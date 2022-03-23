package com.netcracker.challenge.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;

public class ChallengeRecordCreateDto {

    @JsonProperty("text_of_challenge")
    private String textOfChallenge;

    @JsonProperty("amount_of_points")
    private Integer amountOfPoints;

    @JsonProperty("attacker_id")
    private Integer attackerId;

    @JsonProperty("catcher_id")
    private Integer catcherId;

    private Instant deadline;

    public String getTextOfChallenge() {
        return textOfChallenge;
    }

    public void setTextOfChallenge(String textOfChallenge) {
        this.textOfChallenge = textOfChallenge;
    }

    public Integer getAmountOfPoints() {
        return amountOfPoints;
    }

    public void setAmountOfPoints(Integer amountOfPoints) {
        this.amountOfPoints = amountOfPoints;
    }

    public Integer getAttackerId() {
        return attackerId;
    }

    public void setAttackerId(Integer attackerId) {
        this.attackerId = attackerId;
    }

    public Integer getCatcherId() {
        return catcherId;
    }

    public void setCatcherId(Integer catcherId) {
        this.catcherId = catcherId;
    }

    public Instant getDeadline() {
        return deadline;
    }

    public void setDeadline(Instant deadline) {
        this.deadline = deadline;
    }

}
