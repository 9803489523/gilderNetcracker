package com.example.gilderNetcracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "event_set")
public class EventSet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "es_id")
    private int id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "events",
            foreignKey = @ForeignKey(name = "fk_event_id")
    )
    private List<Event> events;

    @OneToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(
            name = "trainingSets",
            foreignKey = @ForeignKey(name = "fk_training_set_id")
    )
    private List<TrainingSet> trainingSets;
}
