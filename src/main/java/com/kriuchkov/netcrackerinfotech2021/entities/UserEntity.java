package com.kriuchkov.netcrackerinfotech2021.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_entity")
@Getter
@Setter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "email")
    private String email;

    @Column(name = "email_constraint")
    private String email_constraint;

    @Column(name = "email_verified")
    private Boolean email_verified;

    @Column(name = "enabled")
    private Boolean enabled;

    @Column(name = "federation_link")
    private String federation_link;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "realm_id")
    private String realm_id;

    @Column(name = "username")
    private String username;

    @Column(name = "created_timestamp")
    private String created_timestamp;

    public void setId(Long id) {
        this.id = String.valueOf(id);
    }

    public String getId() {
        return id;
    }
}

