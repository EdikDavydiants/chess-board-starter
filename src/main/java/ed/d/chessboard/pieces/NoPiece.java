package ed.d.chessboard.pieces;

import ed.d.chessboard.Board;
import ed.d.chessboard.ControlledFieldsBoard;

public class NoPiece extends AbstractPiece {

    public static final NoPiece noPiece = new NoPiece();

    private NoPiece() {
        super(true);
    }

    @Override
    public void markFieldsAsControlled(int hor, int vert, Board board, ControlledFieldsBoard cfBoard) {

    }

    @Override
    public boolean isWhite() {
        throw new RuntimeException("Empty field has no piece color!");
    }
}
