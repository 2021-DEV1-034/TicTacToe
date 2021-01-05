package com;

import java.util.Arrays;

public class Board {
    public static final int gridHeight = 3;
    public static final int gridWidth = 3;
    private int numberEmptyCell;
    private Draw[][] grid;

    public Board() {
        initEmptyGrid();
        numberEmptyCell = gridHeight * gridWidth;
    }

    private void initEmptyGrid() {
        this.grid = new Draw[gridHeight][gridWidth];
        for (Draw[] row : this.grid)
            Arrays.fill(row, Draw.Empty);
    }

    public int getNumberEmptyCell() {
        return numberEmptyCell;
    }


    public String displayGrid() {

        StringBuilder displyedGrid = new StringBuilder();
        displyedGrid.append(" -----\n");

        for (Draw[] row : this.grid) {
            displyedGrid.append("|");
            for (Draw cell : row) {
                displyedGrid.append(cell);
                displyedGrid.append("|");
            }
            displyedGrid.append("\n");
            displyedGrid.append(" -----\n");
        }
        System.out.println( displyedGrid.toString());
        return displyedGrid.toString();
    }

    public boolean draw(Position position, Draw draw) {
        if (isValidePlay(position) && draw != Draw.Empty) {
            this.grid[position.getX()][position.getY()] = draw;
            numberEmptyCell--;
            return true;
        }
        return false;
    }

    private boolean isValidePlay(Position position) {
        return isInGrid(position) && isEmpty(position);
    }

    private boolean isInGrid(Position position) {
        return position.getX() >= 0 && position.getY() >= 0 && position.getY() < gridHeight && position.getX() < gridWidth;
    }

    public boolean isEmpty(Position position) {
        return this.grid[position.getX()][position.getY()] == Draw.Empty;
    }

    public boolean isCompletlyFilled() {
        for (Draw[] row : this.grid) {
            for (Draw cell : row) {
                if (cell == Draw.Empty) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasWinner() {
        return
                hasRowVerticallyWinner(Draw.O) ||
                        hasRowVerticallyWinner(Draw.X) ||
                        hasRowHorizontallyWinner(Draw.O) ||
                        hasRowHorizontallyWinner(Draw.X) ||
                        hasRowDiagonallyWinner(Draw.X) ||
                        hasRowDiagonallyWinner(Draw.O);

    }
    public Draw getWinner(){
        if(hasRowVerticallyWinner(Draw.O) || hasRowHorizontallyWinner(Draw.O) ||hasRowDiagonallyWinner(Draw.O)){
            return Draw.O;
        }
        else if(hasRowVerticallyWinner(Draw.X) || hasRowHorizontallyWinner(Draw.X) ||hasRowDiagonallyWinner(Draw.X)){
            return Draw.X;
        }
        else{
            return null;
        }
    }

    private boolean hasRowVerticallyWinner(Draw draw) {
        int column = 0;
        while (column < gridWidth) {
            int row = 0;
            boolean rowOk = true;
            while (row < gridHeight) {
                if (this.grid[row][column] != draw) {
                    rowOk = false;
                }
                row++;
            }
            if (rowOk) {
                return true;
            }
            column++;

        }
        return false;
    }

    private boolean hasRowHorizontallyWinner(Draw draw) {
        for (Draw[] row : this.grid) {
            if (row[0] == draw && row[1] == draw && row[2] == draw) {
                return true;
            }
        }
        return false;
    }

    private boolean hasRowDiagonallyWinner(Draw draw) {
        return (this.grid[0][0] == draw && this.grid[1][1] == draw && this.grid[2][2] == draw) ||
                (this.grid[2][0] == draw && this.grid[1][1] == draw && this.grid[0][2] == draw);
    }
    public static Board getInstance(){
        return new Board();
    }
}
