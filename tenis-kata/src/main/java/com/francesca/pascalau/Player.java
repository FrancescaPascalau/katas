package com.francesca.pascalau;

import java.util.ArrayList;
import java.util.List;

import static com.francesca.pascalau.TennisGame.Points;

public class Player {

    private String name;
    private List<Points> points = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public void winBall() {
        for (Points point : Points.values())
            points.add(point);
    }

    public void winGame() {
        if (points.stream().distinct().count() == 4)
            System.out.println(name + " won this game!");
        restartGame();
    }

    private void restartGame(){
        points.clear();
    }

    public List<Points> getPoints() {
        return points;
    }
}
