package com.francesca.pascalau.kata.tictactoe;

public class TicTacToe {

    private char[][] board = new char[3][3];
    private char lastPlayer = '\0';
    private static final int SIZE = 3;

    public String play(int x, int y) {
        checkAxis(x);
        checkAxis(y);
        lastPlayer = nextPlayer();
        setBox(x, y, lastPlayer);
        if (playerWin(x, y))
            return lastPlayer + " win!";
        else if (isDraw())
            return "The result is draw";
        return "No winner";
    }

    private boolean isDraw() {
        for(int x = 0; x < SIZE; x++)
            for(int y = 0; y < SIZE; y++){
                if(board[x][y] == '\0')
                    return false;
            }
        return true;
    }

    private boolean playerWin(int x, int y) {
        int playerTotal = lastPlayer * SIZE;
        char horizontal, vertical, diagonal1, diagonal2;
        horizontal = vertical = diagonal1 = diagonal2 = '\0';
        for(int i = 0; i < SIZE; i++){
            horizontal += board[i][y - 1];
            vertical += board[x - 1][i];
            diagonal1 += board[i][i];
            diagonal2 += board[i][SIZE - i - 1];
        }
        if (horizontal == playerTotal
                || vertical == playerTotal
                ||diagonal1 == playerTotal
                || diagonal2 == playerTotal){
            return true;
        }
        return false;
    }

    private void checkAxis(int axis) {
        if (axis < 1 || axis > 3)
            throw new RuntimeException("Character is outside the board");
    }

    private void setBox(int x, int y, char lastPlayer) {
        if (board[x - 1][y - 1] != '\0')
            throw new RuntimeException("Box is occupied");
        else
            board[x - 1][y - 1] = lastPlayer;
    }

    public char nextPlayer() {
        if (lastPlayer == 'X')
            return 'O';
        return 'X';
    }
}