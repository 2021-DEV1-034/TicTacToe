package com;

public class Application {

    public static void main(String[] args) {

        Player player1 = new PlayerKeyBoard("player1");
        Player player2 = new PlayerRandom();
        Game game = new Game(player1, player2);
        game.startGame();
    }
}
