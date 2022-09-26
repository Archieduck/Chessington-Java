package training.chessington.model.pieces;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

public class KnightTest {

    @Test
    public void whiteKnightMovesToCorrectSquares() {
        //Arrange
        Board board = Board.empty();

        Piece knight = new Knight(PlayerColour.WHITE);
        Coordinates knightCoords = new Coordinates(3, 3);
        board.placePiece(knightCoords, knight);

        //Act
        List<Move> knightMoves = knight.getAllowedMoves(knightCoords, board);


        //Assert
        assertThat(knightMoves).contains(new Move(knightCoords, knightCoords.plus(1, 2)));
        assertThat(knightMoves).contains(new Move(knightCoords, knightCoords.plus(-1, -2)));
        assertThat(knightMoves).contains(new Move(knightCoords, knightCoords.plus(-2, -1)));
        assertThat(knightMoves).contains(new Move(knightCoords, knightCoords.plus(2, 1)));
    }

    @Test
    public void blackKnightMovesToCorrectSquares() {
        //Arrange
        Board board = Board.empty();

        Piece knight = new Knight(PlayerColour.BLACK);
        Coordinates knightCoords = new Coordinates(3, 3);
        board.placePiece(knightCoords, knight);

        //Act
        List<Move> knightMoves = knight.getAllowedMoves(knightCoords, board);


        //Assert
        assertThat(knightMoves).contains(new Move(knightCoords, knightCoords.plus(1, 2)));
        assertThat(knightMoves).contains(new Move(knightCoords, knightCoords.plus(-1, -2)));
        assertThat(knightMoves).contains(new Move(knightCoords, knightCoords.plus(-2, -1)));
        assertThat(knightMoves).contains(new Move(knightCoords, knightCoords.plus(2, 1)));
    }
    @Test
    public void whiteKnightCanCapturePieces() {
        //Arrange
        Board board = Board.empty();

        Piece knight = new Knight(PlayerColour.WHITE);
        Coordinates knightCoords = new Coordinates(3, 3);
        board.placePiece(knightCoords, knight);
        Piece knight2 = new Knight(PlayerColour.BLACK);
        Coordinates knight2Coords = new Coordinates(1, 2);
        board.placePiece(knight2Coords, knight2);
        Piece knight3 = new Knight(PlayerColour.BLACK);
        Coordinates knight3Coords = new Coordinates(4, 5);
        board.placePiece(knight3Coords, knight3);

        //Act
        List<Move> knightMoves = knight.getAllowedMoves(knightCoords, board);

        //Assert
        assertThat(knightMoves).contains(new Move(knightCoords, knight2Coords));
        assertThat(knightMoves).contains(new Move(knightCoords, knight3Coords));
    }

    @Test
    public void blackKnightCanCapturePieces() {
        //Arrange
        Board board = Board.empty();

        Piece knight = new Knight(PlayerColour.BLACK);
        Coordinates knightCoords = new Coordinates(3, 3);
        board.placePiece(knightCoords, knight);
        Piece knight2 = new Knight(PlayerColour.WHITE);
        Coordinates knight2Coords = new Coordinates(1, 2);
        board.placePiece(knight2Coords, knight2);
        Piece knight3 = new Knight(PlayerColour.WHITE);
        Coordinates knight3Coords = new Coordinates(4, 5);
        board.placePiece(knight3Coords, knight3);

        //Act
        List<Move> knightMoves = knight.getAllowedMoves(knightCoords, board);


        //Assert
        assertThat(knightMoves).contains(new Move(knightCoords, knight2Coords));
        assertThat(knightMoves).contains(new Move(knightCoords, knight3Coords));
    }

    @Test
    public void whiteKnightCantCaptureOwnPieces() {
        //Arrange
        Board board = Board.empty();

        Piece knight = new Knight(PlayerColour.WHITE);
        Coordinates knightCoords = new Coordinates(3, 3);
        board.placePiece(knightCoords, knight);
        Piece knight2 = new Knight(PlayerColour.WHITE);
        Coordinates knight2Coords = new Coordinates(1, 2);
        board.placePiece(knight2Coords, knight2);
        Piece knight3 = new Knight(PlayerColour.WHITE);
        Coordinates knight3Coords = new Coordinates(4, 5);
        board.placePiece(knight3Coords, knight3);

        //Act
        List<Move> knightMoves = knight.getAllowedMoves(knightCoords, board);


        //Assert
        assertThat(knightMoves).doesNotContain(new Move(knightCoords, knight2Coords));
        assertThat(knightMoves).doesNotContain(new Move(knightCoords, knight3Coords));
    }

    @Test
    public void blackKnightCantCaptureOwnPieces() {
        //Arrange
        Board board = Board.empty();

        Piece knight = new Knight(PlayerColour.BLACK);
        Coordinates knightCoords = new Coordinates(3, 3);
        board.placePiece(knightCoords, knight);
        Piece knight2 = new Knight(PlayerColour.BLACK);
        Coordinates knight2Coords = new Coordinates(1, 2);
        board.placePiece(knight2Coords, knight2);
        Piece knight3 = new Knight(PlayerColour.BLACK);
        Coordinates knight3Coords = new Coordinates(4, 5);
        board.placePiece(knight3Coords, knight3);

        //Act
        List<Move> knightMoves = knight.getAllowedMoves(knightCoords, board);


        //Assert
        assertThat(knightMoves).doesNotContain(new Move(knightCoords, knight2Coords));
        assertThat(knightMoves).doesNotContain(new Move(knightCoords, knight3Coords));
    }

    @Test
    public void whiteKnightCantMoveOffBoard() { // has to pass cannot take own pieces
        //Arrange
        Board board = Board.empty();

        Piece knight = new Knight(PlayerColour.WHITE);
        Coordinates knightCoords = new Coordinates(0, 0);
        board.placePiece(knightCoords, knight);
        Piece knight2 = new Knight(PlayerColour.WHITE);
        Coordinates knight2Coords = new Coordinates(1, 2);
        board.placePiece(knight2Coords, knight2);
        Piece knight3 = new Knight(PlayerColour.WHITE);
        Coordinates knight3Coords = new Coordinates(2, 1);
        board.placePiece(knight3Coords, knight3);

        //Act
        List<Move> knightMoves = knight.getAllowedMoves(knightCoords, board);


        //Assert
        assertThat(knightMoves).isEmpty();
    }

    @Test
    public void blackKnightCantMoveOffBoard() {
        //Arrange
        Board board = Board.empty();

        Piece knight = new Knight(PlayerColour.BLACK);
        Coordinates knightCoords = new Coordinates(0, 0);
        board.placePiece(knightCoords, knight);
        Piece knight2 = new Knight(PlayerColour.BLACK);
        Coordinates knight2Coords = new Coordinates(1, 2);
        board.placePiece(knight2Coords, knight2);
        Piece knight3 = new Knight(PlayerColour.BLACK);
        Coordinates knight3Coords = new Coordinates(2, 1);
        board.placePiece(knight3Coords, knight3);

        //Act
        List<Move> knightMoves = knight.getAllowedMoves(knightCoords, board);


        //Assert
        assertThat(knightMoves).isEmpty();
    }

}
