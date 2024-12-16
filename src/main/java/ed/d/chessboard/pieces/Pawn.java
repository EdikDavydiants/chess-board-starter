package ed.d.chessboard.pieces;

import ed.d.chessboard.Board;
import ed.d.chessboard.ControlledFieldsBoard;

public class Pawn extends AbstractPiece {

    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public void markFieldsAsControlled(int hor, int vert, Board board, ControlledFieldsBoard cfBoard) {

        if (isWhite()) {
            markFieldIfNotOutOfBounds(hor + 1, vert + 1, board, cfBoard);
            markFieldIfNotOutOfBounds(hor + 1, vert - 1, board, cfBoard);
        } else {
            markFieldIfNotOutOfBounds(hor - 1, vert + 1, board, cfBoard);
            markFieldIfNotOutOfBounds(hor - 1, vert - 1, board, cfBoard);
        }
    }
}
