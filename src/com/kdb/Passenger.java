package com.kdb;

import java.util.Random;

public class Passenger{
    private Direction direction;
    private int targetLevelNumber;
    private int currentLevelNumber;
    private int maxLevel;
    private static final int MIN_LEVEL = 1;
    private String name;

    public Passenger(Level currentLevel, int maxLevel, String name) {
        this.maxLevel = maxLevel;
        this.name = name;
        currentLevelNumber = currentLevel.getNumber();
        setTargetLevelNumber();
    }

    public Direction getDirection() {
        return direction;
    }

    public String getName() {
        return name;
    }

    public int getTargetLevelNumber() {
        return targetLevelNumber;
    }

    public void setNewCurrentLevelNumber(int number) {
        currentLevelNumber = number;
        setTargetLevelNumber();
    }

    public void enterToElevator(Elevator elevator, Level currentLevel){
        elevator.addPassenger(this);
        currentLevel.getPassengers().remove(this);
    }

    public void exitFromElevator(Elevator elevator, Level currentLevel){
        setNewCurrentLevelNumber(currentLevel.getNumber());
        currentLevel.getPassengers().add(this);
        elevator.removePassenger(this);
    }

    private void setDirection(){
        if (currentLevelNumber > targetLevelNumber){
            direction = Direction.DOWN;
        } else {
            direction = Direction.UP;
        }
    }

    private void setTargetLevelNumber() {
        do{
            targetLevelNumber = new Random().nextInt((maxLevel - MIN_LEVEL) + 1) + MIN_LEVEL;
        }
        while (targetLevelNumber == currentLevelNumber);
        setDirection();
    }
}
