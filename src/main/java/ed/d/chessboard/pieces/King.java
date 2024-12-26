package ed.d.chessboard.pieces;

import ed.d.chessboard.Board;
import ed.d.chessboard.ControlledFieldsBoard;
import ed.d.chessboard.Coord;
import lombok.Getter;

import static ed.d.chessboard.Board.BOARD_SIZE;
import static ed.d.chessboard.pieces.NoPiece.noPiece;

@Getter
public class King extends AbstractPiece {

    private boolean hasBeenMoved;

    public King(boolean isWhite, boolean hasBeenMoved) {
        super(isWhite);
        this.hasBeenMoved = hasBeenMoved;
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
    public AbstractPiece createClone() {
        return new King(isWhite(), hasBeenMoved);
    }

    @Override
    public boolean additionalChecking(Coord pieceCoord, Coord moveCoord, Board board) {

        if (isTryingCastling(pieceCoord, moveCoord)) {
            return !isKingUnderAttackBeforeMove(pieceCoord, board) && !isHasBeenMoved();
        }
        return true;
    }

    private boolean isKingUnderAttackBeforeMove(Coord pieceCoord, Board board) {

        var cfBoard = new ControlledFieldsBoard();
        board.markControlledFields(!isWhite(), cfBoard);
        return cfBoard.getFieldsArr()[pieceCoord.getHor()][pieceCoord.getVert()] != 0;
    }

    @Override
    public boolean isMoveGeometryCorrect(Coord pieceCoord, Coord moveCoord) {
        return isOrdinaryMove(pieceCoord, moveCoord) || isTryingCastling(pieceCoord, moveCoord);
    }

    private boolean isOrdinaryMove(Coord pieceCoord, Coord moveCoord) {
        return pieceCoord.getHor() - moveCoord.getHor() <= 1 &&
               pieceCoord.getHor() - moveCoord.getHor() >= -1 &&
               pieceCoord.getVert() - moveCoord.getVert() <= 1 &&
               pieceCoord.getVert() - moveCoord.getVert() >= -1;
    }

    @Override
    public boolean obstacleChecking(Coord pieceCoord, Coord moveCoord, Board board) {

        if (isOrdinaryMove(pieceCoord, moveCoord)) {
            var piece = board.getPiece(moveCoord.getHor(), moveCoord.getVert());
            return piece == noPiece || piece.isWhite() != isWhite();
        }

        if (isTryingCastling(pieceCoord, moveCoord)) {
            Coord[] coords = getFieldsMustBeEmptyForCastling(isTryingShortCastling(pieceCoord, moveCoord));
            for (Coord coord : coords) {
                if (!board.getPiece(coord).isEmpty()) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isTryingCastling(Coord pieceCoord, Coord moveCoord) {

        int hor;
        if (isWhite()) { hor = 0; }
        else { hor = BOARD_SIZE - 1; }

        return pieceCoord.getHor() == hor && pieceCoord.getVert() == 3 &&
                moveCoord.getHor() == hor && (moveCoord.getVert() == 1 || moveCoord.getVert() == 5);
    }

    private boolean isTryingShortCastling(Coord pieceCoord, Coord moveCoord) {

        int hor;
        if (isWhite()) { hor = 0; }
        else { hor = BOARD_SIZE - 1; }

        return pieceCoord.getHor() == hor && pieceCoord.getVert() == 3 &&
                moveCoord.getHor() == hor && moveCoord.getVert() == 1;
    }

    private boolean isTryingLongCastling(Coord pieceCoord, Coord moveCoord) {

        int hor;
        if (isWhite()) { hor = 0; }
        else { hor = BOARD_SIZE - 1; }

        return pieceCoord.getHor() == hor && pieceCoord.getVert() == 3 &&
                moveCoord.getHor() == hor && moveCoord.getVert() == 5;
    }

    private boolean isCastleCorrect(Coord pieceCoord, Coord moveCoord, Board board) {

        int hor = pieceCoord.getHor();
        boolean isTryingShortCastling = isTryingShortCastling(pieceCoord, moveCoord);
        if (isTryingShortCastling) {
            if (isRookThatHasMoved(board.getPiece(hor, 0))) {
                return false;
            }
        } else {
            if (isRookThatHasMoved(board.getPiece(hor, BOARD_SIZE))) {
                return false;
            }
        }

        var cfBoard = new ControlledFieldsBoard();
        board.markControlledFields(!isWhite(), cfBoard);

        Coord[] coords = getFieldsMustBeNotAttackedForCastling(isTryingShortCastling);

        for (Coord coord : coords) {
            if (cfBoard.getFieldsArr()[coord.getHor()][coord.getVert()] != 0) {
                return false;
            }
        }

        return true;
    }

    private boolean isRookThatHasMoved(AbstractPiece piece) {
        if (piece instanceof Rook rook) {
            return rook.isHasBeenMoved();
        } else { return false; }
    }

    private Coord[] getFieldsMustBeNotAttackedForCastling(boolean isShortCastling) {

        if (isWhite()) {
            if (isShortCastling) {
                return new Coord[] {new Coord(0, 1), new Coord(0, 2)};
            } else {
                return new Coord[] {new Coord(0, 5), new Coord(0, 4)};
            }
        } else {
            if (isShortCastling) {
                return new Coord[] {new Coord(7, 1), new Coord(7, 2)};
            } else {
                return new Coord[] {new Coord(7, 5), new Coord(7, 4)};
            }
        }
    }

    private Coord[] getFieldsMustBeEmptyForCastling(boolean isShortCastling) {

        if (isWhite()) {
            if (isShortCastling) {
                return new Coord[] {new Coord(0, 1), new Coord(0, 2)};
            } else {
                return new Coord[] {new Coord(0, 6), new Coord(0, 5), new Coord(0, 4)};
            }
        } else {
            if (isShortCastling) {
                return new Coord[] {new Coord(7, 1), new Coord(7, 2)};
            } else {
                return new Coord[] {new Coord(7, 6), new Coord(7, 5), new Coord(7, 4)};
            }
        }
    }
}
