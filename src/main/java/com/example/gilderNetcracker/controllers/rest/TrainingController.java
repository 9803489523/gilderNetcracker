package com.example.gilderNetcracker.controllers.rest;

import com.example.gilderNetcracker.model.Training;
import com.example.gilderNetcracker.services.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/training")
public class TrainingController {

    private final TrainingService trainingService;

    @Autowired
    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @PostMapping()
    public ResponseEntity<Training> create(@RequestBody Training training){
        if(trainingService.create(training))
            return new ResponseEntity<>(HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<List<Training>> read(){
        if(trainingService.read().isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
