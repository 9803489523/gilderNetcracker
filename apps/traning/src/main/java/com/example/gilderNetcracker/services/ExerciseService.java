package com.example.gilderNetcracker.services;

import com.example.gilderNetcracker.model.Exercise;
import com.example.gilderNetcracker.repos.ExerciseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {

    private final ExerciseRepo exerciseRepo;

    @Autowired
    public ExerciseService(ExerciseRepo exerciseRepo) {
        this.exerciseRepo = exerciseRepo;
    }

    public boolean create(Exercise exercise){
        if(exercise==null)
            return false;
        else {
            exerciseRepo.save(exercise);
            return true;
        }
    }

    public boolean delete(Integer id){
        if(exerciseRepo.existsById(id)){
            exerciseRepo.deleteById(id);
            return true;
        }
            return false;
    }

    public boolean update(Integer id,Exercise exercise){
        if(exerciseRepo.existsById(id)){
            exercise.setId(id);
            exerciseRepo.save(exercise);
            return true;
        }
        return false;
    }

    public List<Exercise> read(){
        return exerciseRepo.findAll();
        }

}
