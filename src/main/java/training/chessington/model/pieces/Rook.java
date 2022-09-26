package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Rook extends AbstractPiece {
    private boolean hasMoved = false;
    public Rook(PlayerColour colour) {
        super(PieceType.ROOK, colour);
    }

    public boolean getHasMoved() {return hasMoved;}
    public void setHasMoved() {this.hasMoved = true;}

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        ArrayList<Move> rookMoves = new ArrayList<Move>();

        int rowDirection = 1;
        int colDirection = 1;
        Coordinates checkSquare = new Coordinates(from.getRow(), from.getCol());

        checkAndAddMove(from, board, rookMoves, 1, 0);
        checkAndAddMove(from, board, rookMoves, -1, 0);
        checkAndAddMove(from, board, rookMoves, 0, 1);
        checkAndAddMove(from, board, rookMoves, 0, -1);

        return rookMoves;
    }



    public List<Move> addMove(List<Move> rookMoves, Coordinates from, Coordinates currentCheckSquare) {//needs move too (from, to)
        Move to = new Move(from, currentCheckSquare);
        rookMoves.add(to);

        return rookMoves;
    }

    public Boolean checkSquareIsAvailable(Board board, Coordinates checkSquare) {
        if (checkSquare.getCol() >= 0 && checkSquare.getRow() >= 0 && checkSquare.getCol() <= 7 && checkSquare.getRow() <= 7) { //check square is on board
            return board.get(checkSquare) != null && !board.get(checkSquare).getColour().equals(getColour()) || board.get(checkSquare) == null; //check square is empty or has enemy piece
        }
        else return false;
    }

    public void checkAndAddMove(Coordinates from, Board board, List rookMoves, int rowDiff, int colDiff) {
        Coordinates checkSquare = (from);
        do {
            checkSquare = checkSquare.plus(rowDiff, colDiff);
            if (checkSquareIsAvailable(board, checkSquare)) {
                addMove(rookMoves, from, checkSquare);
                if (board.get(checkSquare) != null && !board.get(checkSquare).getColour().equals(getColour())){ //if opposite coloured piece
                    break;
                }
            } else {
                break;
            }
        } while (checkSquareIsAvailable(board, checkSquare));
    }


}

