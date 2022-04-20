package com.example.gilderNetcracker.services;

import com.example.gilderNetcracker.model.DateDelete;
import com.example.gilderNetcracker.model.Event;
import com.example.gilderNetcracker.repos.DateDeleteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DateDeleteService {
    private final DateDeleteRepo dateDeleteRepo;

    @Autowired
    public DateDeleteService(DateDeleteRepo dateDeleteRepo) {
        this.dateDeleteRepo =dateDeleteRepo;
    }

    public boolean create(DateDelete dateDelete){
        if(dateDelete==null)
            return false;
        else {
            dateDeleteRepo.save(dateDelete);
            return true;
        }
    }

    public boolean existById(Integer id){
        return dateDeleteRepo.existsById(id);
    }

    public DateDelete getById(Integer id){
        return dateDeleteRepo.getById(id);
    }

    public boolean delete(Integer id){
        if(id==null || !dateDeleteRepo.existsById(id))
            return false;
        else{
            dateDeleteRepo.deleteById(id);
            return true;
        }
    }

    public List<DateDelete> read(){
        return dateDeleteRepo.findAll();
    }

    public boolean update(Integer id, DateDelete dateDelete){
        if(id==null || dateDelete==null || !dateDeleteRepo.existsById(id))
            return false;
        else{
            dateDelete.setId(id);
            dateDeleteRepo.save(dateDelete);
            return true;
        }
    }
}
