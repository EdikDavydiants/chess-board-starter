package ed.d.chessboard.pieces;

import ed.d.chessboard.Board;
import ed.d.chessboard.ControlledFieldsBoard;
import ed.d.chessboard.Coord;

import static ed.d.chessboard.pieces.NoPiece.noPiece;

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

    @Override
    public AbstractPiece createClone() {
        return new Knight(isWhite());
    }

    @Override
    public boolean additionalChecking(Coord pieceCoord, Coord moveCoord, Board board) {
        return true;
    }

    @Override
    public boolean isMoveGeometryCorrect(Coord pieceCoord, Coord moveCoord) {
        int absHorDelta = Math.abs(pieceCoord.getHor() - moveCoord.getHor());
        int absVertDelta = Math.abs(pieceCoord.getVert() - moveCoord.getVert());
        return (absHorDelta == 1 && absVertDelta == 2) || (absHorDelta == 2 && absVertDelta == 1);
    }

    @Override
    public boolean obstacleChecking(Coord pieceCoord, Coord moveCoord, Board board) {

        var piece = board.getPiece(moveCoord.getHor(), moveCoord.getVert());
        return piece == noPiece || piece.isWhite() != isWhite();
    }
}
