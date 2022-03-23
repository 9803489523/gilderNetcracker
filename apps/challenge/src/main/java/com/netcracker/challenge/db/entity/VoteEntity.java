package com.netcracker.challenge.db.entity;

import javax.persistence.*;

@Table(schema = "challenge", name = "vote")
@Entity(name = "vote")
public class VoteEntity {

    @EmbeddedId
    private VotingUserId id;

    public VotingUserId getId() {
        return id;
    }

    public void setId(VotingUserId id) {
        this.id = id;
    }

}
