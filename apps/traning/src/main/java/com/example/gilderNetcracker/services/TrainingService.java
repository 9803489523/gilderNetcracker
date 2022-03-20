package com.example.gilderNetcracker.services;

import com.example.gilderNetcracker.model.Training;
import com.example.gilderNetcracker.repos.TrainingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TrainingService {

    private final TrainingRepo trainingRepo;

    @Autowired
    public TrainingService(TrainingRepo trainingRepo) {
        this.trainingRepo = trainingRepo;
    }

    public boolean create(Training training){
        if(training==null)
            return false;
        else {
            trainingRepo.save(training);
            return true;
        }
    }

    public boolean delete(Integer id){
        if(trainingRepo.existsById(id)){
            trainingRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean update(Integer id,Training training){
        if(training==null || id==null || !trainingRepo.existsById(id))
            return false;
        else{
            training.setId(id);
            trainingRepo.save(training);
            return true;
        }
    }

    public List<Training> read(){
        return trainingRepo.findAll();
    }

}
