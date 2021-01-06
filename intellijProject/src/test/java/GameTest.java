import com.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;

public class GameTest {

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void displayScore_00_WhenInitGame() {
        // Arrange
        Player player1 = Mockito.mock(Player.class);
        Player player2 = Mockito.mock(Player.class);
        RoundGenerator roundGenerator = Mockito.mock(RoundGenerator.class);
        Game game = new Game(player1,player2,roundGenerator);


        // Act
        String score = game.displayScore();

        // Assert
        assertEquals("Score :  0/0", score);
    }

    @Test
    public void displayScore_10_WhenPlayer1Win() {
        // Arrange
        Player player1 = Mockito.mock(Player.class);
        Player player2 = Mockito.mock(Player.class);
        RoundGenerator roundGenerator = Mockito.mock(RoundGenerator.class);
        Game game = new Game(player1,player2,roundGenerator);
        Round round =  Mockito.mock(Round.class);
        Mockito.when(round.getWinner()).thenReturn(player1);
        Mockito.when(roundGenerator.generateNextRound(any(Player.class),any(Player.class))).thenReturn(round);
        game.newRound();


        // Act
        String score = game.displayScore();

        // Assert
        assertEquals("Score :  1/0", score);
    }

    @Test
    public void displayScore_01_WhenPlayer2Win() {
        // Arrange
        Player player1 = Mockito.mock(Player.class);
        Player player2 = Mockito.mock(Player.class);
        RoundGenerator roundGenerator = Mockito.mock(RoundGenerator.class);
        Game game = new Game(player1,player2,roundGenerator);
        Round round =  Mockito.mock(Round.class);
        Mockito.when(round.getWinner()).thenReturn(player2);
        Mockito.when(roundGenerator.generateNextRound(player1,player2)).thenReturn(round);
        game.newRound();


        // Act
        String score = game.displayScore();

        // Assert
        assertEquals("Score :  0/1", score);
    }


    @Test
    public void displayScore_11_WhenPlayer12Win() {
        // Arrange
        Player player1 = Mockito.mock(Player.class);
        Player player2 = Mockito.mock(Player.class);
        RoundGenerator roundGenerator = Mockito.mock(RoundGenerator.class);
        Game game = new Game(player1,player2,roundGenerator);
        Round round =  Mockito.mock(Round.class);
        Mockito.when(round.getWinner()).thenReturn(player2);
        Mockito.when(roundGenerator.generateNextRound(player1,player2)).thenReturn(round);
        game.newRound();

        Round round2 =  Mockito.mock(Round.class);
        Mockito.when(round2.getWinner()).thenReturn(player1);
        Mockito.when(roundGenerator.generateNextRound(player1,player2)).thenReturn(round2);
        game.newRound();

        // Act
        String score = game.displayScore();

        // Assert
        assertEquals("Score :  1/1", score);
    }

}
