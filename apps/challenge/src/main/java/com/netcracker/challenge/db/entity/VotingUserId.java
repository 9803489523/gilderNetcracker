package com.netcracker.challenge.db.entity;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class VotingUserId implements Serializable {

    @Column(name = "voting_id")
    private Integer votingId;

    @Column(name = "user_id")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VotingUserId that = (VotingUserId) o;
        return votingId.equals(that.votingId) && userId.equals(that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(votingId, userId);
    }

}
