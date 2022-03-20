package com.netcracker.challenge.db.entity;

import javax.persistence.*;
import java.time.Instant;

@Table(schema = "challenge", name = "challenge_record")
@Entity(name = "challenge_record")
public class ChallengeRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "text_of_challenge")
    private String textOfChallenge;

    @Column(name = "amount_of_points")
    private Integer amountOfPoints;

    @Column(name = "attacker_id")
    private Integer attackerId;

    @Column(name = "catcher_id")
    private Integer catcherId;

    @Column(name = "deadline")
    private Instant deadline;

    @Column(name = "is_completed")
    private Boolean isCompleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

}
