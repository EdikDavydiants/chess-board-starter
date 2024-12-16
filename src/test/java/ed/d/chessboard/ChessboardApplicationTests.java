package ed.d.chessboard;

import ed.d.chessboard.pieces.Rook;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@SpringBootTest
class ChessboardApplicationTests {

	@Test
	void contextLoads() {
	}


	@Test
	void testRook() {
		var board = new Board();

		var coord1 = new Coord(2, 2);
		var coord2 = new Coord(2, 5);
		var coord3 = new Coord(5, 2);
		var coord4 = new Coord(5, 5);

		board.setPiece(coord1, new Rook(true));
		board.setPiece(coord2, new Rook(true));
		board.setPiece(coord3, new Rook(true));
		board.setPiece(coord4, new Rook(true));

		var cfBoard = new ControlledFieldsBoard();

		cfBoard = board.getPiece(coord1).markFieldsAsControlled(coord1, board, cfBoard);
		cfBoard = board.getPiece(coord2).markFieldsAsControlled(coord2, board, cfBoard);
		cfBoard = board.getPiece(coord3).markFieldsAsControlled(coord3, board, cfBoard);
		cfBoard = board.getPiece(coord4).markFieldsAsControlled(coord4, board, cfBoard);

		int[][] expectArray = {
				{0, 0, 1, 0, 0, 1, 0, 0},
				{0, 0, 1, 0, 0, 1, 0, 0},
				{1, 1, 2, 2, 2, 2, 1, 1},
				{0, 0, 2, 0, 0, 2, 0, 0},
				{0, 0, 2, 0, 0, 2, 0, 0},
				{1, 1, 2, 2, 2, 2, 1, 1},
				{0, 0, 1, 0, 0, 1, 0, 0},
				{0, 0, 1, 0, 0, 1, 0, 0}
		};
		assertArrayEquals(expectArray, cfBoard.getFieldsArr());
	}

}
