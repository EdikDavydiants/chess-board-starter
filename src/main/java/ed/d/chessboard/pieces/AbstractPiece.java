package ed.d.chessboard.pieces;

import ed.d.chessboard.Board;
import ed.d.chessboard.ControlledFieldsBoard;
import ed.d.chessboard.Coord;
import lombok.Getter;

@Getter
public abstract class AbstractPiece {

    private final boolean isWhite;

    protected AbstractPiece(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public abstract ControlledFieldsBoard markFieldsAsControlled(Coord pieceCoord,
                                                                 Board board, ControlledFieldsBoard cfBoard);
}
