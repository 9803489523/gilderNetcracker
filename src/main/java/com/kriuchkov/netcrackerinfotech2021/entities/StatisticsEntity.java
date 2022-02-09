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
@Table(name = "statistics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StatisticsEntity extends DefaultEntity<Long> {

    @Column(name = "user", nullable = false)
    private Integer user;

    @Column(name = "hours")
    private Integer hours;

    @Column(name = "count_of_exercises_performed")
    private Integer count_of_exercises_performed;

    @Column(name = "day")
    private String day;
}