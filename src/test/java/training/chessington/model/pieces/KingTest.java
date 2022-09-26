package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class KingTest {

    @Test
    public void whiteKingCanMoveOneSquare() {
        //Arrange
        Board board = Board.empty();

        Piece king = new King(PlayerColour.WHITE);
        Coordinates kingCoords = new Coordinates(4, 4);
        board.placePiece(kingCoords, king);

        //Act
        List<Move> kingMoves = king.getAllowedMoves(kingCoords, board);


        //Assert
        assertThat(kingMoves).contains(new Move(kingCoords, kingCoords.plus(1, -1)));
        assertThat(kingMoves).contains(new Move(kingCoords, kingCoords.plus(0, 1)));
        assertThat(kingMoves).contains(new Move(kingCoords, kingCoords.plus(1, 1)));
        assertThat(kingMoves).contains(new Move(kingCoords, kingCoords.plus(-1, -1)));
        assertThat(kingMoves).contains(new Move(kingCoords, kingCoords.plus(-1, 0)));
    }

    @Test
    public void blackKingCanMoveOneSquare() {
        //Arrange
        Board board = Board.empty();

        Piece king = new King(PlayerColour.BLACK);
        Coordinates kingCoords = new Coordinates(4, 4);
        board.placePiece(kingCoords, king);

        //Act
        List<Move> kingMoves = king.getAllowedMoves(kingCoords, board);


        //Assert
        assertThat(kingMoves).contains(new Move(kingCoords, kingCoords.plus(1, -1)));
        assertThat(kingMoves).contains(new Move(kingCoords, kingCoords.plus(0, 1)));
        assertThat(kingMoves).contains(new Move(kingCoords, kingCoords.plus(1, 1)));
        assertThat(kingMoves).contains(new Move(kingCoords, kingCoords.plus(-1, -1)));
        assertThat(kingMoves).contains(new Move(kingCoords, kingCoords.plus(-1, 0)));
    }

    @Test
    public void whiteKingCanCapturePieces() {
        //Arrange
        Board board = Board.empty();

        Piece king = new King(PlayerColour.WHITE);
        Coordinates kingCoords = new Coordinates(4, 4);
        board.placePiece(kingCoords, king);

        Piece pawn = new Pawn(PlayerColour.BLACK);
        Coordinates pawnCoords = new Coordinates(3, 4);
        board.placePiece(pawnCoords, pawn);
        Piece pawn2 = new Pawn(PlayerColour.BLACK);
        Coordinates pawn2Coords = new Coordinates(4, 5);
        board.placePiece(pawn2Coords, pawn2);

        //Act
        List<Move> kingMoves = king.getAllowedMoves(kingCoords, board);


        //Assert
        assertThat(kingMoves).contains(new Move(kingCoords, pawnCoords));
        assertThat(kingMoves).contains(new Move(kingCoords, pawn2Coords));
    }

    @Test
    public void blackKingCanCapturePieces() {
        //Arrange
        Board board = Board.empty();

        Piece king = new King(PlayerColour.BLACK);
        Coordinates kingCoords = new Coordinates(4, 4);
        board.placePiece(kingCoords, king);

        Piece pawn = new Pawn(PlayerColour.WHITE);
        Coordinates pawnCoords = new Coordinates(3, 4);
        board.placePiece(pawnCoords, pawn);
        Piece pawn2 = new Pawn(PlayerColour.WHITE);
        Coordinates pawn2Coords = new Coordinates(4, 5);
        board.placePiece(pawn2Coords, pawn2);

        //Act
        List<Move> kingMoves = king.getAllowedMoves(kingCoords, board);


        //Assert
        assertThat(kingMoves).contains(new Move(kingCoords, pawnCoords));
        assertThat(kingMoves).contains(new Move(kingCoords, pawn2Coords));
    }

    @Test
    public void whiteKingCantCaptureOwnPieces() {
        //Arrange
        Board board = Board.empty();

        Piece king = new King(PlayerColour.WHITE);
        Coordinates kingCoords = new Coordinates(4, 4);
        board.placePiece(kingCoords, king);

        Piece pawn = new Pawn(PlayerColour.WHITE);
        Coordinates pawnCoords = new Coordinates(3, 4);
        board.placePiece(pawnCoords, pawn);
        Piece pawn2 = new Pawn(PlayerColour.WHITE);
        Coordinates pawn2Coords = new Coordinates(4, 5);
        board.placePiece(pawn2Coords, pawn2);

        //Act
        List<Move> kingMoves = king.getAllowedMoves(kingCoords, board);


        //Assert
        assertThat(kingMoves).doesNotContain(new Move(kingCoords, pawnCoords));
        assertThat(kingMoves).doesNotContain(new Move(kingCoords, pawn2Coords));
    }

    @Test
    public void blackKingCantCaptureOwnPieces() {
        //Arrange
        Board board = Board.empty();

        Piece king = new King(PlayerColour.BLACK);
        Coordinates kingCoords = new Coordinates(4, 4);
        board.placePiece(kingCoords, king);

        Piece pawn = new Pawn(PlayerColour.BLACK);
        Coordinates pawnCoords = new Coordinates(3, 4);
        board.placePiece(pawnCoords, pawn);
        Piece pawn2 = new Pawn(PlayerColour.BLACK);
        Coordinates pawn2Coords = new Coordinates(4, 5);
        board.placePiece(pawn2Coords, pawn2);

        //Act
        List<Move> kingMoves = king.getAllowedMoves(kingCoords, board);


        //Assert
        assertThat(kingMoves).doesNotContain(new Move(kingCoords, pawnCoords));
        assertThat(kingMoves).doesNotContain(new Move(kingCoords, pawn2Coords));
    }

    @Test
    public void whiteKingCanCastle() {
        //Arrange
        //Act
        //Assert
    }

    @Test
    public void blackKingCanCastle() {
        //Arrange
        //Act
        //Assert
    }

    @Test
    public void whiteKingCantCastleIfKingHasMoved() {
        //Arrange
        //Act
        //Assert
    }

    @Test
    public void blackKingCantCastleIfKingHasMoved() {
        //Arrange
        //Act
        //Assert
    }

    @Test
    public void whiteKingCantMoveIntoCheck() {
        //Arrange
        //Act
        //Assert
    }

    @Test
    public void blackKingCantMoveIntoCheck() {
        //Arrange
        //Act
        //Assert
    }

    @Test
    public void kingCantMoveOffTopOfBoard() {
        //Arrange
        Board board = Board.empty();

        Piece king = new King(PlayerColour.WHITE);
        Coordinates kingCoords = new Coordinates(0, 0);
        board.placePiece(kingCoords, king);

        //Act
        List<Move> kingMoves = king.getAllowedMoves(kingCoords, board);


        //Assert
        assertThat(kingMoves.size() == 3);
    }

    @Test
    public void kingCantMoveOffBottomOfBoard() {
        //Arrange
        Board board = Board.empty();

        Piece king = new King(PlayerColour.BLACK);
        Coordinates kingCoords = new Coordinates(7, 7);
        board.placePiece(kingCoords, king);

        //Act
        List<Move> kingMoves = king.getAllowedMoves(kingCoords, board);


        //Assert
        assertThat(kingMoves.size() == 3);
    }
}
