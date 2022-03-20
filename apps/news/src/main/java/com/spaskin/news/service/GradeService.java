package com.spaskin.news.service;

import com.spaskin.news.entity.Grade;
import com.spaskin.news.primarykeys.GradeKey;
import com.spaskin.news.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Alexanrd Spaskin
 */
@Service
public class GradeService {
    @Autowired
    private GradeRepository gradeRepository;

    public void create(Grade grade) {
        gradeRepository.save(grade);
    }

    public List<Grade> readAll() {
        return gradeRepository.findAll();
    }

    public Grade read(GradeKey id) {
        return gradeRepository.getOne(id);
    }

    public boolean update(Grade grade, GradeKey id) {
        if (gradeRepository.existsById(id)){
            grade.setIdNews(id.getIdNews());
            grade.setIdUser(id.getIdUser());
            gradeRepository.save(grade);
            return true;
        }
        return false;
    }

    public boolean delete(GradeKey id) {
        if (gradeRepository.existsById(id)){
            gradeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
