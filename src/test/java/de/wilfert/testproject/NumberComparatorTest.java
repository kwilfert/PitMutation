package de.wilfert.testproject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberComparatorTest {

    @Test
    void biggerThan() {
        //100% code coverage?
        NumberComparator.BiggerOrEqual(9, 10);
        NumberComparator.BiggerOrEqual(10, 10);
        NumberComparator.BiggerOrEqual(11, 10);
    }
}