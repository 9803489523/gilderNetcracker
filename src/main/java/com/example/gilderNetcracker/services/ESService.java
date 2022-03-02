package com.example.gilderNetcracker.services;

import com.example.gilderNetcracker.model.EventSet;
import com.example.gilderNetcracker.repos.ESRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ESService {

    private final ESRepo esRepo;

    @Autowired
    public ESService(ESRepo esRepo) {
        this.esRepo = esRepo;
    }

    public boolean delete(Integer id){
        if(esRepo.existsById(id)){
            esRepo.deleteById(id);
            return true;
        }
        else
            return false;
    }

    public boolean create(EventSet eventSet){
        if(eventSet!=null){
            esRepo.save(eventSet);
            return true;
        }
        else
            return false;
    }

    public boolean update(Integer id, EventSet eventSet){
        if(esRepo.existsById(id)&&eventSet!=null){
            eventSet.setId(id);
            esRepo.save(eventSet);
            return true;
        }
        else
            return false;
    }

    public List<EventSet> read(){
        return esRepo.findAll();
    }

}
