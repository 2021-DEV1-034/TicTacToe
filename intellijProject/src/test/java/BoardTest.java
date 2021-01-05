
import com.Board;
import com.Draw;
import com.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    @Test
    public void getNumberEmptyCell_9_WhenInitBoard() {
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

    @Test
    public void isCompletlyFilled_No_WhenInitBoard(){
        // Arrange
        Board board = new Board();

        // Act
        boolean result = board.isCompletlyFilled();

        //Assert
        assertEquals(false , result);
    }


    @Test
    public void isCompletlyFilled_No_WhenDrawX(){
        // Arrange
        Board board = new Board();
        Position positionCenter = new Position(1,1);
        boolean positionCenterResult = board.draw(positionCenter, Draw.X);

        // Act
        boolean result = board.isCompletlyFilled();

        //Assert
        assertEquals(false , result);
    }

    @Test
    public void isCompletlyFilled_Yes_WhenDrawAllX(){
        // Arrange
        Board board = new Board();
        board.draw(new Position(0,0), Draw.X);
        board.draw(new Position(0,1), Draw.X);
        board.draw(new Position(0,2), Draw.X);
        board.draw(new Position(1,0), Draw.X);
        board.draw(new Position(1,1), Draw.X);
        board.draw(new Position(1,2), Draw.X);
        board.draw(new Position(2,0), Draw.X);
        board.draw(new Position(2,1), Draw.X);
        board.draw(new Position(2,2), Draw.X);

        // Act
        boolean result = board.isCompletlyFilled();

        //Assert
        assertEquals(true , result);
    }

    @Test
    public void hasWinner_No_WhenInitBoard(){
        // Arrange
        Board board = new Board();

        // Act
        boolean result = board.hasWinner();

        //Assert
        assertEquals(false , result);
    }

    @Test
    public void hasWinner_Yes_WhenWinnerXHorizontal(){
        // Arrange
        Board board = new Board();
        board.draw(new Position(0,0), Draw.X);
        board.draw(new Position(1,0), Draw.X);
        board.draw(new Position(2,0), Draw.X);

        // Act
        boolean result = board.hasWinner();

        //Assert
        assertEquals(true , result);
    }

    @Test
    public void hasWinner_Yes_WhenWinnerOVertical(){
        // Arrange
        Board board = new Board();
        board.draw(new Position(0,0), Draw.O);
        board.draw(new Position(0,1), Draw.O);
        board.draw(new Position(0,2), Draw.O);

        // Act
        boolean result = board.hasWinner();

        //Assert
        assertEquals(true , result);
    }

    @Test
    public void hasWinner_Yes_WhenWinnerODiagonal(){
        // Arrange
        Board board = new Board();
        board.draw(new Position(0,0), Draw.O);
        board.draw(new Position(1,1), Draw.O);
        board.draw(new Position(2,2), Draw.O);

        // Act
        boolean result = board.hasWinner();

        //Assert
        assertEquals(true , result);
    }

    @Test
    public void getWinner_X_WhenWinnerXDiagonal(){
        // Arrange
        Board board = new Board();
        board.draw(new Position(0,0), Draw.X);
        board.draw(new Position(1,1), Draw.X);
        board.draw(new Position(2,2), Draw.X);

        // Act
        Draw result = board.getWinner();

        //Assert
        assertEquals(Draw.X , result);
    }

    @Test
    public void getWinner_O_WhenWinnerODiagonal(){
        // Arrange
        Board board = new Board();
        board.draw(new Position(0,0), Draw.O);
        board.draw(new Position(1,1), Draw.O);
        board.draw(new Position(2,2), Draw.O);

        // Act
        Draw result = board.getWinner();

        //Assert
        assertEquals(Draw.O , result);
    }

    @Test
    public void getWinner_Null_WhenNoWinner(){
        // Arrange
        Board board = new Board();

        // Act
        Draw result = board.getWinner();

        //Assert
        assertEquals(null , result);
    }
}
