package com.junitexample;

public class ParImparValidator {
    public String validate(int num) {
        return  (num % 2 == 0) ? "É Par." : "É Impar.";
    
    }
}