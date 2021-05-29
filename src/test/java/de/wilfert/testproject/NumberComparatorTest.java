package de.wilfert.testproject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberComparatorTest {

    @Test
    void biggerThan() {
        //100% code coverage?
        NumberComparator.BiggerThan(9, 10);
        NumberComparator.BiggerThan(10, 10);
        NumberComparator.BiggerThan(11, 10);
    }
}