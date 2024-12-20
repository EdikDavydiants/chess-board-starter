package ed.d.chessboard;

import ed.d.chessboard.pieces.AbstractPiece;
import ed.d.chessboard.pieces.Bishop;
import ed.d.chessboard.pieces.King;
import ed.d.chessboard.pieces.Knight;
import ed.d.chessboard.pieces.Pawn;
import ed.d.chessboard.pieces.Queen;
import ed.d.chessboard.pieces.Rook;
import org.junit.jupiter.api.Test;

import static ed.d.chessboard.pieces.NoPiece.noPiece;
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


	private Board getPositionFromByteArr(byte[][] position) {

		var board = new Board();
		for (int i = 0; i < Board.BOARD_SIZE; i++) {
			for (int k = 0; k < Board.BOARD_SIZE; k++) {
				board.setPiece(i, k, getPieceFromByte(position[i][k]));
			}
		}
		return board;
	}

	private AbstractPiece getPieceFromByte(byte pieceByte) {

		return switch (pieceByte) {
			case 'P' -> new Pawn(true);
			case 'N' -> new Knight(true);
			case 'B' -> new Bishop(true);
			case 'R' -> new Rook(true);
			case 'Q' -> new Queen(true);
			case 'K' -> new King(true);

			case 'p' -> new Pawn(false);
			case 'n' -> new Knight(false);
			case 'b' -> new Bishop(false);
			case 'r' -> new Rook(false);
			case 'q' -> new Queen(false);
			case 'k' -> new King(false);

			default -> noPiece;
		};
	}

}
