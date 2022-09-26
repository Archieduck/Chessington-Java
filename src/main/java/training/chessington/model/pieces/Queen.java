package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Queen extends AbstractPiece {
    boolean hasMoved = false;
    public Queen(PlayerColour colour) {
        super(PieceType.QUEEN, colour);
    }
    public boolean getHasMoved() {return hasMoved;}
    public void setHasMoved() {this.hasMoved = true;}

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        ArrayList<Move> queenMoves = new ArrayList<Move>();

        checkAndAddMove(from, board, queenMoves, 1, 0);
        checkAndAddMove(from, board, queenMoves, 1, 1);
        checkAndAddMove(from, board, queenMoves, -1, 0);
        checkAndAddMove(from, board, queenMoves, 0, -1);
        checkAndAddMove(from, board, queenMoves, 0, 1);
        checkAndAddMove(from, board, queenMoves, -1, -1);
        checkAndAddMove(from, board, queenMoves, 1, -1);
        checkAndAddMove(from, board, queenMoves, -1, 1);

        return queenMoves;
    }


    public List<Move> addMove(List<Move> queenMoves, Coordinates from, Coordinates currentCheckSquare) {//needs move too (from, to)
        Move to = new Move(from, currentCheckSquare);
        queenMoves.add(to);

        return queenMoves;
    }

    public Boolean checkSquareIsAvailable(Board board, Coordinates checkSquare) {
        if (checkSquare.getCol() >= 0 && checkSquare.getRow() >= 0 && checkSquare.getCol() <= 7 && checkSquare.getRow() <= 7) { //check square is on board
            return board.get(checkSquare) != null && !board.get(checkSquare).getColour().equals(getColour()) || board.get(checkSquare) == null; //check square is empty or has enemy piece
        }
        else return false;
    }

    public void checkAndAddMove(Coordinates from, Board board, List queenMoves, int rowDiff, int colDiff) {
        Coordinates checkSquare = (from);
        do {
            checkSquare = checkSquare.plus(rowDiff, colDiff);
            if (checkSquareIsAvailable(board, checkSquare)) {
                addMove(queenMoves, from, checkSquare);
                if (board.get(checkSquare) != null && !board.get(checkSquare).getColour().equals(getColour())){ //if opposite coloured piece
                    break;
                }
            } else {
                break;
            }
        } while (checkSquareIsAvailable(board, checkSquare));
    }
}
