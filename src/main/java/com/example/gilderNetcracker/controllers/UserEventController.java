package com.example.gilderNetcracker.controllers;

import com.example.gilderNetcracker.model.Keys.UserEventPK;
import com.example.gilderNetcracker.model.UserEvent;
import com.example.gilderNetcracker.repos.UserEventRepo;
import com.example.gilderNetcracker.services.UserEventService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userEvent")
public class UserEventController {

    private final UserEventService userEventService;

    @Autowired
    public UserEventController(UserEventService userEventService) {
        this.userEventService = userEventService;
    }

    @PostMapping
    public ResponseEntity<UserEvent> create(@RequestBody UserEvent userEvent){
        if(userEventService.create(userEvent))
            return new ResponseEntity<>(HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<List<UserEvent>> read (){
        return new ResponseEntity<>(userEventService.read(),HttpStatus.OK);
    }

    @PutMapping("/{userId}/{eventId}")
    public ResponseEntity<UserEvent> update(
            @PathVariable(name = "userId") Integer userId,
            @PathVariable(name = "eventId")  Integer eventId,
            @RequestBody UserEvent userEvent
    ){
        UserEventPK id=new UserEventPK();
        id.setUserId(userId);
        id.setEventId(eventId);
        if(userEventService.update(id,userEvent))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{userId}/{eventId}")
    public ResponseEntity<UserEvent> delete(
            @PathVariable("userId") Integer userId,
            @PathVariable("eventId")  Integer eventId
    ){
        UserEventPK id=new UserEventPK();
        id.setUserId(userId);
        id.setEventId(eventId);
        if(userEventService.delete(id))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);


    }
}
