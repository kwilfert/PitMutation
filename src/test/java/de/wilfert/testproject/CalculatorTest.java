package de.wilfert.testproject;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    Calculator calc;

    @BeforeEach
    void setUp() {
        calc = new Calculator();
    }

    @Test
    void add() {
        Assertions.assertEquals(calc.add(1, 1), 2);
    }

    @Test
    void sub() {
        Assertions.assertEquals(calc.sub(5, 10), -5);
    }

    @Test
    void mult() {
        Assertions.assertEquals(calc.mult(2, 2), 4);
    }

    @Test
    void div() {
        assertThrows(IllegalArgumentException.class, () -> calc.div(10, 0));
        Assertions.assertEquals(2, calc.div(10, 5));
    }

    @Test
    void greatestCommonDenominator() {
        Assertions.assertEquals(calc.greatestCommonDenominator(97207, 77), 11);
    }
}