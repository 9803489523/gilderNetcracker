package com.spaskin.news.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Alexanrd Spaskin
 */
@Entity
@Table(name = "comment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    @Column(name = "id_comment", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComment;

    @Column(name = "text")
    private String text;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Column(name = "id_news")
    private Integer newsId;

    @Column(name = "id_user")
    private Long idUser;

}
