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
@Table(name = "trainings")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "training_id")
    private int id;

    @Column(name = "training_info")
    private String info;

    @OneToMany(mappedBy = "training",cascade = CascadeType.ALL)
    private List<TrainingSet> trainingSets;
}
