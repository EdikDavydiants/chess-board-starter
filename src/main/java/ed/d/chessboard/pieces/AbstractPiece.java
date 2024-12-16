package ed.d.chessboard.pieces;

import ed.d.chessboard.Board;
import ed.d.chessboard.ControlledFieldsBoard;
import lombok.Getter;

import static ed.d.chessboard.pieces.NoPiece.noPiece;

@Getter
public abstract class AbstractPiece {

    private final boolean isWhite;

    protected AbstractPiece(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public abstract void markFieldsAsControlled(int hor, int vert, Board board, ControlledFieldsBoard cfBoard);

    protected boolean markField(int hor, int vert, Board board, ControlledFieldsBoard cfBoard) {

        if(board.getPiece(hor, vert) == noPiece) {
            cfBoard.markFieldAsControlled(hor, vert);
            return false;
        } else {
            cfBoard.markFieldAsControlled(hor, vert);
            return true;
        }
    }

    protected void markFieldIfNotOutOfBounds(int hor, int vert, Board board, ControlledFieldsBoard cfBoard) {

        if(hor < Board.BOARD_SIZE && vert < Board.BOARD_SIZE && hor >= 0 && vert >= 0) {
            markField(hor, vert, board, cfBoard);
        }
    }
}
