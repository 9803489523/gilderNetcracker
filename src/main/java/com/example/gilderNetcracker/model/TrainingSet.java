package com.example.gilderNetcracker.model;

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
@Table(name = "training_set")
public class TrainingSet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ts_id")
    private int id;

    @Column(name = "number_of_exercise",nullable = false)
    private int numberOfExercise;

}
