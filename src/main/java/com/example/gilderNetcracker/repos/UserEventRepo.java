package com.example.gilderNetcracker.repos;

import com.example.gilderNetcracker.model.Keys.UserEventPK;
import com.example.gilderNetcracker.model.UserEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEventRepo extends JpaRepository<UserEvent, UserEventPK> {
}
