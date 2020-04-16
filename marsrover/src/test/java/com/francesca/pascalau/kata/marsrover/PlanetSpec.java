package com.francesca.pascalau.kata.marsrover;

import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class PlanetSpec {

    private Planet planet;
    private final Point max = new Point(50, 50);
    private List<Point> obstacles;

    @BeforeMethod
    public void beforeTest() {
        obstacles = new ArrayList<Point>();
        obstacles.add(new Point(12, 13));
        obstacles.add(new Point(16, 32));
        planet = new Planet(max, obstacles);
    }

    public void whenInstantiatedThenMaxIsSet() {
        assertEquals(planet.getMax(), max);
    }

    public void whenInstantiatedThenObstaclesAreSet() {
        assertEquals(planet.getObstacles(), obstacles);
    }
}
