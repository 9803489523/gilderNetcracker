package com.spaskin.news.controllers;

import com.spaskin.news.entity.Grade;
import com.spaskin.news.primarykeys.GradeKey;
import com.spaskin.news.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Alexanrd Spaskin
 */
@RestController
public class GradeController {
    private final GradeService gradeService;

    @Autowired
    public GradeController(GradeService gradeService){
        this.gradeService = gradeService;
    }

    @PostMapping(value = "/grade")
    public ResponseEntity<?> cread(@RequestBody Grade grade){
        gradeService.create(grade);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/grade")
    public ResponseEntity<List<Grade>> read(){
        final List<Grade> gradeList = gradeService.readAll();

        return gradeList != null && !gradeList.isEmpty()
                ? new ResponseEntity<>(gradeList, HttpStatus.OK)
                : new ResponseEntity<>(gradeList, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/grade/{idNews}/{idUser}")
    public ResponseEntity<Grade> read(@PathVariable(name = "idNews") Integer idNews, @PathVariable(name = "idUser") Integer idUser){
        final Grade grade = gradeService.read(new GradeKey(idNews, idUser));

        return grade != null
                ? new ResponseEntity<>(grade, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/grade/{idNews}/{idUser}")
    public ResponseEntity<?> update(@PathVariable(name = "idNews") Integer idNews, @PathVariable(name = "idUser") Integer idUser, @RequestBody Grade grade){
        final boolean update = gradeService.update(grade, new GradeKey(idNews, idUser));

        return update
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/grade/{idNews}/{idUser}")
    public ResponseEntity<?> delete(@PathVariable(name = "idNews") Integer idNews, @PathVariable(name = "idUser") Integer idUser){
        final boolean deleted = gradeService.delete(new GradeKey(idNews, idUser));

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
