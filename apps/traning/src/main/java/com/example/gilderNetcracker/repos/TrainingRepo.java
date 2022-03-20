package com.example.gilderNetcracker.repos;

import com.example.gilderNetcracker.model.Training;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepo extends JpaRepository<Training,Integer> {

    @NonNull
    Training getById(@NonNull Integer id);
}
