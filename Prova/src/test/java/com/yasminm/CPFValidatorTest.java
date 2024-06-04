package com.yasminm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.yasminm.test.CPFValidator;

// mvn clean test

public class CPFValidatorTest {
    private final CPFValidator validator = new CPFValidator();

    @Test
    public void validate() {

        // CPF valido
        assertEquals(
            validator.validate("54647142949"),
            true
        );
        assertEquals(
            validator.validate("28369679510"),
            true
        );

        //Numeros iguais
        assertEquals(
            validator.validate("00000000000"),
            false
        );
        assertEquals(
            validator.validate("11111111111"),
            false
        );

        //Menos de 11 digitos
        assertEquals(
            validator.validate("1234567890"),
            false
        );
        //Mais de 11 digitos
        assertEquals(
            validator.validate("123456789011"),
            false
        );

        //Com letras
        assertEquals(
            validator.validate("3231aaaaaaa"),
            false
        );

        assertEquals(
            validator.validate("54647142940"),
            false
        );
        
    }
}
