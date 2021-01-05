
import com.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {


    @Test
    public void getNumberEmptyCell_9_WhenInitBoard(){
        // Arrange
        Board board = new Board();

        // Act
        int numberEmptyCell = board.getNumberEmptyCell();

        // Assert
        assertEquals(9, numberEmptyCell);
    }

    @Test
    public void displayGrid_ValideGrid_WhenInitBoard(){
        // Arrange
        Board board = new Board();

        // Act
        String displayedGrid = board.displayGrid();

        // Assert
        assertEquals(" -----\n" +
                "| | | |\n" +
                " -----\n" +
                "| | | |\n" +
                " -----\n" +
                "| | | |\n" +
                " -----\n", displayedGrid);
    }

}
