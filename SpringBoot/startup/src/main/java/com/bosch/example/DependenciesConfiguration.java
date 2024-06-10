package com.bosch.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.bosch.example.impl.DefaultCpfValidator;
import com.bosch.example.impl.TestCpfValidator;
import com.bosch.example.services.CPFValidator;

@Configuration
public class DependenciesConfiguration {
    
    @Bean
    @Scope("singleton")
    public CPFValidator cpfValidator(){
        return new DefaultCpfValidator();
    }
}
