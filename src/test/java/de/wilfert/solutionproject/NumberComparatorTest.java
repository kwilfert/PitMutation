package de.wilfert.solutionproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberComparatorTest {

    @Test
    void biggerOrEqual() {
        //for 100% line coverage, object needs to be initialized
        NumberComparator nc = new NumberComparator();

        //normal assertions covering every possible case
        assertFalse(NumberComparator.BiggerOrEqual(9, 10));
        assertTrue(NumberComparator.BiggerOrEqual(10, 10));
        assertTrue(NumberComparator.BiggerOrEqual(11, 10));
    }
}