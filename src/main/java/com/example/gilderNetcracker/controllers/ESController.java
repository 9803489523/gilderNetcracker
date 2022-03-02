package com.example.gilderNetcracker.controllers;

import com.example.gilderNetcracker.model.EventSet;
import com.example.gilderNetcracker.model.TrainingSet;
import com.example.gilderNetcracker.services.ESService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventSet")
public class ESController {
    private final ESService esService;

    @Autowired
    public ESController(ESService esService) {
        this.esService = esService;
    }

    @PostMapping
    public ResponseEntity<TrainingSet> create(@RequestBody EventSet eventSet){
        if(esService.create(eventSet))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<List<EventSet>> read(){
        if(esService.read().isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(esService.read(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrainingSet> update(@PathVariable Integer id,@RequestBody EventSet eventSet){
        if(esService.update(id,eventSet))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EventSet> delete(@PathVariable Integer id){
        if(esService.delete(id))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
