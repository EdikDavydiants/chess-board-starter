package ed.d.chessboard.pieces;

import ed.d.chessboard.Board;
import ed.d.chessboard.ControlledFieldsBoard;
import ed.d.chessboard.Coord;

public class Rook extends AbstractPiece {


    public Rook(boolean isWhite) {
        super(isWhite);
    }


    @Override
    public ControlledFieldsBoard markFieldsAsControlled(Coord pieceCoord, Board board, ControlledFieldsBoard cfBoard) {

        final int hor = pieceCoord.getHor();
        final int vert = pieceCoord.getVert();

        markHorizontal(hor, vert, board, cfBoard);
        markVertical(hor, vert, board, cfBoard);

        return cfBoard;
    }

    private boolean markField(int hor, int vert, Board board, ControlledFieldsBoard cfBoard) {

        if(board.getPiece(hor, vert) instanceof NoPiece) {
            cfBoard.markFieldAsControlled(hor, vert);
            return false;
        } else {
            cfBoard.markFieldAsControlled(hor, vert);
            return true;
        }
    }

    private void markVertical(int hor, int vert, Board board, ControlledFieldsBoard cfBoard) {

        for (int i = hor + 1; i < Board.BOARD_SIZE; i++) {
            if(markField(i, vert, board, cfBoard)) { break; }
        }
        for (int i = hor - 1; i >= 0; i--) {
            if(markField(i, vert, board, cfBoard)) { break; }
        }
    }

    private void markHorizontal(int hor, int vert, Board board, ControlledFieldsBoard cfBoard) {

        for (int i = vert + 1; i < Board.BOARD_SIZE; i++) {
            if(markField(hor, i, board, cfBoard)) { break; }
        }
        for (int i = vert - 1; i >= 0; i--) {
            if(markField(hor, i, board, cfBoard)) { break; }
        }
    }
}
