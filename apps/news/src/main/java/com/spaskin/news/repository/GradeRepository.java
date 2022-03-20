package com.spaskin.news.repository;

import com.spaskin.news.entity.Grade;
import com.spaskin.news.primarykeys.GradeKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexanrd Spaskin
 */

public interface GradeRepository extends JpaRepository<Grade, GradeKey> {
    Optional<Grade> findById(GradeKey gradeKey);

    List<Grade> findAllById(Iterable<GradeKey> gradeKeys);
}
