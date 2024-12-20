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
    public void markFieldsAsControlled(int hor, int vert, Board board, ControlledFieldsBoard cfBoard) {

    }

    @Override
    public boolean isMoveGeometryCorrect(Coord pieceCoord, Coord moveCoord) {
        return false;
    }

    @Override
    public boolean obstacleChecking(Coord pieceCoord, Coord moveCoord, Board board) {
        return false;
    }

    @Override
    public boolean isWhite() {
        throw new RuntimeException("Empty field has no piece color!");
    }
}
