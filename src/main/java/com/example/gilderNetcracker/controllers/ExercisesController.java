package com.example.gilderNetcracker.controllers;

import com.example.gilderNetcracker.model.Exercise;
import com.example.gilderNetcracker.services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v3/exercises")
public class ExercisesController {

    private final ExerciseService exerciseService;

    @Autowired
    public ExercisesController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @PostMapping()
    public ResponseEntity<Exercise> create(@RequestBody Exercise exercise){
        if(exerciseService.create(exercise))
            return new ResponseEntity<>(HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exercise> readById(
            @PathVariable Integer id
    ){
        if(!exerciseService.existById(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(exerciseService.getById(id),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Exercise>> read(){
        return new ResponseEntity<>(exerciseService.read(),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Exercise> delete(@PathVariable Integer id){
        if(exerciseService.delete(id))
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exercise> update(@PathVariable @Validated Integer id, @RequestBody Exercise exercise){
        if(exerciseService.update(id,exercise))
            return new ResponseEntity<>(HttpStatus.OK);
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
