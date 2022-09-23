package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {
    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        ArrayList<Move> pawnMoves = new ArrayList<Move>();
        int direction = -1;

        if (getColour().equals(PlayerColour.BLACK)) {//change direction for black
            direction = 1;
        }

        Coordinates moveTo = new Coordinates(from.getRow() + (1 * direction), from.getCol()); //get new coordinate
        Move to = new Move(from, moveTo); // make new move
        pawnMoves.add(to); //add move to list






        return pawnMoves;
        //return new ArrayList<>();
    }
}
