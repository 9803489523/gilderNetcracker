package com.kriuchkov.netcrackerinfotech2021.controllers;

import com.kriuchkov.netcrackerinfotech2021.entities.UserEntity;
import com.kriuchkov.netcrackerinfotech2021.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    UserController(
            UserService userService
    ) {
        this.userService = userService;
    }

    @GetMapping
    public Set<UserEntity> findAll() {
        return userService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserEntity user){
        userService.createUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") long id, @RequestBody UserEntity user){
        final boolean update = userService.updateUser(user, id);

        return update
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id){
        final boolean deleted = userService.deleteUser(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }


    @GetMapping("/strings")
    public Set<String> findAllString() {
        return userService.findAll().stream().map(UserEntity::toString).collect(Collectors.toSet());
    }
}

