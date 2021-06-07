package de.wilfert.solutionproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoffeeMachineTest {

    CoffeeMachine machine;

    @BeforeEach
    void setUp() {
        machine = new CoffeeMachine();
    }

    @Test
    void getSetCurrentWater() {
        //water should be 1000 in after initializing (as seen in class)
        Assertions.assertEquals(1000, machine.getCurrentWater());
        machine.setCurrentWater(42);
        Assertions.assertEquals(42, machine.getCurrentWater());
    }

    @Test
    void getSetCurrentBeans() {
        //beans should be 800 in after initializing (as seen in class)
        Assertions.assertEquals(800, machine.getCurrentBeans());
        machine.setCurrentBeans(42);
        Assertions.assertEquals(42, machine.getCurrentBeans());
    }

    @Test
        //checks for state switching (on/off)
    void SwitchStates() {
        //by default machine is off
        Assertions.assertFalse(machine.isTurnedOn());

        //then, switch on and check if on
        machine.setTurnedOn(true);
        Assertions.assertTrue(machine.isTurnedOn());

        //switch off to see if turned off correctly
        machine.setTurnedOn(false);
        Assertions.assertFalse(machine.isTurnedOn());

        //and now check the inversion
        machine.flipSwitch();

        Assertions.assertTrue(machine.isTurnedOn());
    }

    @Test
    void cupTesting() {
        //per default, no cup should be positioned
        Assertions.assertFalse(machine.isCupPositioned());
        Assertions.assertFalse(machine.removeCup());

        Assertions.assertDoesNotThrow(() -> machine.positionCup());

        Assertions.assertTrue(machine.removeCup());
        Assertions.assertFalse(machine.isCupPositioned());
        machine.setCupPositioned(true);
        Assertions.assertTrue(machine.isCupPositioned());

    }

    @Test
    void makeCoffee() {

        //by default, coffee can be brewed, only cup needs to be positioned

        //try without cup
        Assertions.assertFalse(machine.makeCoffee());

        //try with cup
        Assertions.assertDoesNotThrow(() -> {
            machine.positionCup();
        });

        Assertions.assertThrows(Exception.class, () -> {
            machine.positionCup();
        });


        Assertions.assertTrue(machine.makeCoffee());

        //check if correct amount as been subtracted
        Assertions.assertEquals(machine.getCurrentWater(), 1000 - machine.waterPerCup);
        Assertions.assertEquals(machine.getCurrentBeans(), 800 - machine.beansPerCup);

        //reset
        machine.fillWater();
        machine.fillBeans();
        machine.setCupPositioned(true);

        //test over boundary
        Assertions.assertTrue(machine.makeCoffee());
        Assertions.assertTrue(machine.makeCoffee());

        //set only water to boundary values and below
        machine.setCurrentWater(0);
        Assertions.assertFalse(machine.makeCoffee());
        machine.setCurrentWater(machine.waterPerCup);
        Assertions.assertTrue(machine.makeCoffee());

        //reset water
        machine.fillWater();

        //set only beans to boundary value and below
        machine.setCurrentBeans(0);
        Assertions.assertFalse(machine.makeCoffee());
        machine.setCurrentBeans(machine.beansPerCup);
        Assertions.assertTrue(machine.makeCoffee());


    }

    @Test
    void fillWater() {
        //just to make sure, water is empty
        machine.setCurrentWater(0);
        Assertions.assertEquals(machine.getCurrentWater(), 0);

        //ensure, water fills up to maximum
        machine.fillWater();
        Assertions.assertEquals(machine.maxWater, machine.getCurrentWater());
    }

    @Test
    void fillBeans() {
        //just to make sure, water is empty
        machine.setCurrentBeans(0);
        Assertions.assertEquals(machine.getCurrentBeans(), 0);

        //ensure, water fills up to maximum
        machine.fillBeans();
        Assertions.assertEquals(machine.maxBeans, machine.getCurrentBeans());
    }

}