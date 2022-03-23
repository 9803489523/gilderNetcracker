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
@Table(name = "training_set")
public class TrainingSet{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ts_id")
    private int id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "training_id",referencedColumnName = "training_id")
    private Training training;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "exercise_id",referencedColumnName = "exercise_id")
    private Exercise exercise;

    @Column(name = "number_of_exercise",nullable = false)
    private int numberOfExercise;

    @ManyToMany(mappedBy = "trainingSets")
    private List<Event> events;
}
