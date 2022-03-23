package com.example.gilderNetcracker.repos;

import com.example.gilderNetcracker.model.Event;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepo extends JpaRepository<Event,Integer> {

    @NonNull
    Event getById(@NonNull Integer id);
}
