package com.francesca.pascalau.kata;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ElevatorShould {

    private static Elevator elevator;
    private int currentFloor;

    @Before
    public final void before(){
        elevator = new Elevator();
    }

    @Test
    public void bring_from_current_floor_to_specified_floor(){
        callElevator(3);
    }

    @Test
    public void bring_from_current_floor_to_specified_floor_no_limited_times(){
        callElevator(3);
        callElevator(5);
    }

    private void callElevator(int floor) {
        currentFloor = elevator.pressButton(floor);
        assertThat(currentFloor).isEqualTo(floor);
    }

    @Test
    public void bring_from_current_floor_to_specified_floors_in_order(){
        int[] floors = {3, 0, 2, 1};
        for (int index = 0; index < floors.length; index++) {
            elevator.pressButton(floors[index]);
        }
        assertThat(currentFloor).isEqualTo(0);
    }
}
