package com.kriuchkov.netcrackerinfotech2021.services;

import com.kriuchkov.netcrackerinfotech2021.entities.UserEntity;
import com.kriuchkov.netcrackerinfotech2021.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Set<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public UserEntity findByFullname(String fullname) {
        return userRepository.findByFullname(fullname);
    }
}
