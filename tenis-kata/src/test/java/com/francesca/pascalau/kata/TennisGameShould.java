package com.francesca.pascalau.kata;

import com.francesca.pascalau.Player;
import com.francesca.pascalau.TennisGame;
import org.junit.Before;
import org.junit.Test;


import static com.francesca.pascalau.Points.ADVANTAGE;
import static org.junit.Assert.assertTrue;

public class TennisGameShould {

    private static TennisGame game;
    private static Player PLAYER1 = new Player("Sam");
    private static Player PLAYER2 = new Player("Abby");

    @Before
    public void before() {
        game = new TennisGame();
    }

    @Test
    public void
    be_over_when_first_player_has_all_4_points() {
        winRows(4, PLAYER1);
        PLAYER1.winGame();
    }

    @Test
    public void
    be_over_if_one_of_the_players_have_40_points() {
        PLAYER2.winBall();
        PLAYER1.winBall();
        PLAYER2.winBall();
        PLAYER1.winBall();
        PLAYER2.winBall();
        PLAYER2.winBall();
        PLAYER2.winGame();
    }

    @Test
    public void
    be_on_deuce_if_both_players_have_40_points() {
        winRows(4, PLAYER1);
        winRows(4, PLAYER2);
        assertTrue(game.onDeuce());
    }

    @Test
    public void
    give_advantage_to_the_winner_of_ball_after_deuce() {
        winRows(4, PLAYER1);
        winRows(4, PLAYER2);
        assertTrue(game.onDeuce());
        PLAYER1.winBall();
        game.giveAdvantage(PLAYER1);
        assertTrue(PLAYER1.getPoints().contains(ADVANTAGE));
    }

    @Test
    public void
    be_over_after_player_with_advantage_wins_the_ball() {
        winRows(4, PLAYER1);
        winRows(4, PLAYER2);
        assertTrue(game.onDeuce());
        PLAYER1.winBall();
        game.giveAdvantage(PLAYER1);
        assertTrue(PLAYER1.getPoints().contains(ADVANTAGE));
        PLAYER1.winBall();
        PLAYER1.winGame();
    }

    @Test
    public void
    continue_with_deuce_if_the_player_without_advantage_wins_the_ball() {
        winRows(4, PLAYER1);
        winRows(4, PLAYER2);
        assertTrue(game.onDeuce());
        PLAYER1.winBall();
        game.giveAdvantage(PLAYER1);
        assertTrue(PLAYER1.getPoints().contains(ADVANTAGE));
        PLAYER2.winBall();
        assertTrue(game.onDeuce());
    }

    private void winRows(int rows, Player player) {
        for (int index = 0; index < rows; index++)
            player.winBall();
    }
}
