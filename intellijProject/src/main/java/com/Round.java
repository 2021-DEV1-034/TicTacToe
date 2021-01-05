package com;

public class Round {

    private Board board;
    private Player winner;
    private Player player1;
    private Player player2;

    private int nextPlayer;

    public Round(Player player1, Player player2, Board board) {
        this.board = board;
        nextPlayer = 1;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void startRound() {
        this.board.displayGrid();
        while (!hasWinner() && !isCompletlyFilled()) {
            playNextPlayer();
            this.board.displayGrid();
        }
        if (hasWinner()) {
            defineWinner();
        }
    }

    private void defineWinner() {
        Draw draw = this.board.getWinner();
        if (draw == Draw.X) {
            this.winner = player1;
        } else {
            this.winner = player2;
        }
    }

    private void playNextPlayer() {
        if (getNextPlayer() == 1) {
            Position position = player1.play(this.board);
            this.board.draw(position, Draw.X);
            setNextPlayer(2);
            return;
        } else if (getNextPlayer() == 2) {
            Position position = player2.play(this.board);
            this.board.draw(position, Draw.O);
            setNextPlayer(1);
            return;
        }
    }

    private boolean hasWinner() {
        return this.board.hasWinner();
    }

    private boolean isCompletlyFilled() {
        return this.board.isCompletlyFilled();
    }

    public Player getWinner() {
        return winner;
    }

    public int getNextPlayer() {
        return nextPlayer;
    }

    public void setNextPlayer(int nextPlayer) {
        this.nextPlayer = nextPlayer;
    }
}
