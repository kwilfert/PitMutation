package de.wilfert.solutionproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberComparatorTest {

    @Test
    void biggerOrEqual() {
        assertFalse(NumberComparator.BiggerThan(10, 10));
        assertFalse(NumberComparator.BiggerThan(9, 10));
        assertTrue(NumberComparator.BiggerThan(11, 10));
    }
}