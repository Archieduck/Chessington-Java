package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends AbstractPiece {
    public Bishop(PlayerColour colour) {
        super(PieceType.BISHOP, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        ArrayList<Move> bishopMoves = new ArrayList<Move>();
        int rowChanger = 1;
        int i = 0;

            Coordinates checkSquare = new Coordinates(from.getRow(), from.getCol());
            do { // for rows going up OR down
                int colChanger = 1; // resets colChanger
                do { //for cols going up OR down

                    checkSquare = new Coordinates(from.getRow(), from.getCol());
                    do {
                        checkSquare = checkSquare.plus(rowChanger, colChanger);
                        if (checkSquare.getRow() > 7 || checkSquare.getCol() > 7 || checkSquare.getRow() < 0 || checkSquare.getCol() < 0) { //if its over the edge dont bother
                            break;
                        }
                        if (checkSquare.getCol() >= 0 && checkSquare.getRow() >= 0 && checkSquare.getCol() <= 7 && checkSquare.getRow() <= 7) { //check square still on board
                            if (checkSquareIsAvailable(board, checkSquare)) {
                                addMove(bishopMoves, from, checkSquare);
                                if (board.get(checkSquare) != null && !board.get(checkSquare).getColour().equals(getColour())){ //if opposite coloured piece
                                    break;
                                }
                            } else if (!checkSquareIsAvailable(board, checkSquare)) { //same coloured piece
                                break;
                            }

                        }

                    } while (checkSquare.getCol() != 0 && checkSquare.getCol() != 7 && checkSquare.getRow() != 0 && checkSquare.getRow() != 7);

                    colChanger = -1;
                    i += 1;

                } while (i != 2 && i != 4);
                rowChanger = -1;

            } while (i < 4);

        return bishopMoves;
    }

    public List<Move> addMove(List<Move> bishopMoves, Coordinates from, Coordinates currentCheckSquare) {//needs move too (from, to)
        Move to = new Move(from, currentCheckSquare);
        bishopMoves.add(to);

        return bishopMoves;
    }

    public Boolean checkSquareIsAvailable(Board board, Coordinates currentCheckSquare) {

        return board.get(currentCheckSquare) != null && !board.get(currentCheckSquare).getColour().equals(getColour()) || board.get(currentCheckSquare) == null;
    }
}

