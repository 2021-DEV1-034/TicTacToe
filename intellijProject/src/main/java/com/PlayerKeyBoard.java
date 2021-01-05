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
    public Position Play(Board board) {
        return null;
    }

}
