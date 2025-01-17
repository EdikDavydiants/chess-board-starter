package ed.d.chessboard.pieces;

import ed.d.chessboard.Board;
import ed.d.chessboard.ControlledFieldsBoard;
import ed.d.chessboard.Coord;

public class Queen extends AbstractPiece {


    public Queen(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public void markFieldsAsControlled(int hor, int vert, Board board, ControlledFieldsBoard cfBoard) {

        markHorizontal(hor, vert, board, cfBoard);
        markVertical(hor, vert, board, cfBoard);
        markPosDiagonal(hor, vert, board, cfBoard);
        markNegDiagonal(hor, vert, board, cfBoard);
    }

    @Override
    public AbstractPiece createClone() {
        return new Queen(isWhite());
    }

    @Override
    public boolean additionalChecking(Coord pieceCoord, Coord moveCoord, Board board) {
        return true;
    }

    private void markVertical(int hor, int vert, Board board, ControlledFieldsBoard cfBoard) {

        for (int i = 1; hor + i < Board.BOARD_SIZE; i++) {
            if(markField(hor + i, vert, board, cfBoard)) { break; }
        }
        for (int i = 1; hor - i >= 0; i++) {
            if(markField(hor - i, vert, board, cfBoard)) { break; }
        }
    }

    private void markHorizontal(int hor, int vert, Board board, ControlledFieldsBoard cfBoard) {

        for (int i = vert + 1; i < Board.BOARD_SIZE; i++) {
            if(markField(hor, i, board, cfBoard)) { break; }
        }
        for (int i = 1; vert - i >= 0; i++) {
            if(markField(hor, vert - i, board, cfBoard)) { break; }
        }
    }

    private void markPosDiagonal(int hor, int vert, Board board, ControlledFieldsBoard cfBoard) {

        for (int i = 1; hor + i < Board.BOARD_SIZE && vert + i < Board.BOARD_SIZE; i++) {
            if(markField(hor + i, vert + i, board, cfBoard)) { break; }
        }
        for (int i = 1; hor - i >= 0 && vert - i >= 0; i++) {
            if(markField(hor - i, vert - i, board, cfBoard)) { break; }
        }
    }

    private void markNegDiagonal(int hor, int vert, Board board, ControlledFieldsBoard cfBoard) {

        for (int i = 1; hor + i < Board.BOARD_SIZE && vert - i >= 0; i++) {
            if(markField(hor + i, vert - i, board, cfBoard)) { break; }
        }
        for (int i = 1; hor - i >= 0 && vert + i < Board.BOARD_SIZE; i++) {
            if(markField(hor - i, vert + i, board, cfBoard)) { break; }
        }
    }

    @Override
    public boolean isMoveGeometryCorrect(Coord pieceCoord, Coord moveCoord) {
        return pieceCoord.getHor() == moveCoord.getHor() ||
                pieceCoord.getVert() == moveCoord.getVert() ||
                Math.abs(pieceCoord.getHor() - moveCoord.getHor()) ==
                        Math.abs(pieceCoord.getVert() - moveCoord.getVert());
    }

    @Override
    public boolean obstacleChecking(Coord pieceCoord, Coord moveCoord, Board board) {
        return checkObstacleForLongRangePiece(pieceCoord, moveCoord, board);
    }
}
