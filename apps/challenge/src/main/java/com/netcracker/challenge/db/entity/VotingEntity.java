package com.netcracker.challenge.db.entity;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Table(schema = "challenge", name = "voting")
@Entity(name = "voting")
public class VotingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToOne
    @JoinColumn(
            name = "challenge_id",
            referencedColumnName = "id",
            updatable = false
    )
    private ChallengeRecordEntity challengeRecord;

    @Column(name = "start_datetime")
    private Instant startDatetime;

    @Column(name = "end_datetime")
    private Instant endDatetime;

    @OneToMany
    @JoinColumn(
            name = "voting_id",
            referencedColumnName = "id",
            updatable = false
    )
    private List<VoteEntity> votes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ChallengeRecordEntity getChallengeRecord() {
        return challengeRecord;
    }

    public void setChallengeRecord(ChallengeRecordEntity challengeRecord) {
        this.challengeRecord = challengeRecord;
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

    public List<VoteEntity> getVotes() {
        return votes;
    }

    public void setVotes(List<VoteEntity> votes) {
        this.votes = votes;
    }

}
