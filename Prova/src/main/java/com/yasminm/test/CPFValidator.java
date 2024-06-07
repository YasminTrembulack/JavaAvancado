package com.yasminm.test;

import java.util.InputMismatchException;

public class CPFValidator {
    public Boolean validate(String cpf) {
        if(cpf.length() != 11){
            return false;
        }
        
        int igual = 0;
        for(int i = 0; i < 10; i++){
            if (cpf.charAt(i) == cpf.charAt(i+1)){
                igual++;
            }
        }
        if(igual == 10){
            return false;
        }
        
        for(int i = 0; i < 11; i++){
            if(!Character.isDigit(cpf.charAt(i))){
                return false;
            }
        }
        
        int num = 10, soma = 0, x = 0, y = 0;
        for(int i = 0; i < 9; i++){
            soma += Character.getNumericValue(cpf.charAt(i)) * num;
            num--;
        }
        x = soma % 11 < 2 ? 0 : 11 - (soma % 11);
        
        soma = 0;
        num = 11;
        for(int i = 0; i < 10; i++){
            soma += Character.getNumericValue(cpf.charAt(i)) * num;
            num--;
        }
        y = soma % 11 < 2 ? 0 : 11 - (soma % 11);
        
        if(Character.getNumericValue(cpf.charAt(9)) == x && Character.getNumericValue(cpf.charAt(10)) == y){
            return true;
        }
        
        return false;
    }
}
