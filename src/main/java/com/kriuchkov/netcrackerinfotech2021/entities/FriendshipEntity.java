package com.kriuchkov.netcrackerinfotech2021.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "friendship")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FriendshipEntity extends DefaultEntity<Long> {

    @ManyToOne()
    @JoinColumn(name = "sender", foreignKey = @ForeignKey(name = "friendship_users_id_fk"))
    private UserEntity sender;

    @ManyToOne()
    @JoinColumn(name = "recipient", foreignKey = @ForeignKey(name = "friendship_users_id_fk_2"))
    private UserEntity recipient;

    @Column(name = "status")
    private String status;
}
