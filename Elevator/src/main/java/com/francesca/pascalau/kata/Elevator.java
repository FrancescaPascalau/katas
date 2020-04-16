package com.francesca.pascalau.kata;

import java.util.TreeSet;

public class Elevator {

    private int currentPosition = 0;
    private TreeSet<Integer> elevatorQueue = new TreeSet<>();

    public int pressButton(int floorRequired) {
        elevatorQueue.add(floorRequired);
        elevatorQueue = organizeElevatorFloors();
        currentPosition = floorRequired;
        return currentPosition;
    }

    private TreeSet<Integer> organizeElevatorFloors() {
        return (TreeSet<Integer>) elevatorQueue.descendingSet();
    }
}
