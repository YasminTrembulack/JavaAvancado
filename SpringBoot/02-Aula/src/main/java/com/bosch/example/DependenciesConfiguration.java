package com.bosch.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.bosch.example.impl.DatabaseUserService;
import com.bosch.example.impl.DefaultCpfValidator;
import com.bosch.example.impl.MockUserService;
import com.bosch.example.impl.TestCpfValidator;
import com.bosch.example.services.CPFValidator;
import com.bosch.example.services.UserService;

@SuppressWarnings("unused")
@Configuration
public class DependenciesConfiguration {
    
    @Bean
    @Scope("singleton")
    public CPFValidator cpfValidator(){
        return new DefaultCpfValidator();
    }

    @Bean
    @Scope("singleton")
    public UserService userService(){
        return new DatabaseUserService();    // Banco de dados
        // return new MockUserService();           // Banco de dados Fake
    }

}
