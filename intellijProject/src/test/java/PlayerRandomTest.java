import com.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;

public class PlayerRandomTest {


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void play_ValidePosition_WhenBoardEmpty(){
        // Arrange
        Board board = Mockito.mock(Board.class);
        Mockito.when(board.isEmpty(any(Position.class))).thenReturn(true);
        Mockito.when(board.getNumberEmptyCell()).thenReturn(9);

        PlayerRandom playerRandom = new PlayerRandom();

        // Act
        Position result = playerRandom.play(board);

        // Assert
        assertTrue( result.getX()<= 2 && result.getX()>=0);
        assertTrue( result.getY()<= 2 && result.getY()>=0);

    }

}
