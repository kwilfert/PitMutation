package de.wilfert.testproject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeMachineTest {

    CoffeeMachine machine;

    @BeforeEach
    void setUp() {
        machine = new CoffeeMachine();
    }

    @Test
    void flipSwitch() {
        assertFalse(machine.isTurnedOn());
        machine.flipSwitch();
        assertTrue(machine.isTurnedOn());
        machine.flipSwitch();
        assertFalse(machine.isTurnedOn());
    }

    @Test
    void makeCoffee() {
        assertFalse(machine.makeCoffee());

    }

    @Test
    void positionCup() {
        try {
            machine.positionCup();
        } catch (Exception e) {
            //shouldn't happen yet
            //e.printStackTrace();
        }
        assertThrows(Exception.class, () -> {
            //now it shall throw an exception
            machine.positionCup();
        });
    }

    @Test
    void removeCup() {
        assertFalse(machine.removeCup());
        try {
            machine.positionCup();
            assertTrue(machine.removeCup());
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    @Test
    void fillWater() {
        machine.setCurrentWater(0);
        machine.fillWater();
        assertTrue(machine.getCurrentWater() >= machine.maxWater);
    }

    @Test
    void fillBeans() {
        machine.setCurrentBeans(0);
        machine.fillBeans();
        assertTrue(machine.getCurrentBeans() >= machine.maxBeans);
    }
}