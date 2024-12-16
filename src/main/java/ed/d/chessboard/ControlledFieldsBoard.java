package ed.d.chessboard;

import lombok.Getter;

@Getter
public class ControlledFieldsBoard {

    private final int[][] fieldsArr;

    public ControlledFieldsBoard() {
        fieldsArr = new int[Board.BOARD_SIZE][Board.BOARD_SIZE];
    }

    public void markFieldAsControlled(int hor, int vert) {
        fieldsArr[hor][vert]++;
    }



}
