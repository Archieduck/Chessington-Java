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
        int direction = getColour().equals(PlayerColour.BLACK) ? 1 : -1; // select direction
        int startRow = getColour().equals(PlayerColour.BLACK) ? 1 : 6;
        int endRow = getColour().equals(PlayerColour.BLACK) ? 7 : 0;


        if (from.getRow() == endRow){
            return pawnMoves;
        }

        checkAndAddMove(from, board, pawnMoves, direction, 0);

        Coordinates infront1 = new Coordinates(from.getRow() + (direction), from.getCol());
        if (board.get(infront1) == null) {
            if (from.getRow() == startRow) {
                checkAndAddMove(from, board, pawnMoves, direction * 2, 0);
            }
        }

        Coordinates diagonalL = new Coordinates(from.getRow() + (direction), from.getCol() - 1);
        Coordinates diagonalR = new Coordinates(from.getRow() + (direction), from.getCol() + 1);

        if (diagonalL.getCol() >= 0 && board.get(diagonalL) != null && !board.get(diagonalL).getColour().equals(getColour())) { // check if any pieces for the pawn to take and add move
            checkAndAddMove(from, board, pawnMoves, direction, -1);
        }
        if (diagonalR.getCol() <= 7 && board.get(diagonalR) != null && !board.get(diagonalR).getColour().equals(getColour())) {
            checkAndAddMove(from, board, pawnMoves, direction, 1);
        }

        if (from.getRow() == endRow + (-3 * direction)){
            enPassant(board, pawnMoves, from, direction);
        }

        //add promotion


        return pawnMoves;
    }

    public List<Move> addMove(List<Move> pawnMoves, Coordinates from, Coordinates currentCheckSquare) {//needs move too (from, to)
        Move to = new Move(from, currentCheckSquare);
        pawnMoves.add(to);

        return pawnMoves;
    }

    public Boolean checkSquareIsAvailable(Board board, Coordinates checkSquare, int colDiff) {
        if (checkSquare.getCol() >= 0 && checkSquare.getRow() >= 0 && checkSquare.getCol() <= 7 && checkSquare.getRow() <= 7) { //check square is on board
            return board.get(checkSquare) != null && !board.get(checkSquare).getColour().equals(getColour()) && colDiff != 0|| board.get(checkSquare) == null; //check square is empty or has enemy piece
        }
        else return false;
    }

    public void checkAndAddMove(Coordinates from, Board board, List pawnMoves, int rowDiff, int colDiff) {
        Coordinates checkSquare = (from);

        checkSquare = checkSquare.plus(rowDiff, colDiff);
        if (checkSquareIsAvailable(board, checkSquare, colDiff)) {
            addMove(pawnMoves, from, checkSquare);
        }

    }

    public void pawnPromotion(Board board, List pawnMoves) {

    }

    public void enPassant(Board board, List pawnMoves, Coordinates from, int direction){

        Coordinates left = new Coordinates(from.getRow(), from.getCol() - 1);
        Coordinates right = new Coordinates(from.getRow(), from.getCol() + 1);
        Move check;

        if (right.getCol() <= 7 && board.get(right) != null && !board.get(right).getColour().equals(getColour()) && board.get(right).getType().equals(PieceType.PAWN)){
            check = board.getMostRecentMove();
            if (check.getTo().getCol() == right.getCol() && check.getTo().getRow() == right.getRow()){
                checkAndAddMove(from, board, pawnMoves, direction, 1);
            }
        }
        if (left.getCol() >= 0 && board.get(left) != null && !board.get(left).getColour().equals(getColour()) && board.get(left).getType().equals(PieceType.PAWN)){
            check = board.getMostRecentMove();
            if (check.getTo().getCol() == left.getCol() && check.getTo().getRow() == left.getRow()){
                checkAndAddMove(from, board, pawnMoves, direction, -1);
            }
        }
    }



}
