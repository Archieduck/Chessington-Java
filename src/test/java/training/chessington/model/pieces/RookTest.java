package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class RookTest {

    @Test
    public void whiteRookCanMoveAlongRows() {
        //Arrange
        Board board = Board.empty();

        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates rookCoords = new Coordinates(4, 0);
        board.placePiece(rookCoords, rook);

        //Act
        List<Move> rookMoves = rook.getAllowedMoves(rookCoords, board);


        //Assert
        assertThat(rookMoves).contains(new Move(rookCoords, rookCoords.plus(-1, 0)));
        assertThat(rookMoves).contains(new Move(rookCoords, rookCoords.plus(1, 0)));
        assertThat(rookMoves).contains(new Move(rookCoords, rookCoords.plus(3, 0)));
        assertThat(rookMoves).contains(new Move(rookCoords, rookCoords.plus(-4, 0)));

    }

    @Test
    public void blackRookCanMoveAlongRows() {
        //Arrange
        Board board = Board.empty();

        Piece rook = new Rook(PlayerColour.BLACK);
        Coordinates rookCoords = new Coordinates(4, 0);
        board.placePiece(rookCoords, rook);

        //Act
        List<Move> rookMoves = rook.getAllowedMoves(rookCoords, board);


        //Assert
        assertThat(rookMoves).contains(new Move(rookCoords, rookCoords.plus(-1, 0)));
        assertThat(rookMoves).contains(new Move(rookCoords, rookCoords.plus(1, 0)));
        assertThat(rookMoves).contains(new Move(rookCoords, rookCoords.plus(3, 0)));
        assertThat(rookMoves).contains(new Move(rookCoords, rookCoords.plus(-4, 0)));
    }

    @Test
    public void whiteRookCanMoveAlongCols() {
        //Arrange
        Board board = Board.empty();

        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates rookCoords = new Coordinates(4, 4);
        board.placePiece(rookCoords, rook);

        //Act
        List<Move> rookMoves = rook.getAllowedMoves(rookCoords, board);


        //Assert
        assertThat(rookMoves).contains(new Move(rookCoords, rookCoords.plus(0, -1)));
        assertThat(rookMoves).contains(new Move(rookCoords, rookCoords.plus(0, 1)));
        assertThat(rookMoves).contains(new Move(rookCoords, rookCoords.plus(0, 3)));
        assertThat(rookMoves).contains(new Move(rookCoords, rookCoords.plus(0, -4)));
    }

    @Test
    public void blackRookCanMoveAlongCols() {
        //Arrange
        Board board = Board.empty();

        Piece rook = new Rook(PlayerColour.BLACK);
        Coordinates rookCoords = new Coordinates(4, 4);
        board.placePiece(rookCoords, rook);

        //Act
        List<Move> rookMoves = rook.getAllowedMoves(rookCoords, board);


        //Assert
        assertThat(rookMoves).contains(new Move(rookCoords, rookCoords.plus(0, -1)));
        assertThat(rookMoves).contains(new Move(rookCoords, rookCoords.plus(0, 1)));
        assertThat(rookMoves).contains(new Move(rookCoords, rookCoords.plus(0, 3)));
        assertThat(rookMoves).contains(new Move(rookCoords, rookCoords.plus(0, -4)));
    }

    @Test
    public void whiteRookCanCapturePieces() {
        //Arrange
        Board board = Board.empty();

        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates rookCoords = new Coordinates(4, 0);
        board.placePiece(rookCoords, rook);

        Piece pawn = new Pawn(PlayerColour.BLACK);
        Coordinates pawnCoords = new Coordinates(3, 0);
        board.placePiece(pawnCoords, pawn);
        Piece pawn2 = new Pawn(PlayerColour.BLACK);
        Coordinates pawn2Coords = new Coordinates(4, 4);
        board.placePiece(pawn2Coords, pawn2);

        //Act
        List<Move> rookMoves = rook.getAllowedMoves(rookCoords, board);


        //Assert
        assertThat(rookMoves).contains(new Move(rookCoords, pawnCoords));
        assertThat(rookMoves).contains(new Move(rookCoords, pawn2Coords));
    }

    @Test
    public void blackRookCanCapturePieces() {
        //Arrange
        Board board = Board.empty();

        Piece rook = new Rook(PlayerColour.BLACK);
        Coordinates rookCoords = new Coordinates(4, 0);
        board.placePiece(rookCoords, rook);

        Piece pawn = new Pawn(PlayerColour.WHITE);
        Coordinates pawnCoords = new Coordinates(3, 0);
        board.placePiece(pawnCoords, pawn);
        Piece pawn2 = new Rook(PlayerColour.WHITE);
        Coordinates pawn2Coords = new Coordinates(4, 4);
        board.placePiece(pawn2Coords, pawn2);

        //Act
        List<Move> rookMoves = rook.getAllowedMoves(rookCoords, board);


        //Assert
        assertThat(rookMoves).contains(new Move(rookCoords, pawnCoords));
        assertThat(rookMoves).contains(new Move(rookCoords, pawn2Coords));
    }

    @Test
    public void whiteRookCantCaptureOwnPieces() {
        //Arrange
        Board board = Board.empty();

        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates rookCoords = new Coordinates(4, 0);
        board.placePiece(rookCoords, rook);

        Piece pawn = new Pawn(PlayerColour.WHITE);
        Coordinates pawnCoords = new Coordinates(3, 0);
        board.placePiece(pawnCoords, pawn);
        Piece pawn2 = new Pawn(PlayerColour.WHITE);
        Coordinates pawn2Coords = new Coordinates(4, 4);
        board.placePiece(pawn2Coords, pawn2);

        //Act
        List<Move> rookMoves = rook.getAllowedMoves(rookCoords, board);


        //Assert
        assertThat(rookMoves).doesNotContain(new Move(rookCoords, pawnCoords));
        assertThat(rookMoves).doesNotContain(new Move(rookCoords, pawn2Coords));
    }

    @Test
    public void blackRookCantCaptureOwnPieces() {
        //Arrange
        Board board = Board.empty();

        Piece rook = new Rook(PlayerColour.BLACK);
        Coordinates rookCoords = new Coordinates(4, 0);
        board.placePiece(rookCoords, rook);

        Piece pawn = new Pawn(PlayerColour.BLACK);
        Coordinates pawnCoords = new Coordinates(3, 0);
        board.placePiece(pawnCoords, rook);
        Piece pawn2 = new Pawn(PlayerColour.BLACK);
        Coordinates pawn2Coords = new Coordinates(4, 4);
        board.placePiece(pawn2Coords, rook);

        //Act
        List<Move> rookMoves = rook.getAllowedMoves(rookCoords, board);


        //Assert
        assertThat(rookMoves).doesNotContain(new Move(rookCoords, pawnCoords));
        assertThat(rookMoves).doesNotContain(new Move(rookCoords, pawn2Coords));
    }

    @Test
    public void whiteRookCantMoveThroughPices() {
        //Arrange
        Board board = Board.empty();

        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates rookCoords = new Coordinates(4, 0);
        board.placePiece(rookCoords, rook);

        Piece pawn = new Pawn(PlayerColour.WHITE);
        Coordinates pawnCoords = new Coordinates(3, 0);
        board.placePiece(pawnCoords, pawn);
        Piece pawn2 = new Pawn(PlayerColour.BLACK);
        Coordinates pawn2Coords = new Coordinates(4, 4);
        board.placePiece(pawn2Coords, pawn);

        //Act
        List<Move> rookMoves = rook.getAllowedMoves(rookCoords, board);


        //Assert
        assertThat(rookMoves).doesNotContain(new Move(rookCoords, pawnCoords.plus(-1, 0)));
        assertThat(rookMoves).doesNotContain(new Move(rookCoords, pawn2Coords.plus(0, 1)));
    }

    @Test
    public void blackRookCantMoveThroughPieces() {
        //Arrange
        Board board = Board.empty();

        Piece rook = new Rook(PlayerColour.BLACK);
        Coordinates rookCoords = new Coordinates(4, 0);
        board.placePiece(rookCoords, rook);

        Piece pawn = new Pawn(PlayerColour.WHITE);
        Coordinates pawnCoords = new Coordinates(3, 0);
        board.placePiece(pawnCoords, pawn);
        Piece pawn2 = new Pawn(PlayerColour.BLACK);
        Coordinates pawn2Coords = new Coordinates(4, 4);
        board.placePiece(pawn2Coords, pawn);

        //Act
        List<Move> rookMoves = rook.getAllowedMoves(rookCoords, board);


        //Assert
        assertThat(rookMoves).doesNotContain(new Move(rookCoords, pawnCoords.plus(-1, 0)));
        assertThat(rookMoves).doesNotContain(new Move(rookCoords, pawn2Coords.plus(0, 1)));
    }

    @Test
    public void whiteRookCanCastleKingsSide() {
        //Arrange
        Board board = Board.empty();

        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates rookCoords = new Coordinates(7, 7);
        board.placePiece(rookCoords, rook);
        Piece king = new King(PlayerColour.WHITE);
        Coordinates kingCoords = new Coordinates(4, 7);
        board.placePiece(kingCoords, king);
        Coordinates castledKing = new Coordinates(6, 7);
        Coordinates castledRook = new Coordinates(5, 7);

        //Act
        List<Move> rookMoves = rook.getAllowedMoves(rookCoords, board);


        //Assert
        assertThat(rookMoves).contains(new Move(rookCoords, kingCoords));
        board.move(rookCoords, kingCoords);
        assertEquals(board.get(castledKing).getType(), Piece.PieceType.KING);
        assertEquals(board.get(castledRook).getType(), Piece.PieceType.ROOK);
    }

    @Test
    public void blackRookCanCastleKingsSide() {
        //Arrange
        Board board = Board.empty();

        Piece rook = new Rook(PlayerColour.BLACK);
        Coordinates rookCoords = new Coordinates(7, 0);
        board.placePiece(rookCoords, rook);
        Piece king = new King(PlayerColour.BLACK);
        Coordinates kingCoords = new Coordinates(4, 0);
        board.placePiece(kingCoords, king);
        Coordinates castledKing = new Coordinates(6, 0);
        Coordinates castledRook = new Coordinates(5, 0);

        //Act
        List<Move> rookMoves = rook.getAllowedMoves(rookCoords, board);


        //Assert
        assertThat(rookMoves).contains(new Move(rookCoords, kingCoords));
        board.move(rookCoords, kingCoords);
        assertEquals(board.get(castledKing).getType(), Piece.PieceType.KING);
        assertEquals(board.get(castledRook).getType(), Piece.PieceType.ROOK);
    }

    @Test
    public void whiteRookCanCastleQueensSide() {
        //Arrange
        Board board = Board.empty();

        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates rookCoords = new Coordinates(0, 0);
        board.placePiece(rookCoords, rook);
        Piece king = new King(PlayerColour.WHITE);
        Coordinates kingCoords = new Coordinates(4, 0);
        board.placePiece(kingCoords, king);
        Coordinates castledKing = new Coordinates(2, 0);
        Coordinates castledRook = new Coordinates(3, 0);

        //Act
        List<Move> rookMoves = rook.getAllowedMoves(rookCoords, board);


        //Assert
        assertThat(rookMoves).contains(new Move(rookCoords, kingCoords));
        board.move(rookCoords, kingCoords);
        assertEquals(board.get(castledKing).getType(), Piece.PieceType.KING);
        assertEquals(board.get(castledRook).getType(), Piece.PieceType.ROOK);
    }

    @Test
    public void blackRookCanCastleQueensSide() {
        //Arrange
        Board board = Board.empty();

        Piece rook = new Rook(PlayerColour.BLACK);
        Coordinates rookCoords = new Coordinates(0, 7);
        board.placePiece(rookCoords, rook);
        Piece king = new King(PlayerColour.BLACK);
        Coordinates kingCoords = new Coordinates(4, 7);
        board.placePiece(kingCoords, king);
        Coordinates castledKing = new Coordinates(2, 7);
        Coordinates castledRook = new Coordinates(3, 7);

        //Act
        List<Move> rookMoves = rook.getAllowedMoves(rookCoords, board);


        //Assert
        assertThat(rookMoves).contains(new Move(rookCoords, kingCoords));
        board.move(rookCoords, kingCoords);
        assertEquals(board.get(castledKing).getType(), Piece.PieceType.KING);
        assertEquals(board.get(castledRook).getType(), Piece.PieceType.ROOK);
    }

    @Test
    public void whiteCantCastleIfRookMoved() {
        //Arrange
        //Act
        //Assert
    }

    @Test
    public void blackCantCastleIfRookMoved() {
        //Arrange
        //Act
        //Assert
    }

    @Test
    public void whiteRookCantMoveOffBoard() {
        //Arrange
        Board board = Board.empty();

        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates rookCoords = new Coordinates(0, 0);
        board.placePiece(rookCoords, rook);
        Piece rook2 = new Rook(PlayerColour.WHITE);
        Coordinates rook2Coords = new Coordinates(7, 7);
        board.placePiece(rook2Coords, rook);

        Piece pawn = new Pawn(PlayerColour.WHITE);
        Coordinates pawnCoords = new Coordinates(1, 0);
        board.placePiece(pawnCoords, pawn);
        Piece pawn2 = new Pawn(PlayerColour.WHITE);
        Coordinates pawn2Coords = new Coordinates(0, 1);
        board.placePiece(pawn2Coords, pawn2);
        Piece pawn3 = new Pawn(PlayerColour.WHITE);
        Coordinates pawn3Coords = new Coordinates(7, 6);
        board.placePiece(pawn3Coords, pawn3);
        Piece pawn4 = new Pawn(PlayerColour.WHITE);
        Coordinates pawn4Coords = new Coordinates(6, 7);
        board.placePiece(pawn4Coords, pawn4);

        //Act
        List<Move> rookMoves = rook.getAllowedMoves(rookCoords, board);


        //Assert
        assertThat(rookMoves).isEmpty();
    }

    @Test
    public void blackRookCantMoveOffBoard() {
        //Arrange
        Board board = Board.empty();

        Piece rook = new Rook(PlayerColour.BLACK);
        Coordinates rookCoords = new Coordinates(0, 0);
        board.placePiece(rookCoords, rook);
        Piece rook2 = new Rook(PlayerColour.BLACK);
        Coordinates rook2Coords = new Coordinates(7, 7);
        board.placePiece(rook2Coords, rook);

        Piece pawn = new Pawn(PlayerColour.BLACK);
        Coordinates pawnCoords = new Coordinates(1, 0);
        board.placePiece(pawnCoords, pawn);
        Piece pawn2 = new Pawn(PlayerColour.BLACK);
        Coordinates pawn2Coords = new Coordinates(0, 1);
        board.placePiece(pawn2Coords, pawn2);
        Piece pawn3 = new Pawn(PlayerColour.BLACK);
        Coordinates pawn3Coords = new Coordinates(7, 6);
        board.placePiece(pawn3Coords, pawn3);
        Piece pawn4 = new Pawn(PlayerColour.BLACK);
        Coordinates pawn4Coords = new Coordinates(6, 7);
        board.placePiece(pawn4Coords, pawn4);

        //Act
        List<Move> rookMoves = rook.getAllowedMoves(rookCoords, board);


        //Assert
        assertThat(rookMoves).isEmpty();
    }



}
