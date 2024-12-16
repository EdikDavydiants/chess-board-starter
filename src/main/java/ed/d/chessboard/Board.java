package ed.d.chessboard;

import ed.d.chessboard.pieces.AbstractPiece;

import static ed.d.chessboard.pieces.NoPiece.noPiece;

public class Board {

    public static final int BOARD_SIZE = 8;

    private final AbstractPiece[][] pieceArr;


    public Board() {
        pieceArr = new AbstractPiece[BOARD_SIZE][BOARD_SIZE];
        createEmptyBoard();
    }


    public void createEmptyBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int k = 0; k < BOARD_SIZE; k++) {
                pieceArr[i][k] = noPiece;
            }
        }
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
