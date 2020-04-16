package com.francesca.pascalau.kata;

public class GameOfLife {
    private static final int ROWS = 10;
    private static final int COLUMNS = 10;
    public static int[][] life = new int[ROWS][COLUMNS];
    private static final int DEAD = 0;
    private static final int ALIVE = 1;

    public void initialize(){
        for(int i = 0; i < ROWS; ++i)
            for (int j = 0; j < COLUMNS; ++j)
                life[i][j] = DEAD;
    }

    public void addCell(Cell cell) {
        int X = cell.getX();
        int Y = cell.getY();
        life[X][Y] = ALIVE;
    }

    public Boolean checkNeighboursForCell(Cell cell) {
        int X = cell.getX();
        int Y = cell.getY();
        int count = 0;
        for(int i = X - 2; i < X + 2; i++)
            for (int j = Y - 2; j < Y + 2; j++){
                if (life[i][j] == 1)
                    count++;
            }
        if (count <= 3)
            cell.setState(0);
        return true;
    }
}
