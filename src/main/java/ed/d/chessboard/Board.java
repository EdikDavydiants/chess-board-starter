package ed.d.chessboard;

import ed.d.chessboard.pieces.AbstractPiece;
import ed.d.chessboard.pieces.Bishop;
import ed.d.chessboard.pieces.Utils;

import static ed.d.chessboard.pieces.NoPiece.noPiece;
import static ed.d.chessboard.pieces.Utils.boardIteration;

public class Board {

    public static final int BOARD_SIZE = 8;

    private final AbstractPiece[][] pieceArr;


    private Board() {
        pieceArr = new AbstractPiece[BOARD_SIZE][BOARD_SIZE];
        setEmptyPosition();
    }

    public static Board createEmptyBoard() {
        return new Board();
    }

    public static Board createCloneBoard(Board board) {

        final var boardClone = new Board();
        boardIteration((i, k) -> boardClone.setPiece(i, k, board.getPiece(i, k).createClone()));
        return boardClone;
    }

    public boolean isKingUnderAttackAfterMove(Coord pieceCoord, Coord moveCoord) {

        var cloneBoard = Board.createCloneBoard(this);

        makeMove(pieceCoord, moveCoord);

        return false;
    }

    private void makeMove(Coord pieceCoord, Coord moveCoord) {

    }

    public void markControlledFields(boolean isWhite, ControlledFieldsBoard cfBoard) {

        boardIteration((i, k) -> {
            if (pieceArr[i][k] != noPiece && pieceArr[i][k].isWhite() == isWhite) {
                pieceArr[i][k].markFieldsAsControlled(i, k, this, cfBoard);
            }
        });
    }

    public void setEmptyPosition() {
        boardIteration((i, k) -> pieceArr[i][k] = noPiece);
    }

    public boolean isOutOfBounds(int hor, int vert) {
        return hor >= Board.BOARD_SIZE || vert >= Board.BOARD_SIZE || hor < 0 || vert < 0;
    }

    public void setPiece(int hor, int vert, AbstractPiece piece) {
        pieceArr[hor][vert] = piece;
    }

    public void setPiece(Coord coord, AbstractPiece piece) {
        pieceArr[coord.getHor()][coord.getVert()] = piece;
    }

    public AbstractPiece getPiece(int hor, int vert) {
        return pieceArr[hor][vert];
    }

    public AbstractPiece getPiece(Coord coord) {
        return pieceArr[coord.getHor()][coord.getVert()];
    }
}
