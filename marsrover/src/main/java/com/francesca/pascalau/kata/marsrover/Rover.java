package com.francesca.pascalau.kata.marsrover;

public class Rover {

    private final Location location;
    private final Planet planet;

    public Rover(Location location, Planet planet) {
        this.location = location;
        this.planet = planet;
    }

    public Location getLocation() {
        return location;
    }

    public Planet getPlanet() {
        return planet;
    }

    public boolean moveForward() {
        return location.forward(planet.getMax(), planet.getObstacles());
    }

    public boolean moveBackward() {
        return location.backward(planet.getMax(), planet.getObstacles());
    }

    public void turnLeft() {
        location.turnLeft();
    }

    public void turnRight() {
        location.turnRight();
    }

    public void receiveCommands(String commands) {
        for(char command : commands.toCharArray()){
            switch (command){
                case 'f': {
                    moveForward();
                    break;
                }
                case 'b': {
                    moveBackward();
                    break;
                }
                case 'l': {
                    turnLeft();
                    break;
                }
                case 'r': {
                    turnRight();
                    break;
                }
            }
        }
    }
}
