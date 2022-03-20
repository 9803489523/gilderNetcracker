package com.example.gilderNetcracker.controllers.rest;

import com.example.gilderNetcracker.model.TrainingSet;
import com.example.gilderNetcracker.services.TSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainingSet")
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

    @GetMapping
    public ResponseEntity<List<TrainingSet>> read(){
        if(tsService.read().isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(tsService.read(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrainingSet> update(@PathVariable Integer id,@RequestBody TrainingSet trainingSet){
        if(tsService.update(id,trainingSet))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TrainingSet> delete(@PathVariable Integer id){
        if(tsService.delete(id))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
