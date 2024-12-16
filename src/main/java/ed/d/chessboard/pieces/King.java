package ed.d.chessboard.pieces;

import ed.d.chessboard.Board;
import ed.d.chessboard.ControlledFieldsBoard;

public class King extends AbstractPiece {

    public King(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public void markFieldsAsControlled(int hor, int vert, Board board, ControlledFieldsBoard cfBoard) {

        markFieldIfNotOutOfBounds(hor + 1, vert + 1, board, cfBoard);
        markFieldIfNotOutOfBounds(hor + 1, vert - 1, board, cfBoard);
        markFieldIfNotOutOfBounds(hor - 1, vert + 1, board, cfBoard);
        markFieldIfNotOutOfBounds(hor - 1, vert - 1, board, cfBoard);

        markFieldIfNotOutOfBounds(hor + 1, vert, board, cfBoard);
        markFieldIfNotOutOfBounds(hor - 1, vert, board, cfBoard);
        markFieldIfNotOutOfBounds(hor, vert + 1, board, cfBoard);
        markFieldIfNotOutOfBounds(hor, vert - 1, board, cfBoard);
    }
}
