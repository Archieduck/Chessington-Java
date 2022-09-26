package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class King extends AbstractPiece {
    private boolean hasMoved = false;
    public King(PlayerColour colour) {
        super(PieceType.KING, colour);
    }

    public boolean getHasMoved() {return hasMoved;}
    public void setHasMoved() {this.hasMoved = true;}

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        ArrayList<Move> kingMoves = new ArrayList<Move>();

        checkAndAddMove(from, board, kingMoves, 1, 0);
        checkAndAddMove(from, board, kingMoves, 1, 1);
        checkAndAddMove(from, board, kingMoves, -1, 0);
        checkAndAddMove(from, board, kingMoves, 0, -1);
        checkAndAddMove(from, board, kingMoves, 0, 1);
        checkAndAddMove(from, board, kingMoves, -1, -1);
        checkAndAddMove(from, board, kingMoves, 1, -1);
        checkAndAddMove(from, board, kingMoves, -1, 1);
        return kingMoves;
    }


    public List<Move> addMove(List<Move> kingMoves, Coordinates from, Coordinates currentCheckSquare) {//needs move too (from, to)
        Move to = new Move(from, currentCheckSquare);
        kingMoves.add(to);

        return kingMoves;
    }

    public Boolean checkSquareIsAvailable(Board board, Coordinates checkSquare) {
        if (checkSquare.getCol() >= 0 && checkSquare.getRow() >= 0 && checkSquare.getCol() <= 7 && checkSquare.getRow() <= 7) { //check square is on board
            return board.get(checkSquare) != null && !board.get(checkSquare).getColour().equals(getColour()) || board.get(checkSquare) == null; //check square is empty or has enemy piece
        }
        else return false;
    }

    public void checkAndAddMove(Coordinates from, Board board, List kingMoves, int rowDiff, int colDiff) {
        Coordinates checkSquare = (from);

            checkSquare = checkSquare.plus(rowDiff, colDiff);
            if (checkSquareIsAvailable(board, checkSquare)) {
                addMove(kingMoves, from, checkSquare);
            }

    }
}
