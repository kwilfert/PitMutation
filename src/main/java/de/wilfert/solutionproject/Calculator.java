package de.wilfert.solutionproject;

public class Calculator {
    float displayed = 0;

    public void greatestCommonDenominator(int a, int b) {
        //100% mutation coverage not possible
        while (a != b)
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        displayed = a;
    }

    public void add(float number1, float number2) {
        setDisplayed(number1 + number2);
    }

    public void sub(float number1, float number2) {
        setDisplayed(number1 - number2);
    }

    public void mult(float number1, float number2) {
        setDisplayed(number1 * number2);
    }

    public void div(float number1, float number2) {
        if (number2 == 0) {
            throw new IllegalArgumentException("Argument 'divisor' is 0");
        } else {
            setDisplayed(number1 / number2);
        }
    }

    public void setDisplayed(float output) {
        displayed = output;
    }

    public boolean isPositive(int number) {
        //code coverage
        boolean result = false;
        if (number >= 0) {
            return true;
        }
        return result;
    }
}
