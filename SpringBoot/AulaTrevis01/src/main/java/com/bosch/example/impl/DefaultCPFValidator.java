package com.bosch.example.impl;

import com.bosch.example.services.CPFValidator;

public class DefaultCPFValidator implements CPFValidator {

    @Override
    public Boolean validate(String cpf) {
        // Codigozinhos legais kkkk
        System.out.println("Validei um cepas tlg kkk");
        return true;
    }
   
}