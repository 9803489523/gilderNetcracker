package com.spaskin.news.entity;

import com.spaskin.news.primarykeys.GradeKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Alexanrd Spaskin
 */
@Entity
@Table(name = "grade")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(GradeKey.class)

public class Grade {

    @Id
    @Column(name = "id_news")
    private Integer idNews;

    @Id
    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "grade")
    private boolean grade;

}
