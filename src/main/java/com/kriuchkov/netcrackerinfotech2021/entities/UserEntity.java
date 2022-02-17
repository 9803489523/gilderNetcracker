package com.kriuchkov.netcrackerinfotech2021.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends DefaultEntity<Long> {

    @Column(name = "fullname", nullable = false)
    private String fullname;

    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
    private Integer age;

    @Column(name = "height")
    private Double height;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "training_experience")
    private Integer training_experience;

    @Column(name = "rating")
    private Integer rating;
}

