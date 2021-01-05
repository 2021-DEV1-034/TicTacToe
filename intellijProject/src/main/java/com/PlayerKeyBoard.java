package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlayerKeyBoard implements Player {

    public PlayerKeyBoard(String playerName) {
        this.playerName = playerName;
    }

    private String playerName;

    public String getPlayerName() {
        return playerName;
    }


    @Override
    public Position play(Board board) {

        return askPosition(board);
    }

    public Position askPosition(Board board) {
        boolean notValideInput = true;
        Position positionResult = null;
        while (notValideInput) {
            try {
                System.out.println("Enter correct position. x,y are between 0 and 2 : (ex: 1,2)");
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(System.in));
                String position = reader.readLine();
                String[] positionXY = position.split(",");
                int x = Integer.parseInt(positionXY[0]);
                int y = Integer.parseInt((positionXY[1]));
                positionResult = new Position(x, y);
                if (x >= 0 && x <= 2 && y >= 0 && y <= 2 && board.isEmpty(positionResult)) {
                    notValideInput = false;
                }

            } catch (IOException e) {
            } catch (NumberFormatException e) {
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
        return positionResult;
    }
}
