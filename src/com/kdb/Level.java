package com.kdb;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Level {
    private static final int MAX_PASSENGERS_COUNT = 10;
    private List<Passenger> passengers = new ArrayList<>();
    private int number;

    public Level(int number, int levelCount) {
        this.number = number;
        int startPassengersCount = new Random().nextInt(MAX_PASSENGERS_COUNT);
        for (int i = 0; i < startPassengersCount; i++){
            String passengerName = this.number + " " + i;
            passengers.add(new Passenger(this, levelCount, passengerName));
        }
        System.out.println(String.format("Create new level with %d passengers", startPassengersCount));
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public int getNumber() {
        return number;
    }
}
