package com;

import org.springframework.stereotype.Component;

@Component
public class RoundGenerator {

    public Round generateNextRound(Player player1, Player player2){
        return new Round(player1,player2,new Board());
    }
}
