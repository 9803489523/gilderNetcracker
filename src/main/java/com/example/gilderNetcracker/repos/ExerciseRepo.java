package com.example.gilderNetcracker.repos;

import com.example.gilderNetcracker.model.Exercise;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepo extends JpaRepository<Exercise,Integer> {

    @NonNull
    Exercise getById(@NonNull Integer id);
}
