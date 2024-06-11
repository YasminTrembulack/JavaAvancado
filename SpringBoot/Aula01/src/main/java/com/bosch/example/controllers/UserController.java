package com.bosch.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.model.User;
import com.bosch.example.repositories.UserJPARepository;
import com.bosch.example.services.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class UserController {
    @Autowired
    UserService repo;

    @PostMapping("/user")
    public String postMethodName(@RequestBody User user) {
        repo.save(user);
        return "Usuário cadastrado com sucesso!";
    }

    @GetMapping("/user")
    public List<User> getMethodName(@RequestParam String country) {
        return repo.findByCountry(country);
    }

    @GetMapping("/user/{search}")
    public List<User> getMethod(@PathVariable String search) {
        return repo.findByUsernameContaining(search);
    }

    
}
