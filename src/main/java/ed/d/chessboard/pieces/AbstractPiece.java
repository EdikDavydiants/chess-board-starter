package ed.d.chessboard.pieces;

import ed.d.chessboard.Board;
import ed.d.chessboard.ControlledFieldsBoard;
import ed.d.chessboard.Coord;
import lombok.Getter;

import static ed.d.chessboard.pieces.NoPiece.noPiece;

@Getter
public abstract class AbstractPiece {

    private final boolean isWhite;

    protected AbstractPiece(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public abstract void markFieldsAsControlled(int hor, int vert, Board board, ControlledFieldsBoard cfBoard);

    public boolean isMoveCorrect(Coord pieceCoord, Coord moveCoord, Board board) {
        if (board.isOutOfBounds(moveCoord.getHor(), moveCoord.getVert())) {
            throw new RuntimeException("Move coord is out of bounds!");
        }
        if (pieceCoord.equals(moveCoord)) { return false; }
        if (!isMoveGeometryCorrect(pieceCoord, moveCoord)) { return false; }
        if (!obstacleChecking(pieceCoord, moveCoord, board)) { return false; }
        if (!additionalChecking(pieceCoord, moveCoord, board)) { return false; }
        //if (!board.isKingUnderAttackAfterMove(pieceCoord, moveCoord)) { return false; }
        return true;
    }

    public abstract AbstractPiece createClone();

    public abstract boolean additionalChecking(Coord pieceCoord, Coord moveCoord, Board board);

    public abstract boolean isMoveGeometryCorrect(Coord pieceCoord, Coord moveCoord);

    public abstract boolean obstacleChecking(Coord pieceCoord, Coord moveCoord, Board board);

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

        if (!board.isOutOfBounds(hor, vert)) {
            markField(hor, vert, board, cfBoard);
        }
    }

    public boolean checkObstacleForLongRangePiece(Coord pieceCoord, Coord moveCoord, Board board) {

        int i = pieceCoord.getHor();
        int k = pieceCoord.getVert();
        final int itrI = (int) Math.signum(moveCoord.getHor() - pieceCoord.getHor());
        final int itrK = (int) Math.signum(moveCoord.getVert() - pieceCoord.getVert());

        while (i != moveCoord.getHor() || k != moveCoord.getVert()) {
            i += itrI;
            k += itrK;
            AbstractPiece piece = board.getPiece(i, k);
            if (piece != noPiece && piece.isWhite() == isWhite) {
                return false;
            } else if (piece != noPiece) {
                if (i != moveCoord.getHor() || k != moveCoord.getVert()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return this == noPiece;
    }

    public boolean isNoEmptyAndColorIs(boolean isWhite) {
        return !isEmpty() && this.isWhite == isWhite;
    }

    protected boolean isTheLastMoveLongIfPawn() {
        if (this instanceof Pawn pawn) {
            return pawn.isTheLastMoveLong();
        } else { return false; }
    }
}
