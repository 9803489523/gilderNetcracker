package com.example.gilderNetcracker.controllers;

import com.example.gilderNetcracker.model.Keys.TrainingSetPK;
import com.example.gilderNetcracker.model.TrainingSet;
import com.example.gilderNetcracker.services.TSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/trainingsSet")
public class TSController {

    private final TSService tsService;

    @Autowired
    public TSController(TSService tsService) {
        this.tsService = tsService;
    }

    @PostMapping
    public ResponseEntity<TrainingSet> create(@RequestBody TrainingSet trainingSet){
        if(tsService.create(trainingSet))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{trainingId}/{exerciseId}")
    public ResponseEntity<TrainingSet> readById(
            @PathVariable Integer trainingId,
            @PathVariable Integer exerciseId
    ){
        TrainingSetPK id=new TrainingSetPK();
        id.setTrainingId(trainingId);
        id.setExerciseId(exerciseId);
        if(!tsService.existById(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(tsService.getById(id),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TrainingSet>> read(){
        if(tsService.read().isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(tsService.read(),HttpStatus.OK);
    }

    @PutMapping("/{trainingId}/{exerciseId}")
    public ResponseEntity<TrainingSet> update(
            @PathVariable Integer trainingId,
            @PathVariable Integer exerciseId,
            @RequestBody TrainingSet trainingSet){
        TrainingSetPK id=new TrainingSetPK();
        id.setTrainingId(trainingId);
        id.setExerciseId(exerciseId);
        if(tsService.update(id,trainingSet))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{trainingId}/{exerciseId}")
    public ResponseEntity<TrainingSet> delete(
            @PathVariable Integer trainingId,
            @PathVariable Integer exerciseId){
        TrainingSetPK id=new TrainingSetPK();
        id.setTrainingId(trainingId);
        id.setExerciseId(exerciseId);
        if(tsService.delete(id))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
