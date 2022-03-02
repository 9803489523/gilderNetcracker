package com.example.gilderNetcracker.repos;

import com.example.gilderNetcracker.model.EventSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ESRepo extends JpaRepository<EventSet,Integer> {
}
