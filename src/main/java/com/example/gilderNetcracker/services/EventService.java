package com.example.gilderNetcracker.services;

import com.example.gilderNetcracker.model.Event;
import com.example.gilderNetcracker.model.Training;
import com.example.gilderNetcracker.repos.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EventService {

    private final EventRepo eventRepo;

    @Autowired
    public EventService(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    public boolean create(Event event){
        if(event==null)
            return false;
        else {
            eventRepo.save(event);
            return true;
        }
    }

    public boolean existById(Integer id){
        return eventRepo.existsById(id);
    }

    public Event getById(Integer id){
        return eventRepo.getById(id);
    }

    public boolean delete(Integer id){
        if(id==null || !eventRepo.existsById(id))
            return false;
        else{
            eventRepo.deleteById(id);
            return true;
        }
    }

    public List<Event> read(){
        return eventRepo.findAll();
    }

    public boolean update(Integer id, Event event){
        if(id==null || event==null || !eventRepo.existsById(id))
            return false;
        else{
            event.setId(id);
            eventRepo.save(event);
            return true;
        }
    }
}
