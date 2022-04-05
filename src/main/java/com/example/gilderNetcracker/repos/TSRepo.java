package com.example.gilderNetcracker.repos;

import com.example.gilderNetcracker.model.Keys.TrainingSetPK;
import com.example.gilderNetcracker.model.TrainingSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TSRepo extends JpaRepository<TrainingSet, TrainingSetPK> {
}
