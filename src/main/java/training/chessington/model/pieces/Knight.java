package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Knight extends AbstractPiece {
    public Knight(PlayerColour colour) {
        super(PieceType.KNIGHT, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        ArrayList<Coordinates> possibleMoves = new ArrayList<Coordinates>();
        ArrayList<Move> knightMoves = new ArrayList<Move>();
        possibleMoves = getPossibleMoves();


        for (int i = 0; i < 8; i++){
            Coordinates checkSquare = new Coordinates(from.getRow() + possibleMoves.get(i).getRow(), from.getCol() + possibleMoves.get(i).getCol());
            if (checkSquareIsAvailable(board, checkSquare)){
                Move to = new Move(from, checkSquare);
                knightMoves.add(to);
            }
        }
        return knightMoves;
    }

    public ArrayList<Coordinates> getPossibleMoves() { //gets the difference in coordinates for knight moves as coordinates
        ArrayList<Coordinates> possibleMoves = new ArrayList<Coordinates>();
        String moves = "1,2 2,1 1,-2 2,-1 -1,2 -2,1 -1,-2 -2,-1";
        String coordsArray[] = moves.split("\\s+");
        for(String s : coordsArray)
        {
            String coordXY[] = s.split(",");
            int x = Integer.parseInt(coordXY[0]);
            int y = Integer.parseInt(coordXY[1]);
            possibleMoves.add(new Coordinates(x, y));
        }

        return possibleMoves;
    }

    public Boolean checkSquareIsAvailable(Board board, Coordinates checkSquare) {
        if (checkSquare.getCol() >= 0 && checkSquare.getRow() >= 0 && checkSquare.getCol() <= 7 && checkSquare.getRow() <= 7) { //check square is on board
            return board.get(checkSquare) != null && !board.get(checkSquare).getColour().equals(getColour()) || board.get(checkSquare) == null; //check square is empty or has enemy piece
        }
        else return false;
    }
}
