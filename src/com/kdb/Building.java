package com.kdb;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Building {
    private static final int MAX_LEVELS = 20;
    private static final int MIN_LEVELS = 5;
    private static final int ELEVATOR_START_POSITION = 0;
    private List<Level> levels = new ArrayList<>();
    private Elevator elevator;


    public Building() {
        int levelCount = new Random().nextInt((MAX_LEVELS - MIN_LEVELS) + 1) + MIN_LEVELS;
        for (int i = 0; i < levelCount; i++){
            levels.add(new Level(i + 1, levelCount));
        }
        elevator = new Elevator(levels.get(ELEVATOR_START_POSITION));
        System.out.println(String.format("Create new building with %d levels", levelCount));
    }

    public Elevator getElevator() {
        return elevator;
    }

    public Level getLevel(int index){
        return levels.get(index);
    }

    public int getLevelsCount(){
        return levels.size();
    }
}
