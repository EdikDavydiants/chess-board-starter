package ed.d.chessboard.pieces;

import ed.d.chessboard.Board;
import ed.d.chessboard.ControlledFieldsBoard;

public class Knight extends AbstractPiece {

    public Knight(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public void markFieldsAsControlled(int hor, int vert, Board board, ControlledFieldsBoard cfBoard) {

        markFieldIfNotOutOfBounds(hor + 2, vert + 1, board, cfBoard);
        markFieldIfNotOutOfBounds(hor + 2, vert - 1, board, cfBoard);
        markFieldIfNotOutOfBounds(hor + 1, vert + 2, board, cfBoard);
        markFieldIfNotOutOfBounds(hor + 1, vert - 2, board, cfBoard);

        markFieldIfNotOutOfBounds(hor - 2, vert + 1, board, cfBoard);
        markFieldIfNotOutOfBounds(hor - 2, vert - 1, board, cfBoard);
        markFieldIfNotOutOfBounds(hor - 1, vert + 2, board, cfBoard);
        markFieldIfNotOutOfBounds(hor - 1, vert - 2, board, cfBoard);
    }
}
