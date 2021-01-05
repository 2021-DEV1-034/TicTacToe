package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        String[] config = new String[] {"config.xml"};
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        Player player1 = context.getBean("player1", Player.class);
        Player player2 = context.getBean("player2", Player.class);
        Board board = new Board();
        Game game = new Game(player1, player2,board);
        game.startGame();
    }
}
