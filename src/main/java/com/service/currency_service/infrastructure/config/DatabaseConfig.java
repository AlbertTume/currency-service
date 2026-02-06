package com.service.currency_service.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.service.currency_service.infrastructure.adapter.out.persistence.jpa.repository"
)
@EnableTransactionManagement
public class DatabaseConfig {
}
