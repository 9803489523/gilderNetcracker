package com.example.gilderNetcracker.repos;

import com.example.gilderNetcracker.model.DateDelete;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateDeleteRepo extends JpaRepository<DateDelete, Integer> {
    @NonNull
    DateDelete getById(@NonNull Integer id);
}
