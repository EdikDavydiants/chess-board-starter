package ed.d.chessboard.pieces;

import ed.d.chessboard.Board;
import ed.d.chessboard.ControlledFieldsBoard;
import ed.d.chessboard.Coord;
import lombok.Getter;

import static ed.d.chessboard.pieces.NoPiece.noPiece;

@Getter
public class Pawn extends AbstractPiece {

    private boolean isTheLastMoveLong = false;

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

    @Override
    public boolean isMoveGeometryCorrect(Coord pieceCoord, Coord moveCoord) {
        int horDelta = moveCoord.getHor() - pieceCoord.getHor();
        int vertDelta = moveCoord.getHor() - pieceCoord.getHor();
        if (isWhite()) {
            if (pieceCoord.getHor() == 1) {
                return vertDelta == 0 && (horDelta == 2 || horDelta == 1) ||
                        Math.abs(vertDelta) == 1 && horDelta == 1;
            } else {
                return vertDelta == 0 && horDelta == 1 ||
                        Math.abs(vertDelta) == 1 && horDelta == 1;
            }
        } else {
            if (pieceCoord.getHor() == Board.BOARD_SIZE - 2) {
                return vertDelta == 0 && (horDelta == -2 || horDelta == -1) ||
                        Math.abs(vertDelta) == 1 && horDelta == -1;
            } else {
                return vertDelta == 0 && horDelta == -1 ||
                        Math.abs(vertDelta) == 1 && horDelta == -1;
            }
        }
    }

    @Override
    public boolean obstacleChecking(Coord pieceCoord, Coord moveCoord, Board board) {

        if (Math.abs(pieceCoord.getHor() - moveCoord.getHor()) == 2) {
            int hor = (moveCoord.getHor() + pieceCoord.getHor()) / 2;
            int vert = moveCoord.getVert();
            if (board.getPiece(hor, vert) != noPiece) {
                return false;
            }
            hor = moveCoord.getHor();
            if (board.getPiece(hor, vert) != noPiece) {
                return false;
            }
        } else if (Math.abs(pieceCoord.getHor() - moveCoord.getHor()) == 1 &&
                pieceCoord.getVert() - moveCoord.getVert() == 0) {
            if (board.getPiece(moveCoord.getHor(), moveCoord.getVert()) != noPiece) {
                return false;
            }
        } else {
            int hor = moveCoord.getHor();
            int vert = moveCoord.getVert();
            if (board.getPiece(hor, vert).isNoEmptyAndColorIs(isWhite())) {
                return false;
            } else if (board.getPiece(hor, vert).isEmpty()) {
                AbstractPiece piece = board.getPiece(pieceCoord.getHor(), moveCoord.getVert());
                return piece.isTheLastMoveLongIfPawn() && piece.isWhite() != isWhite();
            }
        }
        return true;
    }
}
