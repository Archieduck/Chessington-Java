package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class QueenTest {

    @Test
    public void whiteQueenCanMoveAlongRows() {
        //Arrange
        Board board = Board.empty();

        Piece queen = new Queen(PlayerColour.WHITE);
        Coordinates queenCoords = new Coordinates(4, 4);
        board.placePiece(queenCoords, queen);

        //Act
        List<Move> queenMoves = queen.getAllowedMoves(queenCoords, board);


        //Assert
        assertThat(queenMoves).contains(new Move(queenCoords, queenCoords.plus(-1, 0)));
        assertThat(queenMoves).contains(new Move(queenCoords, queenCoords.plus(1, 0)));
        assertThat(queenMoves).contains(new Move(queenCoords, queenCoords.plus(3, 0)));
        assertThat(queenMoves).contains(new Move(queenCoords, queenCoords.plus(-4, 0)));
    }
    @Test
    public void blackQueenCanMoveAlongRows() {
        //Arrange
        Board board = Board.empty();

        Piece queen = new Queen(PlayerColour.BLACK);
        Coordinates queenCoords = new Coordinates(4, 4);
        board.placePiece(queenCoords, queen);

        //Act
        List<Move> queenMoves = queen.getAllowedMoves(queenCoords, board);


        //Assert
        assertThat(queenMoves).contains(new Move(queenCoords, queenCoords.plus(-1, 0)));
        assertThat(queenMoves).contains(new Move(queenCoords, queenCoords.plus(1, 0)));
        assertThat(queenMoves).contains(new Move(queenCoords, queenCoords.plus(3, 0)));
        assertThat(queenMoves).contains(new Move(queenCoords, queenCoords.plus(-4, 0)));
    }
    @Test
    public void whiteQueenCanMoveAlongCols() {
        //Arrange
        Board board = Board.empty();

        Piece queen = new Queen(PlayerColour.WHITE);
        Coordinates queenCoords = new Coordinates(4, 4);
        board.placePiece(queenCoords, queen);

        //Act
        List<Move> queenMoves = queen.getAllowedMoves(queenCoords, board);


        //Assert
        assertThat(queenMoves).contains(new Move(queenCoords, queenCoords.plus(0, -1)));
        assertThat(queenMoves).contains(new Move(queenCoords, queenCoords.plus(0, 1)));
        assertThat(queenMoves).contains(new Move(queenCoords, queenCoords.plus(0, 3)));
        assertThat(queenMoves).contains(new Move(queenCoords, queenCoords.plus(0, -4)));
    }
    @Test
    public void blackQueenCanMoveAlongCols() {
        //Arrange
        Board board = Board.empty();

        Piece queen = new Queen(PlayerColour.BLACK);
        Coordinates queenCoords = new Coordinates(4, 4);
        board.placePiece(queenCoords, queen);

        //Act
        List<Move> queenMoves = queen.getAllowedMoves(queenCoords, board);


        //Assert
        assertThat(queenMoves).contains(new Move(queenCoords, queenCoords.plus(0, -1)));
        assertThat(queenMoves).contains(new Move(queenCoords, queenCoords.plus(0, 1)));
        assertThat(queenMoves).contains(new Move(queenCoords, queenCoords.plus(0, 3)));
        assertThat(queenMoves).contains(new Move(queenCoords, queenCoords.plus(0, -4)));
    }
    @Test
    public void whiteQueenCanMoveAlongDiagonals() {
        //Arrange
        Board board = Board.empty();
        Piece queen = new Queen(PlayerColour.BLACK);
        Coordinates queenCoords = new Coordinates(4, 4);
        board.placePiece(queenCoords, queen);

        //Act
        List<Move> moves = queen.getAllowedMoves(queenCoords, board);

        //Assert
        assertThat(moves).contains(new Move(queenCoords, queenCoords.plus(-1, -1)));
        assertThat(moves).contains(new Move(queenCoords, queenCoords.plus(3, -3)));
        assertThat(moves).contains(new Move(queenCoords, queenCoords.plus(2, 2)));
        assertThat(moves).contains(new Move(queenCoords, queenCoords.plus(-3, 3)));
    }
    @Test
    public void blackQueenCanMoveAlongDiagonals() {
        //Arrange
        Board board = Board.empty();
        Piece queen = new Queen(PlayerColour.BLACK);
        Coordinates queenCoords = new Coordinates(4, 4);
        board.placePiece(queenCoords, queen);

        //Act
        List<Move> moves = queen.getAllowedMoves(queenCoords, board);

        //Assert
        assertThat(moves).contains(new Move(queenCoords, queenCoords.plus(-1, -1)));
        assertThat(moves).contains(new Move(queenCoords, queenCoords.plus(3, -3)));
        assertThat(moves).contains(new Move(queenCoords, queenCoords.plus(3, 3)));
        assertThat(moves).contains(new Move(queenCoords, queenCoords.plus(2, -2)));
    }
    @Test
    public void whiteQueenCanCapturePieces() {//add rook
        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(PlayerColour.WHITE);
        Piece enemyPiece = new Rook(PlayerColour.BLACK);
        Piece enemy2Piece = new Rook(PlayerColour.BLACK);
        Coordinates queenCoords = new Coordinates(4, 4);
        board.placePiece(queenCoords, queen);

        Coordinates enemyCoords = queenCoords.plus(-2, 2);
        Coordinates enemy2Coords = queenCoords.plus(0, 2);
        board.placePiece(enemyCoords, enemyPiece);
        board.placePiece(enemy2Coords, enemy2Piece);

        // Act
        List<Move> moves = queen.getAllowedMoves(queenCoords, board);

        // Assert
        assertThat(moves).contains(new Move(queenCoords, enemyCoords));
        assertThat(moves).contains(new Move(queenCoords, enemy2Coords));
    }
    @Test
    public void blackQueenCanCapturePieces() {//add rook
        // Arrange
        Board board = Board.empty();
        Piece queen = new Queen(PlayerColour.BLACK);
        Piece enemyPiece = new Rook(PlayerColour.WHITE);
        Piece enemy2Piece = new Rook(PlayerColour.WHITE);
        Coordinates queenCoords = new Coordinates(4, 4);
        board.placePiece(queenCoords, queen);

        Coordinates enemyCoords = queenCoords.plus(-2, 2);
        Coordinates enemy2Coords = queenCoords.plus(0, 2);
        board.placePiece(enemyCoords, enemyPiece);
        board.placePiece(enemy2Coords, enemy2Piece);

        // Act
        List<Move> moves = queen.getAllowedMoves(queenCoords, board);

        // Assert
        assertThat(moves).contains(new Move(queenCoords, enemyCoords));
        assertThat(moves).contains(new Move(queenCoords, enemy2Coords));
    }
    @Test
    public void whiteQueenCantCaptureOwnPieces() {
        //Arrange
        Board board = Board.empty();

        Piece queen = new Queen(PlayerColour.WHITE);
        Coordinates queenCoords = new Coordinates(3, 4);
        board.placePiece(queenCoords, queen);

        Piece pawn1 = new Pawn(PlayerColour.WHITE);
        Coordinates pawn1Coords = queenCoords.plus(2, 0);
        board.placePiece(pawn1Coords, pawn1);
        Piece pawn2 = new Pawn(PlayerColour.WHITE);
        Coordinates pawn2Coords = queenCoords.plus(0, 2);
        board.placePiece(pawn2Coords, pawn2);


        // Act
        List<Move> queenMoves = queen.getAllowedMoves(queenCoords, board);

        // Assert
        assertThat(queenMoves).doesNotContain(new Move(queenCoords, pawn1Coords));
        assertThat(queenMoves).doesNotContain(new Move(queenCoords, pawn2Coords));
    }
    @Test
    public void blackQueenCantCaptureOwnPieces() {
        //Arrange
        Board board = Board.empty();

        Piece queen = new Queen(PlayerColour.BLACK);
        Coordinates queenCoords = new Coordinates(3, 4);
        board.placePiece(queenCoords, queen);

        Piece pawn1 = new Pawn(PlayerColour.BLACK);
        Coordinates pawn1Coords = queenCoords.plus(2, 0);
        board.placePiece(pawn1Coords, pawn1);
        Piece pawn2 = new Pawn(PlayerColour.BLACK);
        Coordinates pawn2Coords = queenCoords.plus(0, 2);
        board.placePiece(pawn2Coords, pawn2);


        // Act
        List<Move> queenMoves = queen.getAllowedMoves(queenCoords, board);

        // Assert
        assertThat(queenMoves).doesNotContain(new Move(queenCoords, pawn1Coords));
        assertThat(queenMoves).doesNotContain(new Move(queenCoords, pawn2Coords));
    }
    @Test
    public void whiteQueenCantMoveThroughPieces() {
        //Arrange
        Board board = Board.empty();

        Piece queen = new Queen(PlayerColour.WHITE);
        Coordinates queenCoords = new Coordinates(3, 4);
        board.placePiece(queenCoords, queen);

        Piece pawn1 = new Pawn(PlayerColour.WHITE);
        Coordinates pawn1Coords = new Coordinates(2, 3);
        board.placePiece(pawn1Coords, pawn1);
        Piece pawn2 = new Pawn(PlayerColour.BLACK);
        Coordinates pawn2Coords = new Coordinates(2, 5);
        board.placePiece(pawn2Coords, pawn2);

        //Act
        List<Move> queenMoves = queen.getAllowedMoves(queenCoords, board);


        //Assert
        assertThat(queenMoves).doesNotContain(new Move(queenCoords, pawn1Coords.plus(-2, -2)));
        assertThat(queenMoves).doesNotContain(new Move(queenCoords, pawn2Coords.plus(-1, 1)));
    }
    @Test
    public void blackQueenCantMoveThroughPieces() {
        //Arrange
        Board board = Board.empty();

        Piece queen = new Queen(PlayerColour.BLACK);
        Coordinates queenCoords = new Coordinates(3, 4);
        board.placePiece(queenCoords, queen);

        Piece pawn1 = new Pawn(PlayerColour.WHITE);
        Coordinates pawn1Coords = new Coordinates(2, 3);
        board.placePiece(pawn1Coords, pawn1);
        Piece pawn2 = new Pawn(PlayerColour.BLACK);
        Coordinates pawn2Coords = new Coordinates(2, 5);
        board.placePiece(pawn2Coords, pawn2);

        //Act
        List<Move> queenMoves = queen.getAllowedMoves(queenCoords, board);


        //Assert
        assertThat(queenMoves).doesNotContain(new Move(queenCoords, pawn1Coords.plus(-2, -2)));
        assertThat(queenMoves).doesNotContain(new Move(queenCoords, pawn2Coords.plus(-1, 1)));
    }

    @Test
    public void whiteQueenCantMoveOffBoard() {
        //Arrange
        Board board = Board.empty();

        Piece queen = new Queen(PlayerColour.WHITE);
        Coordinates queenCoords = new Coordinates(0, 0);
        board.placePiece(queenCoords, queen);

        Piece pawn = new Pawn(PlayerColour.WHITE);
        Coordinates pawnCoords = new Coordinates(1, 1);
        board.placePiece(pawnCoords, pawn);
        Piece pawn2 = new Pawn(PlayerColour.WHITE);
        Coordinates pawn2Coords = new Coordinates(0, 1);
        board.placePiece(pawn2Coords, pawn);
        Piece pawn3 = new Pawn(PlayerColour.WHITE);
        Coordinates pawn3Coords = new Coordinates(1, 0);
        board.placePiece(pawn3Coords, pawn);

        //Act
        List<Move> queenMoves = queen.getAllowedMoves(queenCoords, board);


        //Assert
        assertThat(queenMoves).isEmpty();
    }

    @Test
    public void blackQueenCantMoveOffBoard() {
        //Arrange
        Board board = Board.empty();

        Piece queen = new Queen(PlayerColour.WHITE);
        Coordinates queenCoords = new Coordinates(0, 0);
        board.placePiece(queenCoords, queen);

        Piece pawn = new Pawn(PlayerColour.WHITE);
        Coordinates pawnCoords = new Coordinates(1, 1);
        board.placePiece(pawnCoords, pawn);
        Piece pawn2 = new Pawn(PlayerColour.WHITE);
        Coordinates pawn2Coords = new Coordinates(0, 1);
        board.placePiece(pawn2Coords, pawn);
        Piece pawn3 = new Pawn(PlayerColour.WHITE);
        Coordinates pawn3Coords = new Coordinates(1, 0);
        board.placePiece(pawn3Coords, pawn);

        //Act
        List<Move> queenMoves = queen.getAllowedMoves(queenCoords, board);


        //Assert
        assertThat(queenMoves).isEmpty();
    }
}
