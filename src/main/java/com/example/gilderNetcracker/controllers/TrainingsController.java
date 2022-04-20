package com.example.gilderNetcracker.controllers;

import com.example.gilderNetcracker.model.Training;
import com.example.gilderNetcracker.services.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v3/trainings")
public class TrainingsController {

    private final TrainingService trainingService;

    @Autowired
    public TrainingsController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @PostMapping()
    public ResponseEntity<Training> create(@RequestBody Training training){
        if(trainingService.create(training))
            return new ResponseEntity<>(HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Training> readById(
            @PathVariable Integer id
    ){
        if(!trainingService.existById(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(trainingService.getById(id),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Training>> read(){
        return new ResponseEntity<>(trainingService.read(),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Training> delete(@PathVariable Integer id){
        if(trainingService.delete(id))
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Training> update(@PathVariable @Validated Integer id, @RequestBody Training training){
        if(trainingService.update(id,training))
            return new ResponseEntity<>(HttpStatus.UPGRADE_REQUIRED);
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
