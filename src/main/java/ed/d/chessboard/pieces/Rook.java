package ed.d.chessboard.pieces;

import ed.d.chessboard.Board;
import ed.d.chessboard.ControlledFieldsBoard;
import ed.d.chessboard.Coord;
import lombok.Getter;

@Getter
public class Rook extends AbstractPiece {

    private boolean hasBeenMoved = false;

    public Rook(boolean isWhite) {
        super(isWhite);
    }


    @Override
    public void markFieldsAsControlled(int hor, int vert, Board board, ControlledFieldsBoard cfBoard) {

        markHorizontal(hor, vert, board, cfBoard);
        markVertical(hor, vert, board, cfBoard);
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

    @Override
    public boolean isMoveGeometryCorrect(Coord pieceCoord, Coord moveCoord) {
        return pieceCoord.getHor() == moveCoord.getHor() ||
                pieceCoord.getVert() == moveCoord.getVert();
    }

    @Override
    public boolean obstacleChecking(Coord pieceCoord, Coord moveCoord, Board board) {
        return checkObstacleForLongRangePiece(pieceCoord, moveCoord, board);
    }
}
