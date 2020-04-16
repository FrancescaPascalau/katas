package com.francesca.pascalau;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class TennisGame {

    List<Player> players = new ArrayList<>();
    Predicate<Integer> deuce = i -> (i == 4);

    public boolean onDeuce() {
        List<Integer> points = new ArrayList<>();
        for (Player player : players) {
            points.add((int) player.getPoints().stream().distinct().count());
        }
        return points.stream().allMatch(deuce);
    }

    public void giveAdvantage(Player player){
        player.getPoints().add(Points.ADVANTAGE);
    }


}
