package com.kriuchkov.netcrackerinfotech2021.controllers;

import com.kriuchkov.netcrackerinfotech2021.entities.UserEntity;
import com.kriuchkov.netcrackerinfotech2021.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/strings")
    public Set<String> findAllString() {
        return userService.findAll().stream().map(UserEntity::toString).collect(Collectors.toSet());
    }
}

