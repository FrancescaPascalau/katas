package com.francesca.pascalau.kata.marsrover;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@Test
public class RoverShould {

    private Location location;
    private Rover rover;
    private Planet planet;

    private static final Point OBSTACLE1 = new Point(25, 25);
    private static final Point OBSTACLE2 = new Point(15, 15);
    private static final Point OBSTACLE3 = new Point(5, 5);
    private List<Point> obstacles = new ArrayList<>();

    @BeforeMethod
    public void beforeTest(){
        Point max = new Point(50 ,50);
        obstacles.add(OBSTACLE1);
        obstacles.add(OBSTACLE2);
        obstacles.add(OBSTACLE3);

        planet = new Planet(max, obstacles);
        location = new Location(
                new Point(24, 31), Direction.NORTH);
        rover = new Rover(location, planet);
    }

    public void when_instantiated_then_set_location() {
        assertEquals(rover.getLocation(), location);
    }

//    public void given_north_when_move_forward_then_Y_increases(){
//        rover.moveForward();
//        assertEquals(rover.getLocation().getY(), 12);
//    }
//
//    public void given_east_when_move_forward_then_X_increases(){
//        rover.getLocation().setDirection(Direction.EAST);
//        rover.moveForward();
//        assertEquals(rover.getLocation().getX(), 22);
//    }

    //Instead of checking the forward action for each direction, we only check the general behavior
    public void when_move_forward_then_forward_action_called() {
        Location expected = location.copy();
        expected.forward();
        rover.moveForward();
        assertEquals(rover.getLocation(), expected);

    }

    public void when_move_backward_then_backward_action_called() {
        Location expected = location.copy();
        expected.backward();
        rover.moveBackward();
        assertEquals(rover.getLocation(), expected);
    }

    public void when_turn_rover_left_then_change_direction_to_left() {
        Location expected = location.copy();
        expected.turnLeft();
        rover.turnLeft();
        assertEquals(rover.getLocation(), expected);
    }

    public void when_turn_rover_right_then_change_direction_to_right() {
        Location expected = location.copy();
        expected.turnRight();
        rover.turnRight();
        assertEquals(rover.getLocation(), expected);
    }

    public void when_receive_command_F_then_move_forward(){
        Location expected = location.copy();
        expected.forward();
        rover.receiveCommands("f");
        assertEquals(rover.getLocation(), expected);
    }

    public void when_receive_command_B_then_move_backward(){
        Location expected = location.copy();
        expected.backward();
        rover.receiveCommands("b");
        assertEquals(rover.getLocation(), expected);
    }

    public void when_receive_command_L_then_move_left(){
        Location expected = location.copy();
        expected.turnLeft();
        rover.receiveCommands("l");
        assertEquals(rover.getLocation(), expected);
    }

    public void when_receive_command_R_then_move_right(){
        Location expected = location.copy();
        expected.turnRight();
        rover.receiveCommands("r");
        assertEquals(rover.getLocation(), expected);
    }

    public void when_receiving_commands_then_execute_them(){
        Location expected = location.copy();
        expected.turnRight();
        expected.forward(planet.getMax(), planet.getObstacles());
        expected.turnLeft();
        expected.backward(planet.getMax(), planet.getObstacles());
        rover.receiveCommands("rflb");
        assertEquals(rover.getLocation(), expected);
    }

    public void when_instantiated_then_planet_is_stored(){
        assertEquals(rover.getPlanet(), planet);
    }

    public void overpass_east_edge_of_planet(){
        location.setDirection(Direction.EAST);
        location.getPoint().setX(planet.getMax().getX());
        rover.receiveCommands("f");
        assertEquals(location.getX(), 1);
    }

    public void
    when_forward_and_encounter_obstacle_the_stay_at_current_position_and_report_obstacle(){
        Location expected = location.copy();
        expected.forward(planet.getMax(), planet.getObstacles());
        rover.receiveCommands("f");
        assertEquals(rover.getLocation(), expected);
    }
    public void
    when_backward_and_encounter_obstacle_the_stay_at_current_position_and_report_obstacle(){
        Location expected = location.copy();
        expected.backward(planet.getMax(), planet.getObstacles());
        rover.receiveCommands("b");
        assertEquals(rover.getLocation(), expected);
    }
}
