package com.kriuchkov.netcrackerinfotech2021.services;

import com.kriuchkov.netcrackerinfotech2021.entities.FriendshipEntity;
import com.kriuchkov.netcrackerinfotech2021.repositories.FriendshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FriendshipService {
    private final FriendshipRepository friendshipRepository;

    @Autowired
    FriendshipService(FriendshipRepository friendshipRepository) {
        this.friendshipRepository = friendshipRepository;
    }

    public Set<FriendshipEntity> findAll() {
        return friendshipRepository.findAll();
    }

    public FriendshipEntity findById(Integer id) {
        return friendshipRepository.findById(id);
    }
}
