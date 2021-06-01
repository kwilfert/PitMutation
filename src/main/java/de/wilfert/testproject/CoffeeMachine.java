package de.wilfert.testproject;

/**
 * a more complex class for testing
 * A code replica of a coffee machine
 */
public class CoffeeMachine {

    //Hardware limits of the machine
    public final int beansPerCup = 100;
    public final float waterPerCup = 200;

    public final float maxWater = 1000;
    public final int maxBeans = 1200;

    public float getCurrentWater() {
        return currentWater;
    }

    public void setCurrentWater(float newWater) {
        this.currentWater = Math.max(maxWater, newWater);
    }

    public int getCurrentBeans() {
        return currentBeans;
    }

    public void setCurrentBeans(int newBeans) {
        this.currentBeans = Math.min(maxBeans, newBeans);
    }

    public boolean isTurnedOn() {
        return turnedOn;
    }

    public void setTurnedOn(boolean turnedOn) {
        this.turnedOn = turnedOn;
    }

    public boolean isCupPositioned() {
        return cupPositioned;
    }

    public void setCupPositioned(boolean cupPositioned) {
        this.cupPositioned = cupPositioned;
    }

    //variable sensor data
    private float currentWater = 1000;
    private int currentBeans = 800;

    private boolean turnedOn = false;
    private boolean cupPositioned = false;

    public void flipSwitch() {
        turnedOn = !turnedOn;
    }

    /**
     * @return true if coffee could be made successfully, subtract water and beans, if so
     */
    public boolean makeCoffee() {
        if (currentWater > waterPerCup && currentBeans > beansPerCup && cupPositioned) {
            currentWater -= waterPerCup;
            currentBeans -= beansPerCup;
            return true;
        } else return false;
    }

    /**
     * @throws Exception when cup is already positioned
     */
    public void positionCup() throws Exception {
        if (cupPositioned) {
            throw new Exception("You broke a cup trying to fit two cups into the small coffee machine");
        } else {
            cupPositioned = true;
        }
    }

    /**
     * method for removing cup from receptacle
     *
     * @return true if a cup was positioned
     */
    public boolean removeCup() {
        if (cupPositioned) {
            cupPositioned = false;
            return true;
        }
        return false;
    }

    /**
     * Method that should fill the water up to the maximum water level
     */
    public void fillWater() {
        while (currentWater <= maxBeans) {
            currentWater++;
        }
    }

    /**
     * Method that should fill the beans zp to the maximum bean count
     */
    public void fillBeans() {
        while (currentBeans <= maxBeans) {
            currentBeans++;
        }
    }

}
