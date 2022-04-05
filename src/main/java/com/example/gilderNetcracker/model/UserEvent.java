package com.example.gilderNetcracker.model;

import com.example.gilderNetcracker.model.Keys.UserEventPK;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "user_event")
public class UserEvent {
    
    @EmbeddedId
    private UserEventPK id;
    
    //@Column(name = "user_id",insertable = false,updatable = false)
    //private int userId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "event_id",insertable = false,updatable = false,referencedColumnName = "event_id")
    private Event eventUser;


}
