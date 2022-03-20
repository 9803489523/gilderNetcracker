package com.example.gilderNetcracker.services;

import com.example.gilderNetcracker.model.TrainingSet;
import com.example.gilderNetcracker.repos.TSRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TSService {

    private final TSRepo tsRepo;

    @Autowired
    public TSService(TSRepo tsRepo) {
        this.tsRepo = tsRepo;
    }

    public boolean create (TrainingSet trainingSet){
        if(trainingSet!=null){
            tsRepo.save(trainingSet);
            return true;
        }
        else
            return false;
    }

    public boolean update(Integer id, TrainingSet trainingSet){
        if(tsRepo.existsById(id)&&trainingSet!=null){
            trainingSet.setId(id);
            tsRepo.save(trainingSet);
            return true;

        }
        else
            return false;
    }

    public boolean delete(Integer id){
        if(tsRepo.existsById(id)){
            tsRepo.deleteById(id);
            return true;
        }
        else
            return false;
    }

    public List<TrainingSet> read(){
        return tsRepo.findAll();
    }
}
