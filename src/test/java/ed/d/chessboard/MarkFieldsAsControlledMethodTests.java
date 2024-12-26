package ed.d.chessboard;

import org.junit.jupiter.api.Test;

import static ed.d.chessboard.TestUtils.getPositionFromByteArr;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MarkFieldsAsControlledMethodTests {


	@Test
	void testRook() {

		byte[][] posBytes = {
				{' ',' ',' ',' ',' ',' ',' ',' '},
				{' ',' ',' ',' ',' ',' ',' ',' '},
				{' ',' ','R',' ',' ','R',' ',' '},
				{' ',' ',' ',' ',' ',' ',' ',' '},
				{' ',' ',' ',' ',' ',' ',' ',' '},
				{' ',' ','R',' ',' ','R',' ',' '},
				{' ',' ',' ',' ',' ',' ',' ',' '},
				{' ',' ',' ',' ',' ',' ',' ',' '},
		};
		Board board = getPositionFromByteArr(posBytes);

		var cfBoard = new ControlledFieldsBoard();
		board.markControlledFields(true, cfBoard);

		int[][] expectArray = {
				{0, 0, 1, 0, 0, 1, 0, 0},
				{0, 0, 1, 0, 0, 1, 0, 0},
				{1, 1, 2, 2, 2, 2, 1, 1},
				{0, 0, 2, 0, 0, 2, 0, 0},
				{0, 0, 2, 0, 0, 2, 0, 0},
				{1, 1, 2, 2, 2, 2, 1, 1},
				{0, 0, 1, 0, 0, 1, 0, 0},
				{0, 0, 1, 0, 0, 1, 0, 0},
		};
		assertArrayEquals(expectArray, cfBoard.getFieldsArr());
	}

	@Test
	void testBishop() {

		byte[][] posBytes = {
				{'B',' ',' ',' ',' ',' ',' ',' '},
				{' ',' ',' ',' ','B',' ',' ',' '},
				{' ',' ',' ',' ',' ',' ',' ',' '},
				{' ',' ',' ',' ',' ',' ','B',' '},
				{' ','B',' ',' ',' ',' ',' ',' '},
				{' ',' ',' ',' ',' ',' ',' ',' '},
				{' ',' ',' ','B',' ',' ',' ',' '},
				{' ',' ',' ',' ',' ',' ',' ',' '},
		};
		Board board = getPositionFromByteArr(posBytes);

		var cfBoard = new ControlledFieldsBoard();
		board.markControlledFields(true, cfBoard);

		int[][] expectArray = {
				{0, 0, 0, 1, 0, 1, 0, 0},
				{0, 1, 0, 0, 2, 0, 0, 0},
				{0, 0, 1, 2, 0, 2, 0, 1},
				{1, 0, 2, 1, 0, 0, 2, 0},
				{0, 2, 0, 0, 1, 2, 0, 1},
				{1, 0, 2, 0, 2, 1, 0, 0},
				{0, 0, 0, 2, 0, 0, 1, 0},
				{0, 0, 1, 0, 1, 0, 0, 1},
		};
		assertArrayEquals(expectArray, cfBoard.getFieldsArr());
	}

	@Test
	void testKing() {

		byte[][] posBytes = {
				{'K',' ',' ',' ','K',' ',' ',' '},
				{' ',' ',' ',' ',' ',' ',' ',' '},
				{' ',' ',' ',' ',' ',' ',' ',' '},
				{' ',' ',' ',' ','K',' ',' ','K'},
				{' ',' ',' ','K',' ','K','K',' '},
				{' ',' ',' ',' ',' ',' ',' ',' '},
				{' ','K',' ',' ',' ',' ',' ',' '},
				{' ',' ',' ',' ',' ',' ',' ',' '},
		};
		Board board = getPositionFromByteArr(posBytes);

		var cfBoard = new ControlledFieldsBoard();
		board.markControlledFields(true, cfBoard);

		int[][] expectArray = {
				{0, 1, 0, 1, 0, 1, 0, 0},
				{1, 1, 0, 1, 1, 1, 0, 0},
				{0, 0, 0, 1, 1, 1, 1, 1},
				{0, 0, 1, 2, 2, 3, 3, 1},
				{0, 0, 1, 1, 3, 2, 2, 2},
				{1, 1, 2, 1, 2, 2, 2, 1},
				{1, 0, 1, 0, 0, 0, 0, 0},
				{1, 1, 1, 0, 0, 0, 0, 0},
		};
		assertArrayEquals(expectArray, cfBoard.getFieldsArr());
	}

	@Test
	void testQueen() {

		byte[][] posBytes = {
				{' ',' ',' ',' ',' ',' ',' ',' '},
				{' ',' ',' ',' ',' ',' ',' ',' '},
				{' ',' ','Q',' ',' ','Q',' ',' '},
				{' ',' ',' ',' ',' ',' ',' ',' '},
				{' ',' ',' ',' ',' ',' ',' ',' '},
				{' ',' ',' ',' ',' ','Q',' ',' '},
				{' ',' ',' ',' ',' ',' ',' ',' '},
				{' ',' ',' ',' ',' ',' ',' ',' '},
		};
		Board board = getPositionFromByteArr(posBytes);

		var cfBoard = new ControlledFieldsBoard();
		board.markControlledFields(true, cfBoard);

		int[][] expectArray = {
				{1, 0, 1, 1, 1, 1, 0, 1},
				{0, 1, 1, 1, 1, 1, 1, 0},
				{1, 1, 2, 2, 2, 2, 1, 1},
				{0, 1, 1, 2, 1, 2, 1, 1},
				{1, 0, 1, 1, 2, 2, 1, 1},
				{1, 1, 3, 1, 1, 2, 1, 1},
				{0, 1, 1, 0, 1, 1, 1, 0},
				{1, 0, 1, 1, 0, 1, 0, 1},
		};
		assertArrayEquals(expectArray, cfBoard.getFieldsArr());
	}

	@Test
	void testKnight() {

		byte[][] posBytes = {
				{'N',' ',' ',' ',' ',' ',' ',' '},
				{' ',' ',' ',' ',' ',' ',' ',' '},
				{' ',' ',' ',' ','N',' ',' ',' '},
				{' ',' ',' ',' ',' ',' ','N',' '},
				{'N',' ',' ','N',' ',' ',' ',' '},
				{' ',' ',' ',' ',' ','N',' ',' '},
				{' ',' ',' ',' ',' ',' ',' ',' '},
				{' ',' ',' ',' ',' ',' ',' ',' '},
		};
		Board board = getPositionFromByteArr(posBytes);

		var cfBoard = new ControlledFieldsBoard();
		board.markControlledFields(true, cfBoard);

		int[][] expectArray = {
				{0, 0, 0, 1, 0, 1, 0, 0},
				{0, 0, 2, 0, 0, 1, 1, 1},
				{0, 2, 1, 0, 2, 0, 0, 0},
				{0, 1, 2, 0, 1, 1, 2, 0},
				{0, 0, 0, 2, 1, 1, 0, 1},
				{0, 1, 1, 0, 0, 2, 0, 1},
				{0, 1, 1, 1, 1, 0, 0, 1},
				{0, 0, 0, 0, 1, 0, 1, 0},
		};
		assertArrayEquals(expectArray, cfBoard.getFieldsArr());
	}

	@Test
	void testPawn() {

		byte[][] posBytes = {
				{' ',' ',' ','p',' ',' ',' ',' '},	// white side
				{'P',' ',' ',' ',' ',' ','P',' '},
				{' ','P',' ',' ',' ',' ',' ',' '},
				{' ','P',' ',' ',' ',' ',' ',' '},
				{' ',' ','P','p',' ',' ',' ',' '},
				{' ','p','p',' ',' ','p',' ','p'},
				{'p',' ',' ',' ',' ','p',' ',' '},
				{' ',' ',' ',' ',' ',' ',' ','P'},
		};
		Board board = getPositionFromByteArr(posBytes);

		var cfBoard = new ControlledFieldsBoard();
		board.markControlledFields(true, cfBoard);
		board.markControlledFields(false, cfBoard);

		int[][] expectArray = {
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 1, 0, 0, 0, 1, 0, 1},
				{1, 0, 2, 0, 1, 0, 0, 0},
				{2, 1, 2, 1, 1, 0, 2, 0},
				{0, 2, 0, 1, 1, 0, 1, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
		};
		assertArrayEquals(expectArray, cfBoard.getFieldsArr());
	}
}
