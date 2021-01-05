package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Game {

    private Player player1;
    private Player player2;
    private Board board;
    private ArrayList<Round> rounds;

    public Game(Player player1, Player player2, Board board) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        this.rounds = new ArrayList<Round>();
    }

    public void startGame() throws IOException {
        welcomeDisplay();
        do {
            newRound();
            displayScore();
        } while (askNewRound());
    }

    public boolean askNewRound() throws IOException {
        System.out.println("Do you want play again ?[Y/N]");
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        String answer = reader.readLine();
        if (answer.equals("Y")) {
            return true;
        } else if (answer.equals("N")) {
            return false;
        } else {
            return askNewRound();
        }
    }

    public void newRound() {
        Round round = new Round(player1, player2, Board.getInstance());
        this.rounds.add(round);
        round.startRound();
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

    public void displayScore() {
        int player1Score = 0;
        int player2Score = 0;

        for (Round round : this.rounds) {
            Player winner = round.getWinner();
            if (winner == player1) ;
            {
                player1Score++;
            }
            if (winner == player2) {
                player2Score++;
            }
        }
        System.out.println(String.format("Score :  %d/%d", player1Score, player2Score));
    }
}
