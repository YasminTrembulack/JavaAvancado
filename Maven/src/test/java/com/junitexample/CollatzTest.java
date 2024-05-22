package com.junitexample;

// 1.Verificar se um número é par (nosssa)
// 2.Verificar se um número é primo (oia)
// 3.Verificar se um número atende a 
// conjectura de collatz:
// 	C(n) = n/2, se  n é par
// 	C(n) = 3*n + 1, se n é impar
// 	A conjectura diz que todo número
// 	Chega em 1 se jogado na função 
// 	várias vezes. Exemplo:
// 	9 -> 3*9 + 1 = 28 -> 14 -> 7
// 	-> 22 -> 11 -> 34 -> 17 -> 52
// 	-> 26 -> 13 -> 40 -> 20 -> 10
// 	-> 5 -> 16 -> 8 -> 4 -> 2 -> 1


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
 
import com.junitexample.CollatzValidator;

// mvn clean test
 
// A classe deve terminar com 'Test' no nome.
class CollatzTest {
    private final CollatzValidator validator = new CollatzValidator();
 
    @Test
    void validate() {
        assertEquals(
            validator.validate(29),
            true
        );

        assertEquals(
            validator.validate(2),
            true
        );

        assertEquals(
            validator.validate(1),
            true
        );

        assertEquals(
            validator.validate(9824),
            true
        );

        assertEquals(
            validator.validate(0),
            false
        );

        assertEquals(
            validator.validate(432458),
            true
        );

        assertEquals(
            validator.validate(-33),
            false
        );
 
    }
}
