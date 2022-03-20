package com.kriuchkov.netcrackerinfotech2021.controllers;

import com.kriuchkov.netcrackerinfotech2021.entities.FriendshipEntity;
import com.kriuchkov.netcrackerinfotech2021.services.FriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users/friendship")
public class FriendshipController {
    private final FriendshipService friendshipService;

    @Autowired
    FriendshipController(
            FriendshipService friendshipService
    ) {
        this.friendshipService = friendshipService;
    }

    @GetMapping
    public Set<FriendshipEntity> findAll() {
        return friendshipService.findAll();
    }

    @GetMapping("/strings")
    public Set<String> findAllString() {
        return friendshipService.findAll().stream().map(FriendshipEntity::toString).collect(Collectors.toSet());
    }
}
