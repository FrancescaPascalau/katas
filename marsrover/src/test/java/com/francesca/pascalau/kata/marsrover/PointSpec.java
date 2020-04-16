package com.francesca.pascalau.kata.marsrover;

import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeMethod;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class PointSpec {
    private Point point;
    private final int x = 12;
    private final int y = 21;

    @BeforeMethod
    public void beforeTest() {
        point = new Point(x, y);
    }

    public void whenInstantiatedThenXIsSet() {
        assertEquals(point.getX(), x);
    }

    public void whenInstantiatedThenYIsSet() {
        assertEquals(point.getY(), y);
    }
}
