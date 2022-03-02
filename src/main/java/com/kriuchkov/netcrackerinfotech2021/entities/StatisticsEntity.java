package com.kriuchkov.netcrackerinfotech2021.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "statistics")
@Getter
@Setter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
public class StatisticsEntity extends DefaultEntity<Long> {

    @ManyToOne()
    @JoinColumn(name = "user", foreignKey = @ForeignKey(name = "statistics_users_id_fk"))
    private UserEntity user;

    @Column(name = "hours")
    private Integer hours;

    @Column(name = "count_of_exercises_performed")
    private Integer count_of_exercises_performed;

    @Column(name = "day")
    private String day;
}