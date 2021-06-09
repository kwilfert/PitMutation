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
        calc.add(2, 2);
        Assertions.assertEquals(calc.displayed, 4);
    }

    @Test
    void sub() {
        calc.sub(5, -5);
        Assertions.assertEquals(calc.displayed, 10);
    }

    @Test
    void mult() {
        calc.add(2, 2);
        Assertions.assertEquals(calc.displayed, 4);
    }

    @Test
    void div() {
        assertThrows(IllegalArgumentException.class, () -> calc.div(10, calc.displayed));
        calc.div(10, 5);
        Assertions.assertEquals(calc.displayed, 2);
    }

    @Test
    void greatestCommonDenominator() {
        calc.greatestCommonDenominator(2, 2);
        Assertions.assertEquals(calc.displayed, 2);
    }

    @Test
    public void testPositive() {
        Assertions.assertEquals(true, calc.isPositive(10));
    }


}