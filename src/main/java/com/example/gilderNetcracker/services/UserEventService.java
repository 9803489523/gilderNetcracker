package com.example.gilderNetcracker.services;

import com.example.gilderNetcracker.model.Keys.TrainingSetPK;
import com.example.gilderNetcracker.model.Keys.UserEventPK;
import com.example.gilderNetcracker.model.TrainingSet;
import com.example.gilderNetcracker.model.UserEvent;
import com.example.gilderNetcracker.repos.UserEventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserEventService {

    private final UserEventRepo userEventRepo;

    @Autowired
    public UserEventService(UserEventRepo userEventRepo) {
        this.userEventRepo = userEventRepo;
    }

    public boolean create(UserEvent userEvent){
        if(userEvent==null)
            return false;
        else {
            userEventRepo.save(userEvent);
            return true;
        }
    }

    public List<UserEvent> read(){
        return userEventRepo.findAll();
    }

    public boolean existById(UserEventPK id){
        return userEventRepo.existsById(id);
    }

    public UserEvent getById(UserEventPK id){
        return userEventRepo.getById(id);
    }

    public boolean update(UserEventPK id, UserEvent userEvent){
        if(userEventRepo.existsById(id)){
            userEvent.setId(id);
            userEventRepo.save(userEvent);
            return true;
        }
        else
            return false;
    }

    public boolean delete(UserEventPK id){
        if(userEventRepo.existsById(id)){
            userEventRepo.deleteById(id);
            return true;
        }
        else
            return false;
    }
}
