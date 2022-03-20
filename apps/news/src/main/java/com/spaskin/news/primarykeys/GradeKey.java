package com.spaskin.news.primarykeys;

import lombok.*;

import java.io.Serializable;

/**
 * @author Alexanrd Spaskin
 */
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString

public class GradeKey implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idNews;
    private Integer idUser;
}
