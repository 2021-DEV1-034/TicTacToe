import com.Board;
import com.Draw;
import com.Player;
import com.Round;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class RoundTest {

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getWinner_X_WhenWinnerX(){
        // Arrange
        Board board = Mockito.mock(Board.class);
        Player player1 = Mockito.mock(Player.class);
        Player player2 = Mockito.mock(Player.class);
        Mockito.when(board.hasWinner()).thenReturn(true);
        Mockito.when(board.getWinner()).thenReturn(Draw.X);
        Round round = new Round(player1,player2,board);
        round.startRound();

        // Act
        Player result = round.getWinner();

        // Assert
        assertEquals(player1, result);
        assertNotEquals(player2, result);
    }

    @Test
    public void getWinner_Null_WhenCompletlyFilled(){
        // Arrange
        Board board = Mockito.mock(Board.class);
        Player player1 = Mockito.mock(Player.class);
        Player player2 = Mockito.mock(Player.class);
        Mockito.when(board.hasWinner()).thenReturn(false);
        Mockito.when(board.isCompletlyFilled()).thenReturn(true);
        Round round = new Round(player1,player2,board);
        round.startRound();

        // Act
        Player result = round.getWinner();

        // Assert
        assertEquals(null, result);
    }


    @Test
    public void getNextPlayer_1_WhenInitRound(){
        // Arrange
        Board board = Mockito.mock(Board.class);
        Player player1 = Mockito.mock(Player.class);
        Player player2 = Mockito.mock(Player.class);
        Round round = new Round(player1,player2,board);

        // Act
        int result = round.getNextPlayer();

        // Assert
        assertEquals(1, result);
    }
}
