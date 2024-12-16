package ed.d.chessboard;

import ed.d.chessboard.pieces.Bishop;
import ed.d.chessboard.pieces.King;
import ed.d.chessboard.pieces.Knight;
import ed.d.chessboard.pieces.Pawn;
import ed.d.chessboard.pieces.Queen;
import ed.d.chessboard.pieces.Rook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

//@SpringBootTest
class ChessboardApplicationTests {


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

		board.markControlledFields(true, cfBoard);

		int[][] expectArray = {
				{0, 0, 1, 0, 0, 1, 0, 0},		//  {0, 0, 0, 0, 0, 0, 0, 0}
				{0, 0, 1, 0, 0, 1, 0, 0},		//  {0, 0, 0, 0, 0, 0, 0, 0}
				{1, 1, 2, 2, 2, 2, 1, 1},		//  {0, 0, r, 0, 0, r, 0, 0}
				{0, 0, 2, 0, 0, 2, 0, 0},		//  {0, 0, 0, 0, 0, 0, 0, 0}
				{0, 0, 2, 0, 0, 2, 0, 0},		//  {0, 0, 0, 0, 0, 0, 0, 0}
				{1, 1, 2, 2, 2, 2, 1, 1},		//  {0, 0, r, 0, 0, r, 0, 0}
				{0, 0, 1, 0, 0, 1, 0, 0},		//  {0, 0, 0, 0, 0, 0, 0, 0}
				{0, 0, 1, 0, 0, 1, 0, 0}		//  {0, 0, 0, 0, 0, 0, 0, 0}
		};
		assertArrayEquals(expectArray, cfBoard.getFieldsArr());
	}

	@Test
	void testBishop() {
		var board = new Board();

		var coord1 = new Coord(0, 0);
		var coord2 = new Coord(1, 4);
		var coord3 = new Coord(3, 6);
		var coord4 = new Coord(4, 1);
		var coord5 = new Coord(6, 3);

		board.setPiece(coord1, new Bishop(true));
		board.setPiece(coord2, new Bishop(true));
		board.setPiece(coord3, new Bishop(true));
		board.setPiece(coord4, new Bishop(true));
		board.setPiece(coord5, new Bishop(true));

		var cfBoard = new ControlledFieldsBoard();

		board.markControlledFields(true, cfBoard);

		int[][] expectArray = {
				{0, 0, 0, 1, 0, 1, 0, 0},		//  {b, 0, 0, 0, 0, 0, 0, 0}
				{0, 1, 0, 0, 2, 0, 0, 0},		//  {0, 0, 0, 0, b, 0, 0, 0}
				{0, 0, 1, 2, 0, 2, 0, 1},		//  {0, 0, 0, 0, 0, 0, 0, 0}
				{1, 0, 2, 1, 0, 0, 2, 0},		//  {0, 0, 0, 0, 0, 0, b, 0}
				{0, 2, 0, 0, 1, 2, 0, 1},		//  {0, b, 0, 0, 0, 0, 0, 0}
				{1, 0, 2, 0, 2, 1, 0, 0},		//  {0, 0, 0, 0, 0, 0, 0, 0}
				{0, 0, 0, 2, 0, 0, 1, 0},		//  {0, 0, 0, b, 0, 0, 0, 0}
				{0, 0, 1, 0, 1, 0, 0, 1}		//  {0, 0, 0, 0, 0, 0, 0, 0}
		};
		assertArrayEquals(expectArray, cfBoard.getFieldsArr());
	}

	@Test
	void testKing() {
		var board = new Board();

		var coord1 = new Coord(0, 0);
		var coord2 = new Coord(0, 4);
		var coord3 = new Coord(3, 4);
		var coord4 = new Coord(3, 7);
		var coord5 = new Coord(4, 3);
		var coord6 = new Coord(4, 5);
		var coord7 = new Coord(4, 6);
		var coord8 = new Coord(6, 1);

		board.setPiece(coord1, new King(true));
		board.setPiece(coord2, new King(true));
		board.setPiece(coord3, new King(true));
		board.setPiece(coord4, new King(true));
		board.setPiece(coord5, new King(true));
		board.setPiece(coord6, new King(true));
		board.setPiece(coord7, new King(true));
		board.setPiece(coord8, new King(true));

		var cfBoard = new ControlledFieldsBoard();

		board.markControlledFields(true, cfBoard);

		int[][] expectArray = {
				{0, 1, 0, 1, 0, 1, 0, 0},		//  {k, 0, 0, 0, k, 0, 0, 0}
				{1, 1, 0, 1, 1, 1, 0, 0},		//  {0, 0, 0, 0, 0, 0, 0, 0}
				{0, 0, 0, 1, 1, 1, 1, 1},		//  {0, 0, 0, 0, 0, 0, 0, 0}
				{0, 0, 1, 2, 2, 3, 3, 1},		//  {0, 0, 0, 0, k, 0, 0, k}
				{0, 0, 1, 1, 3, 2, 2, 2},		//  {0, 0, 0, k, 0, k, k, 0}
				{1, 1, 2, 1, 2, 2, 2, 1},		//  {0, 0, 0, 0, 0, 0, 0, 0}
				{1, 0, 1, 0, 0, 0, 0, 0},		//  {0, k, 0, 0, 0, 0, 0, 0}
				{1, 1, 1, 0, 0, 0, 0, 0}		//  {0, 0, 0, 0, 0, 0, 0, 0}
		};
		assertArrayEquals(expectArray, cfBoard.getFieldsArr());
	}

	@Test
	void testQueen() {
		var board = new Board();

		var coord1 = new Coord(2, 2);
		var coord2 = new Coord(2, 5);
		var coord3 = new Coord(5, 5);

		board.setPiece(coord1, new Queen(true));
		board.setPiece(coord2, new Queen(true));
		board.setPiece(coord3, new Queen(true));

		var cfBoard = new ControlledFieldsBoard();

		board.markControlledFields(true, cfBoard);

		int[][] expectArray = {
				{1, 0, 1, 1, 1, 1, 0, 1},		//  {0, 0, 0, 0, 0, 0, 0, 0}
				{0, 1, 1, 1, 1, 1, 1, 0},		//  {0, 0, 0, 0, 0, 0, 0, 0}
				{1, 1, 2, 2, 2, 2, 1, 1},		//  {0, 0, q, 0, 0, q, 0, 0}
				{0, 1, 1, 2, 1, 2, 1, 1},		//  {0, 0, 0, 0, 0, 0, 0, 0}
				{1, 0, 1, 1, 2, 2, 1, 1},		//  {0, 0, 0, 0, 0, 0, 0, 0}
				{1, 1, 3, 1, 1, 2, 1, 1},		//  {0, 0, 0, 0, 0, q, 0, 0}
				{0, 1, 1, 0, 1, 1, 1, 0},		//  {0, 0, 0, 0, 0, 0, 0, 0}
				{1, 0, 1, 1, 0, 1, 0, 1}		//  {0, 0, 0, 0, 0, 0, 0, 0}
		};
		assertArrayEquals(expectArray, cfBoard.getFieldsArr());
	}

	@Test
	void testKnight() {
		var board = new Board();

		var coord1 = new Coord(0, 0);
		var coord2 = new Coord(2, 4);
		var coord3 = new Coord(3, 6);
		var coord4 = new Coord(4, 0);
		var coord5 = new Coord(4, 3);
		var coord6 = new Coord(5, 5);

		board.setPiece(coord1, new Knight(true));
		board.setPiece(coord2, new Knight(true));
		board.setPiece(coord3, new Knight(true));
		board.setPiece(coord4, new Knight(true));
		board.setPiece(coord5, new Knight(true));
		board.setPiece(coord6, new Knight(true));

		var cfBoard = new ControlledFieldsBoard();

		board.markControlledFields(true, cfBoard);

		int[][] expectArray = {
				{0, 0, 0, 1, 0, 1, 0, 0},		//  {n, 0, 0, 0, 0, 0, 0, 0}
				{0, 0, 2, 0, 0, 1, 1, 1},		//  {0, 0, 0, 0, 0, 0, 0, 0}
				{0, 2, 1, 0, 2, 0, 0, 0},		//  {0, 0, 0, 0, n, 0, 0, 0}
				{0, 1, 2, 0, 1, 1, 2, 0},		//  {0, 0, 0, 0, 0, 0, n, 0}
				{0, 0, 0, 2, 1, 1, 0, 1},		//  {n, 0, 0, n, 0, 0, 0, 0}
				{0, 1, 1, 0, 0, 2, 0, 1},		//  {0, 0, 0, 0, 0, n, 0, 0}
				{0, 1, 1, 1, 1, 0, 0, 1},		//  {0, 0, 0, 0, 0, 0, 0, 0}
				{0, 0, 0, 0, 1, 0, 1, 0}		//  {0, 0, 0, 0, 0, 0, 0, 0}
		};
		assertArrayEquals(expectArray, cfBoard.getFieldsArr());
	}

	@Test
	void testPawn() {
		var board = new Board();

		var coord1 = new Coord(0, 3);
		var coord2 = new Coord(1, 0);
		var coord3 = new Coord(1, 6);
		var coord4 = new Coord(2, 1);
		var coord5 = new Coord(3, 1);
		var coord6 = new Coord(4, 2);
		var coord7 = new Coord(4, 3);
		var coord8 = new Coord(5, 1);
		var coord9 = new Coord(5, 2);
		var coord10 = new Coord(5, 5);
		var coord11 = new Coord(5, 7);
		var coord12 = new Coord(6, 0);
		var coord13 = new Coord(6, 5);
		var coord14 = new Coord(7, 7);

		board.setPiece(coord1, new Pawn(false));
		board.setPiece(coord2, new Pawn(true));
		board.setPiece(coord3, new Pawn(true));
		board.setPiece(coord4, new Pawn(true));
		board.setPiece(coord5, new Pawn(true));
		board.setPiece(coord6, new Pawn(true));
		board.setPiece(coord7, new Pawn(false));
		board.setPiece(coord8, new Pawn(false));
		board.setPiece(coord9, new Pawn(false));
		board.setPiece(coord10, new Pawn(false));
		board.setPiece(coord11, new Pawn(false));
		board.setPiece(coord12, new Pawn(false));
		board.setPiece(coord13, new Pawn(false));
		board.setPiece(coord14, new Pawn(true));

		var cfBoard = new ControlledFieldsBoard();

		board.markControlledFields(true, cfBoard);
		board.markControlledFields(false, cfBoard);

		int[][] expectArray = {
				{0, 0, 0, 0, 0, 0, 0, 0},		//  {0, 0, 0, b, 0, 0, 0, 0}  // white side
				{0, 0, 0, 0, 0, 0, 0, 0},		//  {w, 0, 0, 0, 0, 0, w, 0}
				{0, 1, 0, 0, 0, 1, 0, 1},		//  {0, w, 0, 0, 0, 0, 0, 0}
				{1, 0, 2, 0, 1, 0, 0, 0},		//  {0, w, 0, 0, 0, 0, 0, 0}
				{2, 1, 2, 1, 1, 0, 2, 0},		//  {0, 0, w, b, 0, 0, 0, 0}
				{0, 2, 0, 1, 1, 0, 1, 0},		//  {0, b, b, 0, 0, b, 0, b}
				{0, 0, 0, 0, 0, 0, 0, 0},		//  {b, 0, 0, 0, 0, b, 0, 0}
				{0, 0, 0, 0, 0, 0, 0, 0},		//  {0, 0, 0, 0, 0, 0, 0, w}  // black side
		};
		assertArrayEquals(expectArray, cfBoard.getFieldsArr());
	}
}
