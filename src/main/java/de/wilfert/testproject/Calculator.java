package de.wilfert.testproject;

public class Calculator {


    public int greatestCommonDenominator(int a, int b) {
        if (b == 0) {
            return a;
        }
        return greatestCommonDenominator(b, a % b);
    }

    public float add(float number1, float number2) {
        return number1 + number2;
    }

    public float sub(float number1, float number2) {
        return number1 - number2;
    }

    public float mult(float number1, float number2) {
        return number1 * number2;
    }

    public float div(float number1, float number2) {
        if (number2 == 0) {
            throw new IllegalArgumentException("Argument 'divisor' is 0");
        }
        return number1 / number2;
    }
}
