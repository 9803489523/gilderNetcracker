package com.example.gilderNetcracker.model.Keys;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@Getter
@Setter
public class TrainingSetPK implements Serializable {

    @Column(name = "training_id")
    private int trainingId;

    @Column(name = "exercise_id")
    private int exerciseId;
}
