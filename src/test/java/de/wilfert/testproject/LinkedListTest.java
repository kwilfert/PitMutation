package de.wilfert.testproject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    LinkedList ll;

    @BeforeEach
    void setUp() {
        ll = new LinkedList();
    }

    @Test
    void add() {
        ll.add(12);
        assertEquals(ll.root.data, 12);
    }

    @Test
    void remove() {
        ll.add(12);
        assertTrue(ll.remove(12));
    }

    @Test
    void sum() {
        ll.add(88);
        assertEquals(ll.sum(), 88);
    }

    @Test
    void findBiggest() {
        ll.add(99);
        ll.add(36);
        ll.add(0);
        assertEquals(ll.findBiggest(), 99);
    }
}