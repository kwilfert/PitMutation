package de.wilfert.solutionproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        //previously used add() instead -> changed to mult()
        calc.mult(3, 2);
        Assertions.assertEquals(calc.displayed, 6);
    }

    @Test
    void div() {
        calc.div(10, 5);
        Assertions.assertEquals(calc.displayed, 2);
        assertThrows(IllegalArgumentException.class, () -> calc.div(10, 0));
    }

    @Test
    void greatestCommonDenominator() {
        // 100% mutation coverage not possible because
        // while-condition interferes with if condition

        //check a > b
        calc.greatestCommonDenominator(96, 60);
        Assertions.assertEquals(calc.displayed, 12);

        //check a < b
        calc.greatestCommonDenominator(8, 32);
        Assertions.assertEquals(calc.displayed, 8);

        //check a == b
        calc.greatestCommonDenominator(20, 20);
        Assertions.assertEquals(calc.displayed, 20);
    }

    @Test
    public void testPositive() {
        //test all cases
        assertTrue(calc.isPositive(1));
        assertTrue(calc.isPositive(0));
        assertFalse(calc.isPositive(-1));
    }

    //setDisplayed originally never used
}