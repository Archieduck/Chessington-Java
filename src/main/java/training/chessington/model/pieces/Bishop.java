package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends AbstractPiece {
    boolean hasMoved = false;
    public Bishop(PlayerColour colour) {
        super(PieceType.BISHOP, colour);
    }

    public boolean getHasMoved() {return hasMoved;}
    public void setHasMoved() {this.hasMoved = true;}

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        ArrayList<Move> bishopMoves = new ArrayList<Move>();
        int rowChanger = 1;
        int i = 0;

        checkAndAddMove(from, board, bishopMoves, 1, 1);
        checkAndAddMove(from, board, bishopMoves, -1, -1);
        checkAndAddMove(from, board, bishopMoves, -1, 1);
        checkAndAddMove(from, board, bishopMoves, 1, -1);

        return bishopMoves;
    }

    public List<Move> addMove(List<Move> bishopMoves, Coordinates from, Coordinates currentCheckSquare) {//needs move too (from, to)
        Move to = new Move(from, currentCheckSquare);
        bishopMoves.add(to);

        return bishopMoves;
    }

    public Boolean checkSquareIsAvailable(Board board, Coordinates checkSquare) {

        if (checkSquare.getCol() >= 0 && checkSquare.getRow() >= 0 && checkSquare.getCol() <= 7 && checkSquare.getRow() <= 7) { //check square is on board
            return board.get(checkSquare) != null && !board.get(checkSquare).getColour().equals(getColour()) || board.get(checkSquare) == null; //check square is empty or has enemy piece
        }
        else return false;
    }

    public void checkAndAddMove(Coordinates from, Board board, List bishopMoves, int rowDiff, int colDiff) {
        Coordinates checkSquare = (from);
        do {
            checkSquare = checkSquare.plus(rowDiff, colDiff);
            if (checkSquareIsAvailable(board, checkSquare)) {
                addMove(bishopMoves, from, checkSquare);
                if (board.get(checkSquare) != null && !board.get(checkSquare).getColour().equals(getColour())){ //if opposite coloured piece
                    break;
                }
            } else {
                break;
            }
        } while (checkSquareIsAvailable(board, checkSquare));
    }
}

