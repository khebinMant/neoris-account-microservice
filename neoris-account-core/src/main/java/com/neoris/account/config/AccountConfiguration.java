package com.neoris.account.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EntityScan(basePackages = {"com.neoris.account"})
@EnableJpaRepositories(basePackages = {"com.neoris.account"})
@ComponentScan(basePackages = {"com.neoris.account"})
@EnableTransactionManagement
public class AccountConfiguration {
}
