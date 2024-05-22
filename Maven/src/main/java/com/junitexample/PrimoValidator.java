package com.junitexample;

public class PrimoValidator {
    public String validate(int num) {
        if(num < 2){
            return "Não é primo!";
        }
        for(int i = 2; i <= (num/2); i++){
            if(num % i == 0){
                return "Não é primo!";
            }
        }
        return "É primo!";
    }
}