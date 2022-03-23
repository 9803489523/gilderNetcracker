package com.example.gilderNetcracker.controllers.rest;

import com.example.gilderNetcracker.model.Event;
import com.example.gilderNetcracker.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<List<Event>> read(){
        if(eventService.read().isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(eventService.read(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Event> create(@RequestBody Event event){
        if(eventService.create(event))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Event> delete(@PathVariable Integer id){
        if(eventService.delete(id))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> update(@PathVariable Integer id, @RequestBody Event event){
        if(eventService.update(id,event))
            return new ResponseEntity<>(event,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
