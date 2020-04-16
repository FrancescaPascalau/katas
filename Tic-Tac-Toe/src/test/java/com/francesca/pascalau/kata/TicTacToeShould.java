package com.francesca.pascalau.kata;

import com.francesca.pascalau.kata.tictactoe.TicTacToe;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class TicTacToeShould {

    private TicTacToe ticTacToe;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public final void before(){
        ticTacToe = new TicTacToe();
    }

    @Test
    public void when_X_outside_the_board_then_throw_RuntimeException(){
        exception.expect(RuntimeException.class);
        ticTacToe.play(5, 2);
    }

    @Test
    public void when_Y_outside_the_board_then_throw_RuntimeException(){
        exception.expect(RuntimeException.class);
        ticTacToe.play(2, 5);
    }

    @Test
    public void when_occupied_then_throw_RuntimeException(){
        ticTacToe.play(2, 1);
        exception.expect(RuntimeException.class);
        ticTacToe.play(2, 1);
    }

    @Test
    public void when_game_starts_first_turn_is_played_by_X(){
        assertEquals('X', ticTacToe.nextPlayer());
    }

    @Test
    public void when_last_player_was_X_next_player_is_Y(){
        ticTacToe.play(1, 1);
        assertEquals('O', ticTacToe.nextPlayer());
    }

    @Test
    public void if_still_playing_then_no_winner(){
        String actual = ticTacToe.play(1, 1);
        assertEquals("No winner", actual);
    }

    @Test
    public void when_play_and_horizontal_line_full_then_win(){
        ticTacToe.play(1, 1); //X
        ticTacToe.play(1, 2); //O
        ticTacToe.play(2, 1); //X
        ticTacToe.play(2, 2); //O
        String actual = ticTacToe.play(3, 1); //X
        assertEquals("X win!", actual);
    }

    @Test
    public void when_play_and_vertical_line_full_then_win(){
        ticTacToe.play(2, 1); //X
        ticTacToe.play(1, 1); //O
        ticTacToe.play(3, 1); //X
        ticTacToe.play(1, 2); //O
        ticTacToe.play(2, 2); //X
        String actual = ticTacToe.play(1, 3); //X
        assertEquals("O win!", actual);
    }

    @Test
    public void when_play_and_topLeft_bottomRight_diagonal_full_then_win(){
        ticTacToe.play(1, 1); //X
        ticTacToe.play(1, 2); //O
        ticTacToe.play(2, 2); //X
        ticTacToe.play(1, 3); //O
        String actual = ticTacToe.play(3, 3); //X
        assertEquals("X win!", actual);
    }

    @Test
    public void when_play_and_bottomLeft_topRight_diagonal_full_then_win(){
        ticTacToe.play(1, 3); //X
        ticTacToe.play(1, 1); //O
        ticTacToe.play(2, 2); //X
        ticTacToe.play(1, 2); //O
        String actual = ticTacToe.play(3, 1); //X
        assertEquals("X win!", actual);
    }

    @Test
    public void when_all_boxes_are_filled_then_draw(){
        ticTacToe.play(1, 1); //X
        ticTacToe.play(1, 2); //O
        ticTacToe.play(1, 3); //X
        ticTacToe.play(2, 1); //O
        ticTacToe.play(2, 3); //X
        ticTacToe.play(2, 2); //O
        ticTacToe.play(3, 1); //X
        ticTacToe.play(3, 3); //O
        String actual = ticTacToe.play(3, 2);
        assertEquals("The result is draw", actual);
    }
}
