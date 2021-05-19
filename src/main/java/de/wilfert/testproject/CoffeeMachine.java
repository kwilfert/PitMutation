package de.wilfert.testproject;

/**
 * a more complex class for testing
 * A code replica of a coffee machine
 */
public class CoffeeMachine {

    //Hardware limits of the machine
    private final float beansPerCup = 100;
    private final float waterPerCup = 200;

    private final float maxWater = 1000;
    private final float minWater = 100;
    private final int maxBeans = 900;



    //variable sensor data
    private float currentWater;
    private int currentBeans;

    private boolean turnedOn;
    private boolean cupPositioned;

    public void flipSwitch(){
        turnedOn = !turnedOn;
    }

    public void makeCoffee(){
        if(currentWater > waterPerCup && currentBeans > beansPerCup){
            if (cupPositioned){

            }
        }
    }

}
