package com.bosch.example.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bosch.example.dto.User;

@RestController
public class TestController {

    @GetMapping("/test/sum")
    public Integer test01(Integer a, Integer b) {
        return (a + b);
    }

    @GetMapping("/test/pathvariable/{a}/{b}")
    public Integer test02(@PathVariable Integer a, @PathVariable Integer b) {
        return a + b;
    }

    @GetMapping("/test/user")
    public String test03(@RequestBody User user) {
        if (user.name() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "name is missing.");
        } else if (user.email() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "email is missing.");
        } else if (user.password() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "password is missing.");
        }
        // String name = user.name();
        // for (char c : name.toCharArray()) {
        // }
        // if (name.matches("[0-9.]+")) {
        //     throw new ResponseStatusException(
        //             HttpStatus.BAD_REQUEST, "password is missing.");
        // }

        return user.name();
    }
}