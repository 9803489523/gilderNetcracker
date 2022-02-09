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
@NoArgsConstructor
@AllArgsConstructor
public class AchievementsEntity extends DefaultEntity<Long> {

    @ManyToOne()
    @JoinColumn(name = "user", foreignKey = @ForeignKey(name = "achievements_users_id_fk"))
    private UserEntity user;

    @ManyToOne()
    @JoinColumn(name = "achievement", foreignKey = @ForeignKey(name = "achievements_list_of_achievements_id_fk"))
    private ListOfAchievementsEntity achievements;
}
