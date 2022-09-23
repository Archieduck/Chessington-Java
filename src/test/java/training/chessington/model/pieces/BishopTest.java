package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class BishopTest {

    @Test
    public void whiteBishopCanMoveAlongDiagonal() {
        //Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, bishop);

        //Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);

        //Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(3, -3)));
        assertThat(moves).contains(new Move(coords, coords.plus(3, 2)));
        assertThat(moves).contains(new Move(coords, coords.plus(1, -3)));
    }

    @Test
    public void blackBishopCanMoveAlongDiagonal() {
        //Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, bishop);

        //Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);

        //Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(3, -3)));
        assertThat(moves).contains(new Move(coords, coords.plus(3, 2)));
        assertThat(moves).contains(new Move(coords, coords.plus(1, -3)));
    }

    @Test
    public void whiteBishopCanCapturePieces() {
        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(PlayerColour.WHITE);
        Piece enemyPiece = new Rook(PlayerColour.BLACK);
        Coordinates pawnCoords = new Coordinates(4, 4);
        board.placePiece(pawnCoords, bishop);

        Coordinates enemyCoords = pawnCoords.plus(-2, 2);
        board.placePiece(enemyCoords, enemyPiece);

        // Act
        List<Move> moves = bishop.getAllowedMoves(pawnCoords, board);

        // Assert
        assertThat(moves).contains(new Move(pawnCoords, enemyCoords));
    }

    @Test
    public void blackBishopCanCapturePieces() {
        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(PlayerColour.BLACK);
        Piece enemyPiece = new Rook(PlayerColour.WHITE);
        Coordinates pawnCoords = new Coordinates(4, 4);
        board.placePiece(pawnCoords, bishop);

        Coordinates enemyCoords = pawnCoords.plus(-2, 2);
        board.placePiece(enemyCoords, enemyPiece);

        // Act
        List<Move> moves = bishop.getAllowedMoves(pawnCoords, board);

        // Assert
        assertThat(moves).contains(new Move(pawnCoords, enemyCoords));
    }

    @Test
    public void whiteBishopCantCaptureOwnPieces() {
        //Arrange
        Board board = Board.empty();

        Piece bishop = new Bishop(PlayerColour.WHITE);
        Coordinates bishopCoords = new Coordinates(3, 4);
        board.placePiece(bishopCoords, bishop);

        Piece pawn1 = new Pawn(PlayerColour.WHITE);
        Coordinates pawn1Coords = new Coordinates(2, 3);
        board.placePiece(pawn1Coords, pawn1);
        Piece pawn2 = new Pawn(PlayerColour.WHITE);
        Coordinates pawn2Coords = new Coordinates(2, 5);
        board.placePiece(pawn2Coords, pawn2);
        Piece pawn3 = new Pawn(PlayerColour.WHITE);
        Coordinates pawn3Coords = new Coordinates(4, 3);
        board.placePiece(pawn3Coords, pawn3);
        Piece pawn4 = new Pawn(PlayerColour.WHITE);
        Coordinates pawn4Coords = new Coordinates(4, 5);
        board.placePiece(pawn4Coords, pawn4);


        // Act
        List<Move> bishopMoves = bishop.getAllowedMoves(bishopCoords, board);

        // Assert
        assertThat(bishopMoves).isEmpty();
    }

    @Test
    public void blackBishopCantCaptureOwnPieces() {
        //Arrange
        Board board = Board.empty();

        Piece bishop = new Bishop(PlayerColour.BLACK);
        Coordinates bishopCoords = new Coordinates(3, 4);
        board.placePiece(bishopCoords, bishop);

        Piece pawn1 = new Pawn(PlayerColour.BLACK);
        Coordinates pawn1Coords = new Coordinates(2, 3);
        board.placePiece(pawn1Coords, pawn1);
        Piece pawn2 = new Pawn(PlayerColour.BLACK);
        Coordinates pawn2Coords = new Coordinates(2, 5);
        board.placePiece(pawn2Coords, pawn2);
        Piece pawn3 = new Pawn(PlayerColour.BLACK);
        Coordinates pawn3Coords = new Coordinates(4, 3);
        board.placePiece(pawn3Coords, pawn3);
        Piece pawn4 = new Pawn(PlayerColour.BLACK);
        Coordinates pawn4Coords = new Coordinates(4, 5);
        board.placePiece(pawn4Coords, pawn4);


        // Act
        List<Move> bishopMoves = bishop.getAllowedMoves(bishopCoords, board);

        // Assert
        assertThat(bishopMoves).isEmpty();
    }

    @Test
    public void whiteBishopCantGoThroughPieces() {
        //Arrange
        Board board = Board.empty();

        Piece bishop = new Bishop(PlayerColour.WHITE);
        Coordinates bishopCoords = new Coordinates(3, 4);
        board.placePiece(bishopCoords, bishop);

        Piece pawn1 = new Pawn(PlayerColour.WHITE);
        Coordinates pawn1Coords = new Coordinates(2, 3);
        board.placePiece(pawn1Coords, pawn1);
        Piece pawn2 = new Pawn(PlayerColour.BLACK);
        Coordinates pawn2Coords = new Coordinates(2, 5);
        board.placePiece(pawn2Coords, pawn2);

        //Act
        List<Move> bishopMoves = bishop.getAllowedMoves(bishopCoords, board);


        //Assert
        assertThat(bishopMoves).doesNotContain(new Move(bishopCoords, pawn1Coords.plus(-2, -2)));
        assertThat(bishopMoves).doesNotContain(new Move(bishopCoords, pawn2Coords.plus(-1, 1)));
    }

    @Test
    public void blackBishopCantGoThroughPieces() {
        //Arrange
        Board board = Board.empty();

        Piece bishop = new Bishop(PlayerColour.BLACK);
        Coordinates bishopCoords = new Coordinates(3, 4);
        board.placePiece(bishopCoords, bishop);

        Piece pawn1 = new Pawn(PlayerColour.WHITE);
        Coordinates pawn1Coords = new Coordinates(2, 3);
        board.placePiece(pawn1Coords, pawn1);
        Piece pawn2 = new Pawn(PlayerColour.BLACK);
        Coordinates pawn2Coords = new Coordinates(2, 5);
        board.placePiece(pawn2Coords, pawn2);

        //Act
        List<Move> bishopMoves = bishop.getAllowedMoves(bishopCoords, board);


        //Assert
        assertThat(bishopMoves).doesNotContain(new Move(bishopCoords, pawn1Coords.plus(-2, -2)));
        assertThat(bishopMoves).doesNotContain(new Move(bishopCoords, pawn2Coords.plus(-1, 1)));
    }

    @Test
    public void whiteBishopCantMoveOffBoard() { //cant capture own must pass
        //Arrange
        Board board = Board.empty();

        Piece bishop = new Bishop(PlayerColour.WHITE);
        Coordinates bishopCoords = new Coordinates(0, 0);
        board.placePiece(bishopCoords, bishop);

        Piece pawn = new Pawn(PlayerColour.WHITE);
        Coordinates pawnCoords = new Coordinates(1, 1);
        board.placePiece(pawnCoords, pawn);

        //Act
        List<Move> bishopMoves = bishop.getAllowedMoves(bishopCoords, board);


        //Assert
        assertThat(bishopMoves).isEmpty();
    }

    @Test
    public void blackBishopCantMoveOffBoard() { //cant capture own must pass
        //Arrange
        Board board = Board.empty();

        Piece bishop = new Bishop(PlayerColour.BLACK);
        Coordinates bishopCoords = new Coordinates(0, 0);
        board.placePiece(bishopCoords, bishop);

        Piece pawn = new Pawn(PlayerColour.BLACK);
        Coordinates pawnCoords = new Coordinates(1, 1);
        board.placePiece(pawnCoords, pawn);

        //Act
        List<Move> bishopMoves = bishop.getAllowedMoves(bishopCoords, board);


        //Assert
        assertThat(bishopMoves).isEmpty();
    }
}
