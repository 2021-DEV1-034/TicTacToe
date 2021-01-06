package com;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PlayerRandom implements Player {

    public Position play(Board board) {
        Random rand = new Random();
        int intRand = rand.nextInt(board.getNumberEmptyCell()) + 1;
        int column = 0;
        int empty = 0;
        while (column < Board.gridWidth) {
            int row = 0;
            while (row < Board.gridHeight) {
                Position position = new Position(column, row);
                if (board.isEmpty(position)) {
                    empty++;
                }
                if (intRand == empty) {
                    return position;
                }
                row++;
            }
            column++;

        }
        return null;
    }
}
