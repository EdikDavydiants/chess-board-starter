package ed.d.chessboard.pieces;

import ed.d.chessboard.Board;
import ed.d.chessboard.ControlledFieldsBoard;
import ed.d.chessboard.Coord;

public class NoPiece extends AbstractPiece {

    public static final NoPiece noPiece = new NoPiece();

    private NoPiece() {
        super(true);
    }

    @Override
    public ControlledFieldsBoard markFieldsAsControlled(Coord pieceCoord, Board board, ControlledFieldsBoard cfBoard) {
        return cfBoard;
    }

    @Override
    public boolean isWhite() {
        throw new RuntimeException("Empty field has no piece color!");
    }
}
