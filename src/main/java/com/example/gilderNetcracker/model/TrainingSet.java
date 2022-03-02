package com.example.gilderNetcracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
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

    @OneToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "trainings",foreignKey = @ForeignKey(name = "fk_training_id"))
    private List<Training> trainings;

    @OneToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "exercises",foreignKey = @ForeignKey(name = "fk_exercise_id"))
    private List<Exercise> exercises;

    @Column(name = "number_of_exercise",nullable = false)
    private int numberOfExercise;
}
