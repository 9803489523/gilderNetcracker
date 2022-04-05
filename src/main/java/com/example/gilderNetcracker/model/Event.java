package com.example.gilderNetcracker.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "event_id")
    private int id;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "event_date",nullable = false)
    private LocalDateTime eventDate;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "cycle_start")
    private LocalDate cycleStart;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "cycle_end")
    private LocalDate cycleEnd;

    @Column(name = "day_repeat")
    private String day;

    @ManyToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumns({
         @JoinColumn(name = "training_id",insertable = false,updatable = false),
         @JoinColumn(name = "exercise_id",insertable = false,updatable = false)
    })
    private List<TrainingSet> trainingSets;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "parent_event_id",referencedColumnName = "event_id")
    private Event event;

    @OneToMany(mappedBy = "event")
    private List<Event> events;

    @OneToMany(mappedBy = "eventUser")
    private List<UserEvent> userEvents;
}
