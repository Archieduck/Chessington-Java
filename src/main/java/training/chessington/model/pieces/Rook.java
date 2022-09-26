package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Rook extends AbstractPiece {
    public Rook(PlayerColour colour) {
        super(PieceType.ROOK, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        ArrayList<Move> rookMoves = new ArrayList<Move>();









        return rookMoves;
    }



    public List<Move> addMove(List<Move> rookMoves, Coordinates from, Coordinates currentCheckSquare) {//needs move too (from, to)
        Move to = new Move(from, currentCheckSquare);
        rookMoves.add(to);

        return rookMoves;
    }

//    public Boolean checkSquareIsAvailable(Board board, Coordinates currentCheckSquare) {
//
//        return board.get(currentCheckSquare) != null && !board.get(currentCheckSquare).getColour().equals(getColour()) || board.get(currentCheckSquare) == null;
//    }
}

