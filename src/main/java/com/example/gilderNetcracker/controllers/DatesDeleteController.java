package com.example.gilderNetcracker.controllers;

import com.example.gilderNetcracker.model.DateDelete;
import com.example.gilderNetcracker.services.DateDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v3/datesDelete")
public class DatesDeleteController {
    private final DateDeleteService dateDeleteService;

    @Autowired
    public DatesDeleteController(DateDeleteService dateDeleteService) {
        this.dateDeleteService = dateDeleteService;
    }

    @GetMapping
    public ResponseEntity<List<DateDelete>> read(){
        return new ResponseEntity<>(dateDeleteService.read(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DateDelete> readById(
            @PathVariable Integer id
    ){
        if(!dateDeleteService.existById(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(dateDeleteService.getById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DateDelete> create(@RequestBody DateDelete dateDelete){
        if(dateDeleteService.create(dateDelete))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DateDelete> delete(@PathVariable Integer id){
        if(dateDeleteService.delete(id))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DateDelete> update(@PathVariable Integer id, @RequestBody DateDelete dateDelete){
        if(dateDeleteService.update(id,dateDelete))
            return new ResponseEntity<>(dateDelete,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
