package com.netcracker.challenge.db;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EntityScan(basePackages = {
        "com.netcracker.challenge.db.entity"
})
@EnableJpaRepositories(basePackages = "com.netcracker.challenge.db.repository")
@EnableTransactionManagement
public class DatabaseConfiguration {
}
