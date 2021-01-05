package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Game {

    private Player player1;
    private Player player2;

    private ArrayList<Round> rounds;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.rounds = new ArrayList<Round>();
    }
    public void startGame()  {
        welcomeDisplay();
    }

    public void welcomeDisplay() {
        System.out.println("Tic Tac Toe");
        System.out.println("-----------------------");
        System.out.println("Players alternate placing X’s and O’s on the board until either:");
        System.out.println("--One player has three in a row, horizontally, vertically or diagonally");
        System.out.println("--All nine squares are filled.");
        System.out.println("If a player is able to draw three X’s or three O’s in a row, that player wins.");
        System.out.println("If all nine squares are filled and neither player has three in a row, the game is a draw.\n");

    }
}
