
import com.Board;
import com.Draw;
import com.Position;
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
    @Test
    public void draw_NotDraw_WhenOutofGrid(){
        // Arrange
        Board board = new Board();
        Position positionNegatif = new Position(-1,-1);
        Position positionTooBig = new Position(3,3);

        // Act
        boolean positionNegatifResult = board.draw(positionNegatif, Draw.O);
        boolean positionTooBigResult = board.draw(positionTooBig, Draw.X);

        //Assert
        assertEquals(false , positionNegatifResult);
        assertEquals(false , positionTooBigResult);

    }

    @Test
    public void draw_Draw_WhenValidePosition(){
        // Arrange
        Board board = new Board();
        Position positionCenter = new Position(1,1);
        Position positionCorner = new Position(0,0);

        // Act
        boolean positionCenterResult = board.draw(positionCenter, Draw.O);
        boolean positionCornerResult = board.draw(positionCorner, Draw.X);

        //Assert
        assertEquals(true , positionCenterResult);
        assertEquals(true , positionCornerResult);

    }


    @Test
    public void draw_NotDraw_WhenPositionNotEmpty(){
        // Arrange
        Board board = new Board();
        Position positionCenter = new Position(1,1);

        // Act
        boolean positionCenterResult1 = board.draw(positionCenter, Draw.O);
        boolean positionCenterResult2 = board.draw(positionCenter, Draw.X);

        //Assert
        assertEquals(true , positionCenterResult1);
        assertEquals(false , positionCenterResult2);

    }

    @Test
    public void draw_NotDraw_WhenDrawIsEmpty(){
        // Arrange
        Board board = new Board();
        Position positionCenter = new Position(1,1);

        // Act
        boolean positionCenterResult = board.draw(positionCenter, Draw.Empty);

        //Assert
        assertEquals(false , positionCenterResult);

    }
}
