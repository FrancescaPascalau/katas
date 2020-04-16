package com.francesca.pascalau;

import com.francesca.pascalau.kata.Cell;
import com.francesca.pascalau.kata.GameOfLife;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameOfLifeShould {
    private static GameOfLife game;

    @BeforeClass
    public static void before(){
        game = new GameOfLife();
        game.initialize();
    }

    @Test
    public void create_live_cell(){
        game.addCell(Cell.builder()
                .X(2)
                .Y(2)
                .build());
        assertEquals(GameOfLife.life[2][2], 1);
    }

    @Test
    public void create_neighbours_for_alive_cell(){
        game.addCell(Cell.builder()
                .X(2)
                .Y(3)
                .build());

        game.addCell(Cell.builder()
                .X(3)
                .Y(3)
                .build());

        assertEquals(GameOfLife.life[2][2], 1);
        assertEquals(GameOfLife.life[2][3], 1);
        assertEquals(GameOfLife.life[3][3], 1);
    }

    @Test
    public void die_if_it_has_less_than_two_neighbours(){
        game.checkNeighboursForCell(Cell.builder()
                .X(2)
                .Y(2)
                .build());
        assertEquals(GameOfLife.life[2][2], 1);
    }


}
