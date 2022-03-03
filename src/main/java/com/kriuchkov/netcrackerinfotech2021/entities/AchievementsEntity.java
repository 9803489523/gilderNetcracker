package com.kriuchkov.netcrackerinfotech2021.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "achievements")
@Getter
@Setter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
public class AchievementsEntity extends DefaultEntity<Long> {

    @ManyToOne()
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "achievements_user_entity_id_fk"))
    private UserEntity user;

    @ManyToOne()
    @JoinColumn(name = "achievement_id", foreignKey = @ForeignKey(name = "achievements_achievements_list_id_fk"))
    private ListOfAchievementsEntity achievements;
}
