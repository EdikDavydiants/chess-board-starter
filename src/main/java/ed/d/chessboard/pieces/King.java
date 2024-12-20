package ed.d.chessboard.pieces;

import ed.d.chessboard.Board;
import ed.d.chessboard.ControlledFieldsBoard;
import ed.d.chessboard.Coord;
import lombok.Getter;

import static ed.d.chessboard.pieces.NoPiece.noPiece;

@Getter
public class King extends AbstractPiece {

    private boolean hasBeenMoved = false;

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

    @Override
    public boolean isMoveGeometryCorrect(Coord pieceCoord, Coord moveCoord) {

        boolean isOrdinaryMove =
                pieceCoord.getHor() - moveCoord.getHor() <= 1 &&
                pieceCoord.getHor() - moveCoord.getHor() >= -1 &&
                pieceCoord.getVert() - moveCoord.getVert() <= 1 &&
                pieceCoord.getVert() - moveCoord.getVert() >= -1;

        if (isOrdinaryMove) { return true; }

        return isTryingCastling(pieceCoord, moveCoord);
    }

    @Override
    public boolean obstacleChecking(Coord pieceCoord, Coord moveCoord, Board board) {

        if (isTryingShortCastling(pieceCoord, moveCoord)) {
            if (isWhite()) {
                return board.getPiece(0, 5).isEmpty() &&
                        board.getPiece(0, 6).isEmpty();
            } else {
                return board.getPiece(Board.BOARD_SIZE - 1, 5).isEmpty() &&
                        board.getPiece(Board.BOARD_SIZE - 1, 6).isEmpty();
            }
        } else if (isTryingLongCastling(pieceCoord, moveCoord)) {
            if (isWhite()) {
                return board.getPiece(0, 1).isEmpty() &&
                        board.getPiece(0, 2).isEmpty();
            } else {
                return board.getPiece(Board.BOARD_SIZE - 1, 1).isEmpty() &&
                        board.getPiece(Board.BOARD_SIZE - 1, 2).isEmpty();
            }
        } else {
            var piece = board.getPiece(moveCoord.getHor(), moveCoord.getVert());
            return piece == noPiece || piece.isWhite() != isWhite();
        }
    }

    private boolean isTryingCastling(Coord pieceCoord, Coord moveCoord) {
        if (isWhite()) {
            return pieceCoord.getHor() == 0 && pieceCoord.getVert() == 5 &&
                    moveCoord.getHor() == 0 && (moveCoord.getVert() == 2 || moveCoord.getVert() == 6);
        } else {
            return pieceCoord.getHor() == Board.BOARD_SIZE - 1 && pieceCoord.getVert() == 5 &&
                    moveCoord.getHor() == Board.BOARD_SIZE - 1 && (moveCoord.getVert() == 2 || moveCoord.getVert() == 6);
        }
    }

    private boolean isTryingShortCastling(Coord pieceCoord, Coord moveCoord) {
        if (isWhite()) {
            return pieceCoord.getHor() == 0 && pieceCoord.getVert() == 5 &&
                    moveCoord.getHor() == 0 && moveCoord.getVert() == 6;
        } else {
            return pieceCoord.getHor() == Board.BOARD_SIZE - 1 && pieceCoord.getVert() == 5 &&
                    moveCoord.getHor() == Board.BOARD_SIZE - 1 && moveCoord.getVert() == 6;
        }
    }

    private boolean isTryingLongCastling(Coord pieceCoord, Coord moveCoord) {
        if (isWhite()) {
            return pieceCoord.getHor() == 0 && pieceCoord.getVert() == 5 &&
                    moveCoord.getHor() == 0 && moveCoord.getVert() == 2;
        } else {
            return pieceCoord.getHor() == Board.BOARD_SIZE - 1 && pieceCoord.getVert() == 5 &&
                    moveCoord.getHor() == Board.BOARD_SIZE - 1 && moveCoord.getVert() == 2;
        }
    }
}
