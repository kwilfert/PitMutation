package de.wilfert.solutionproject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    LinkedList ll;

    //non-hardcoded numbers (using array index)
    int[] nums = {55, 73, 12, 0};

    @BeforeEach
    void setUp() {
        ll = new LinkedList();
        for (int num : nums) {
            ll.add(num);
        }
    }

    @Test
    void add() {
        //added beforehand in setup
        assertEquals(ll.root.data, 55);
    }

    @Test
    void sum() {
        assertEquals(ll.sum(), 55 + 73 + 12);
    }

    @Test
    void remove() {
        assertTrue(ll.remove(nums[2]));
        assertFalse(ll.remove(nums[2]));

        //remove all for root == null case
        assertTrue(ll.remove(nums[1]));
        assertTrue(ll.remove(nums[0]));
        assertTrue(ll.remove(nums[3]));

        assertFalse(ll.remove(11));
    }

    @Test
    void findBiggest() {
        //to check when root != null
        assertEquals(ll.findBiggest(), nums[1]);

        //to check when root == null
        for (int num : nums) {
            ll.remove(num);
        }
        assertEquals(ll.findBiggest(), Integer.MIN_VALUE);
    }

    @Test
    void testToString() {
        assertEquals(ll.toString(), "->[55]->[73]->[12]->[0]");
    }
}