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
@Table(name = "exercises")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "exercise_id")
    private int id;

    @Column(name = "exercise_name",nullable = false,unique = true)
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "exercise",cascade = CascadeType.ALL)
    private List<TrainingSet> trainingSets;
}
