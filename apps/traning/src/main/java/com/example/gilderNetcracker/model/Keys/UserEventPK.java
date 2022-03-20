package com.example.gilderNetcracker.model.Keys;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@Getter
@Setter
public class UserEventPK implements Serializable {

    @Column(name = "user_id")
    private int userId;

    @Column(name = "event_id")
    private int eventId;
}
