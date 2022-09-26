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


        if (getColour().equals(PlayerColour.WHITE) && from.getRow() == 0){ // checks if piece is at the end of the board
            return pawnMoves;
        } else if (getColour().equals(PlayerColour.BLACK) && from.getRow() == 7){
            return pawnMoves;
        }


        //if piece in front
        Coordinates infront1 = new Coordinates(from.getRow() + (1 * direction), from.getCol());
        Coordinates infront2 = new Coordinates(from.getRow() + (2 * direction), from.getCol());
        Coordinates diagonalL = new Coordinates(from.getRow() + (1 * direction), from.getCol() - 1);
        Coordinates diagonalR = new Coordinates(from.getRow() + (1 * direction), from.getCol() + 1);


        if (board.get(infront1) == null) { // if square 1 infront of pawn is free add move

            Coordinates moveTo = new Coordinates(from.getRow() + (1 * direction), from.getCol()); //get new coordinate
            Move to = new Move(from, moveTo); // make new move
            pawnMoves.add(to); //add move to list

        }
        if (board.get(infront1) == null && board.get(infront2) == null) { // if square 1 & 2 infront of pawn is free do move 2 logic

            if (getColour().equals(PlayerColour.BLACK) && (from.getRow() == 1)) {

                Coordinates moveTo = new Coordinates(from.getRow() + (2 * direction), from.getCol()); //get new coordinate
                Move to = new Move(from, moveTo); // make new move
                pawnMoves.add(to);

            } else if (getColour().equals(PlayerColour.WHITE) && (from.getRow() == 6)) {

                Coordinates moveTo = new Coordinates(from.getRow() + (2 * direction), from.getCol()); //get new coordinate
                Move to = new Move(from, moveTo); // make new move
                pawnMoves.add(to);
            }
        }

        if (diagonalL.getCol() >= 0 && board.get(diagonalL) != null && !board.get(diagonalL).getColour().equals(getColour())) { // check if any pieces for the pawn to take and add move
            Move to = new Move(from, diagonalL);
            pawnMoves.add(to);
        }
        if (diagonalR.getCol() <= 7 && board.get(diagonalR) != null && !board.get(diagonalR).getColour().equals(getColour())) {
            Move to = new Move(from, diagonalR);
            pawnMoves.add(to);
        }

        //add en passant

        //add promotion


        return pawnMoves;
    }



}
