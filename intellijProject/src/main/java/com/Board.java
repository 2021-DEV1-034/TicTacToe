package com;

import java.util.Arrays;

public class Board {
    public final int gridHeight = 3;
    public final int gridWidth = 3;
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

}
