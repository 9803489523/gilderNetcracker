package com.kriuchkov.netcrackerinfotech2021.services;

import com.kriuchkov.netcrackerinfotech2021.entities.UserEntity;
import com.kriuchkov.netcrackerinfotech2021.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

    public UserEntity createUser(@RequestBody UserEntity user) {
        return userRepository.save(user);
    }

    public boolean updateUser(UserEntity user, long id) {
        if (userRepository.existsById(id)){
            user.setId(id);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public boolean deleteUser(long id) {
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }


    public UserEntity findByFullname(String fullname) {
        return userRepository.findByFullname(fullname);
    }
}
