package com.kriuchkov.netcrackerinfotech2021.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "list_of_achievements")
@Getter
@Setter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
public class ListOfAchievementsEntity extends DefaultEntity<Long> {
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "icon")
    private String icon;
}
