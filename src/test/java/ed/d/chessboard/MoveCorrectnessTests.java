package ed.d.chessboard;

import ed.d.chessboard.pieces.Pawn;
import org.junit.jupiter.api.Test;

import static ed.d.chessboard.TestUtils.getPositionFromByteArr;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoveCorrectnessTests {

    @Test
    void testRook() {

        byte[][] posBytes = {
                //0   1   2   3   4   5   6   7
                {' ',' ',' ',' ',' ',' ',' ',' '},// 0
                {' ',' ',' ',' ',' ',' ',' ',' '},// 1
                {' ',' ','R',' ',' ','p',' ',' '},// 2
                {' ',' ',' ',' ',' ',' ',' ',' '},// 3
                {' ',' ',' ',' ',' ',' ',' ',' '},// 4
                {' ','p',' ','p',' ','R',' ',' '},// 5
                {' ',' ','P',' ',' ',' ',' ',' '},// 6
                {' ',' ',' ',' ',' ',' ',' ',' '},// 7
        };
        Board board = getPositionFromByteArr(posBytes);

        var rookCoord = new Coord(2, 2);
        var rook = board.getPiece(rookCoord);
        assertFalse(rook.isMoveCorrect(rookCoord, new Coord(2, 2), board));
        assertFalse(rook.isMoveCorrect(rookCoord, new Coord(1, 1), board));
        assertFalse(rook.isMoveCorrect(rookCoord, new Coord(3, 3), board));
        assertTrue(rook.isMoveCorrect(rookCoord, new Coord(2, 3), board));
        assertTrue(rook.isMoveCorrect(rookCoord, new Coord(2, 1), board));
        assertTrue(rook.isMoveCorrect(rookCoord, new Coord(2, 5), board));
        assertFalse(rook.isMoveCorrect(rookCoord, new Coord(2, 6), board));
        assertFalse(rook.isMoveCorrect(rookCoord, new Coord(6, 2), board));
        assertFalse(rook.isMoveCorrect(rookCoord, new Coord(7, 2), board));

        rookCoord = new Coord(5, 5);
        rook = board.getPiece(rookCoord);
        assertFalse(rook.isMoveCorrect(rookCoord, new Coord(0, 5), board));
        assertFalse(rook.isMoveCorrect(rookCoord, new Coord(5, 1), board));

        final var rookCoord_ = new Coord(5, 5);
        final var piece_ = board.getPiece(rookCoord);
        assertThrows(RuntimeException.class, () -> piece_.isMoveCorrect(rookCoord_, new Coord(8, 5), board));
        assertThrows(RuntimeException.class, () -> piece_.isMoveCorrect(rookCoord_, new Coord(-1, 5), board));
        assertThrows(RuntimeException.class, () -> piece_.isMoveCorrect(rookCoord_, new Coord(5, -1), board));
        assertThrows(RuntimeException.class, () -> piece_.isMoveCorrect(rookCoord_, new Coord(5, 8), board));
        assertThrows(RuntimeException.class, () -> piece_.isMoveCorrect(rookCoord_, new Coord(8, 8), board));
    }

    @Test
    void testBishop() {

        byte[][] posBytes = {
                //0   1   2   3   4   5   6   7
                {' ',' ',' ',' ',' ',' ',' ',' '},// 0
                {' ',' ',' ',' ',' ',' ',' ',' '},// 1
                {' ',' ','B',' ',' ',' ',' ',' '},// 2
                {' ','p',' ',' ',' ',' ',' ','P'},// 3
                {' ',' ',' ',' ',' ',' ',' ',' '},// 4
                {' ',' ',' ',' ',' ','b',' ',' '},// 5
                {' ',' ',' ',' ',' ',' ',' ',' '},// 6
                {'P',' ',' ','p',' ',' ',' ',' '},// 7
        };
        Board board = getPositionFromByteArr(posBytes);

        var bishopCoord = new Coord(2, 2);
        var bishop = board.getPiece(bishopCoord);
        assertFalse(bishop.isMoveCorrect(bishopCoord, new Coord(2, 1), board));
        assertFalse(bishop.isMoveCorrect(bishopCoord, new Coord(2, 3), board));
        assertFalse(bishop.isMoveCorrect(bishopCoord, new Coord(3, 2), board));
        assertFalse(bishop.isMoveCorrect(bishopCoord, new Coord(1, 2), board));
        assertTrue(bishop.isMoveCorrect(bishopCoord, new Coord(3, 1), board));
        assertFalse(bishop.isMoveCorrect(bishopCoord, new Coord(4, 0), board));
        assertTrue(bishop.isMoveCorrect(bishopCoord, new Coord(5, 5), board));
        assertFalse(bishop.isMoveCorrect(bishopCoord, new Coord(6, 6), board));
        assertFalse(bishop.isMoveCorrect(bishopCoord, new Coord(7, 7), board));
        assertFalse(bishop.isMoveCorrect(bishopCoord, new Coord(7, 0), board));

        bishopCoord = new Coord(5, 5);
        bishop = board.getPiece(bishopCoord);
        assertTrue(bishop.isMoveCorrect(bishopCoord, new Coord(7, 7), board));
        assertTrue(bishop.isMoveCorrect(bishopCoord, new Coord(3, 3), board));
        assertTrue(bishop.isMoveCorrect(bishopCoord, new Coord(2, 2), board));
        assertFalse(bishop.isMoveCorrect(bishopCoord, new Coord(1, 1), board));
        assertFalse(bishop.isMoveCorrect(bishopCoord, new Coord(7, 3), board));
        assertTrue(bishop.isMoveCorrect(bishopCoord, new Coord(3, 7), board));
        assertFalse(bishop.isMoveCorrect(bishopCoord, new Coord(7, 0), board));
    }

    @Test
    void testQueen() {

        byte[][] posBytes = {
                //0   1   2   3   4   5   6   7
                {' ',' ','p',' ',' ',' ',' ',' '},// 0
                {' ',' ',' ',' ',' ','p',' ',' '},// 1
                {' ','P','Q',' ',' ',' ','p',' '},// 2
                {' ','p',' ',' ',' ',' ',' ','P'},// 3
                {' ',' ',' ',' ',' ',' ',' ',' '},// 4
                {' ','p',' ','P',' ','q',' ',' '},// 5
                {' ',' ',' ',' ',' ','P',' ',' '},// 6
                {'P',' ',' ','p',' ',' ',' ',' '},// 7
        };
        Board board = getPositionFromByteArr(posBytes);

        var queenCoord = new Coord(2, 2);
        var queen = board.getPiece(queenCoord);
        assertFalse(queen.isMoveCorrect(queenCoord, new Coord(2, 1), board));
        assertTrue(queen.isMoveCorrect(queenCoord, new Coord(2, 3), board));
        assertTrue(queen.isMoveCorrect(queenCoord, new Coord(3, 2), board));
        assertTrue(queen.isMoveCorrect(queenCoord, new Coord(1, 2), board));
        assertTrue(queen.isMoveCorrect(queenCoord, new Coord(3, 1), board));
        assertFalse(queen.isMoveCorrect(queenCoord, new Coord(4, 0), board));
        assertFalse(queen.isMoveCorrect(queenCoord, new Coord(2, 0), board));
        assertFalse(queen.isMoveCorrect(queenCoord, new Coord(2, 7), board));
        assertTrue(queen.isMoveCorrect(queenCoord, new Coord(5, 5), board));
        assertFalse(queen.isMoveCorrect(queenCoord, new Coord(6, 6), board));
        assertFalse(queen.isMoveCorrect(queenCoord, new Coord(7, 7), board));
        assertFalse(queen.isMoveCorrect(queenCoord, new Coord(7, 0), board));
        assertTrue(queen.isMoveCorrect(queenCoord, new Coord(0, 2), board));
        assertTrue(queen.isMoveCorrect(queenCoord, new Coord(7, 2), board));

        queenCoord = new Coord(5, 5);
        queen = board.getPiece(queenCoord);
        assertTrue(queen.isMoveCorrect(queenCoord, new Coord(7, 7), board));
        assertTrue(queen.isMoveCorrect(queenCoord, new Coord(3, 3), board));
        assertTrue(queen.isMoveCorrect(queenCoord, new Coord(2, 2), board));
        assertFalse(queen.isMoveCorrect(queenCoord, new Coord(1, 1), board));
        assertFalse(queen.isMoveCorrect(queenCoord, new Coord(7, 3), board));
        assertTrue(queen.isMoveCorrect(queenCoord, new Coord(3, 7), board));
        assertFalse(queen.isMoveCorrect(queenCoord, new Coord(7, 0), board));
        assertTrue(queen.isMoveCorrect(queenCoord, new Coord(6, 5), board));
        assertFalse(queen.isMoveCorrect(queenCoord, new Coord(7, 5), board));
        assertFalse(queen.isMoveCorrect(queenCoord, new Coord(0, 5), board));
        assertFalse(queen.isMoveCorrect(queenCoord, new Coord(1, 5), board));
        assertTrue(queen.isMoveCorrect(queenCoord, new Coord(3, 5), board));
    }

    @Test
    void testKnight() {

        byte[][] posBytes = {
                //0   1   2   3   4   5   6   7
                {' ',' ',' ',' ',' ',' ',' ',' '},// 0
                {' ',' ',' ',' ',' ',' ',' ',' '},// 1
                {' ','N',' ',' ',' ',' ',' ',' '},// 2
                {' ',' ',' ',' ',' ','p',' ',' '},// 3
                {'p',' ','P',' ',' ',' ',' ',' '},// 4
                {' ',' ',' ',' ',' ',' ','n',' '},// 5
                {' ',' ',' ',' ','N',' ',' ',' '},// 6
                {' ',' ',' ',' ',' ',' ',' ',' '},// 7
        };
        Board board = getPositionFromByteArr(posBytes);

        var knightCoord = new Coord(2, 1);
        var knight = board.getPiece(knightCoord);
        assertTrue(knight.isMoveCorrect(knightCoord, new Coord(0, 0), board));
        assertTrue(knight.isMoveCorrect(knightCoord, new Coord(0, 2), board));
        assertTrue(knight.isMoveCorrect(knightCoord, new Coord(1, 3), board));
        assertTrue(knight.isMoveCorrect(knightCoord, new Coord(3, 3), board));
        assertFalse(knight.isMoveCorrect(knightCoord, new Coord(4, 2), board));
        assertTrue(knight.isMoveCorrect(knightCoord, new Coord(4, 0), board));
        assertFalse(knight.isMoveCorrect(knightCoord, new Coord(1, 0), board));
        assertFalse(knight.isMoveCorrect(knightCoord, new Coord(1, 1), board));
        assertFalse(knight.isMoveCorrect(knightCoord, new Coord(1, 2), board));
        assertFalse(knight.isMoveCorrect(knightCoord, new Coord(2, 2), board));
        assertFalse(knight.isMoveCorrect(knightCoord, new Coord(3, 2), board));
        assertFalse(knight.isMoveCorrect(knightCoord, new Coord(3, 1), board));
        assertFalse(knight.isMoveCorrect(knightCoord, new Coord(3, 0), board));
        assertFalse(knight.isMoveCorrect(knightCoord, new Coord(2, 0), board));
        assertFalse(knight.isMoveCorrect(knightCoord, new Coord(1, 0), board));

        knightCoord = new Coord(5, 6);
        knight = board.getPiece(knightCoord);
        assertFalse(knight.isMoveCorrect(knightCoord, new Coord(3, 5), board));
        assertTrue(knight.isMoveCorrect(knightCoord, new Coord(6, 4), board));
    }

    @Test
    void testKing() {

        byte[][] posBytes = {
                //0   1   2   3   4   5   6   7
                {' ',' ',' ',' ',' ',' ',' ',' '},// 0
                {' ',' ','p','P',' ',' ',' ',' '},// 1
                {' ','P','k',' ',' ',' ',' ',' '},// 2
                {' ',' ',' ','p',' ',' ',' ',' '},// 3
                {'P','P',' ',' ',' ',' ',' ',' '},// 4
                {' ',' ',' ',' ',' ','K',' ',' '},// 5
                {' ',' ',' ',' ',' ',' ',' ',' '},// 6
                {' ',' ',' ',' ',' ',' ',' ',' '},// 7
        };
        Board board = getPositionFromByteArr(posBytes);

        var kingCoord = new Coord(5, 5);
        var king = board.getPiece(kingCoord);
        assertTrue(king.isMoveCorrect(kingCoord, new Coord(4, 4), board));
        assertTrue(king.isMoveCorrect(kingCoord, new Coord(4, 5), board));
        assertTrue(king.isMoveCorrect(kingCoord, new Coord(4, 6), board));
        assertTrue(king.isMoveCorrect(kingCoord, new Coord(5, 6), board));
        assertTrue(king.isMoveCorrect(kingCoord, new Coord(6, 6), board));
        assertTrue(king.isMoveCorrect(kingCoord, new Coord(6, 5), board));
        assertTrue(king.isMoveCorrect(kingCoord, new Coord(6, 4), board));
        assertTrue(king.isMoveCorrect(kingCoord, new Coord(5, 4), board));

        assertFalse(king.isMoveCorrect(kingCoord, new Coord(3, 3), board));
        assertFalse(king.isMoveCorrect(kingCoord, new Coord(3, 4), board));
        assertFalse(king.isMoveCorrect(kingCoord, new Coord(3, 5), board));
        assertFalse(king.isMoveCorrect(kingCoord, new Coord(3, 6), board));
        assertFalse(king.isMoveCorrect(kingCoord, new Coord(3, 7), board));
        assertFalse(king.isMoveCorrect(kingCoord, new Coord(3, 7), board));
        assertFalse(king.isMoveCorrect(kingCoord, new Coord(4, 7), board));
        assertFalse(king.isMoveCorrect(kingCoord, new Coord(5, 7), board));
        assertFalse(king.isMoveCorrect(kingCoord, new Coord(6, 7), board));
        assertFalse(king.isMoveCorrect(kingCoord, new Coord(7, 7), board));

        kingCoord = new Coord(2, 2);
        king = board.getPiece(kingCoord);
        assertFalse(king.isMoveCorrect(kingCoord, new Coord(1, 2), board));
        assertTrue(king.isMoveCorrect(kingCoord, new Coord(1, 3), board));
        assertTrue(king.isMoveCorrect(kingCoord, new Coord(2, 1), board));
        assertFalse(king.isMoveCorrect(kingCoord, new Coord(3, 3), board));
        assertFalse(king.isMoveCorrect(kingCoord, new Coord(4, 0), board));
        assertFalse(king.isMoveCorrect(kingCoord, new Coord(4, 1), board));
    }

    @Test
    void testCastling_shouldCastle() {

        byte[][] posBytes = {
                //0   1   2   3   4   5   6   7
                {'R',' ',' ','K',' ',' ',' ','R'},// 0
                {' ',' ',' ',' ',' ',' ',' ',' '},// 1
                {' ',' ',' ',' ',' ',' ',' ',' '},// 2
                {' ',' ',' ',' ',' ',' ',' ',' '},// 3
                {' ',' ',' ',' ',' ',' ',' ',' '},// 4
                {' ',' ',' ',' ',' ',' ',' ',' '},// 5
                {' ',' ',' ',' ',' ',' ',' ',' '},// 6
                {'r',' ',' ','k',' ',' ',' ','r'},// 7
        };
        Board board = getPositionFromByteArr(posBytes);

        var kingCoord = new Coord(0, 3);
        var king = board.getPiece(kingCoord);
        assertTrue(king.isMoveCorrect(kingCoord, new Coord(0, 1), board));
        assertTrue(king.isMoveCorrect(kingCoord, new Coord(0, 5), board));

        kingCoord = new Coord(7, 3);
        king = board.getPiece(kingCoord);
        assertTrue(king.isMoveCorrect(kingCoord, new Coord(7, 1), board));
        assertTrue(king.isMoveCorrect(kingCoord, new Coord(7, 5), board));
    }

    @Test
    void testCastling_shouldNotCastle() {

        byte[][] posBytes = {
                //0   1   2   3   4   5   6   7
                {'R',' ','B','K','Q',' ',' ','R'},// 0
                {' ',' ',' ',' ',' ',' ',' ',' '},// 1
                {' ',' ',' ',' ',' ',' ',' ',' '},// 2
                {' ',' ',' ',' ',' ',' ',' ',' '},// 3
                {' ',' ',' ',' ',' ',' ',' ',' '},// 4
                {' ',' ',' ',' ',' ',' ',' ',' '},// 5
                {' ',' ',' ',' ',' ',' ',' ',' '},// 6
                {'r',' ','b','k','q',' ',' ','r'},// 7
        };
        Board board = getPositionFromByteArr(posBytes);

        var kingCoord = new Coord(0, 3);
        var king = board.getPiece(kingCoord);
        assertFalse(king.isMoveCorrect(kingCoord, new Coord(0, 1), board));
        assertFalse(king.isMoveCorrect(kingCoord, new Coord(0, 5), board));

        kingCoord = new Coord(7, 3);
        king = board.getPiece(kingCoord);
        assertFalse(king.isMoveCorrect(kingCoord, new Coord(7, 1), board));
        assertFalse(king.isMoveCorrect(kingCoord, new Coord(7, 5), board));

        posBytes = new byte[][] {
                //0   1   2   3   4   5   6   7
                {'R','N',' ','K',' ','B',' ','R'},// 0
                {' ',' ',' ',' ',' ',' ',' ',' '},// 1
                {' ',' ',' ',' ',' ',' ',' ',' '},// 2
                {' ',' ',' ',' ',' ',' ',' ',' '},// 3
                {' ',' ',' ',' ',' ',' ',' ',' '},// 4
                {' ',' ',' ',' ',' ',' ',' ',' '},// 5
                {' ',' ',' ',' ',' ',' ',' ',' '},// 6
                {'r','n',' ','k',' ','b',' ','r'},// 7
        };
        board = getPositionFromByteArr(posBytes);

        kingCoord = new Coord(0, 3);
        king = board.getPiece(kingCoord);
        assertFalse(king.isMoveCorrect(kingCoord, new Coord(0, 1), board));
        assertFalse(king.isMoveCorrect(kingCoord, new Coord(0, 5), board));

        kingCoord = new Coord(7, 3);
        king = board.getPiece(kingCoord);
        assertFalse(king.isMoveCorrect(kingCoord, new Coord(7, 1), board));
        assertFalse(king.isMoveCorrect(kingCoord, new Coord(7, 5), board));

        posBytes = new byte[][] {
                //0   1   2   3   4   5   6   7
                {' ',' ',' ','K',' ',' ','N','R'},// 0
                {' ',' ',' ',' ',' ',' ',' ',' '},// 1
                {' ',' ',' ',' ',' ',' ',' ',' '},// 2
                {' ',' ',' ',' ',' ',' ',' ',' '},// 3
                {' ',' ',' ',' ',' ',' ',' ',' '},// 4
                {' ',' ',' ',' ',' ',' ',' ',' '},// 5
                {' ',' ',' ',' ',' ',' ',' ',' '},// 6
                {' ',' ',' ','k',' ',' ','n','r'},// 7
        };
        board = getPositionFromByteArr(posBytes);

        kingCoord = new Coord(0, 3);
        king = board.getPiece(kingCoord);
        assertFalse(king.isMoveCorrect(kingCoord, new Coord(0, 5), board));

        kingCoord = new Coord(7, 3);
        king = board.getPiece(kingCoord);
        assertFalse(king.isMoveCorrect(kingCoord, new Coord(7, 5), board));

        posBytes = new byte[][] {
                //0   1   2   3   4   5   6   7
                {'R',' ',' ','k',' ',' ',' ','R'},// 0
                {' ',' ',' ',' ',' ',' ',' ',' '},// 1
                {' ',' ',' ',' ',' ',' ',' ',' '},// 2
                {' ',' ',' ',' ',' ',' ',' ',' '},// 3
                {' ',' ',' ',' ',' ',' ',' ',' '},// 4
                {' ',' ',' ',' ',' ',' ',' ',' '},// 5
                {' ',' ',' ',' ',' ',' ',' ',' '},// 6
                {'r',' ',' ','K',' ',' ',' ','r'},// 7
        };
        board = getPositionFromByteArr(posBytes);

        kingCoord = new Coord(0, 3);
        king = board.getPiece(kingCoord);
        assertFalse(king.isMoveCorrect(kingCoord, new Coord(0, 1), board));
        assertFalse(king.isMoveCorrect(kingCoord, new Coord(0, 5), board));

        kingCoord = new Coord(7, 3);
        king = board.getPiece(kingCoord);
        assertFalse(king.isMoveCorrect(kingCoord, new Coord(7, 1), board));
        assertFalse(king.isMoveCorrect(kingCoord, new Coord(7, 5), board));
    }

    @Test
    void testPawn() {

        byte[][] posBytes = {
                //0   1   2   3   4   5   6   7
                {' ',' ',' ',' ',' ',' ',' ',' '},// 0
                {'P','P',' ','P',' ',' ','p',' '},// 1
                {' ','p','p',' ','P',' ',' ',' '},// 2
                {' ',' ',' ','P',' ',' ',' ',' '},// 3
                {' ','P',' ','p',' ',' ',' ',' '},// 4
                {'p',' ','p',' ',' ','p',' ',' '},// 5
                {' ',' ','p',' ',' ',' ','p','P'},// 6
                {' ',' ',' ',' ',' ',' ',' ',' '},// 7
        };
        Board board = getPositionFromByteArr(posBytes);

        var pawnCoord = new Coord(1, 0);
        var pawn = board.getPiece(pawnCoord);
        assertTrue(pawn.isMoveCorrect(pawnCoord, new Coord(2, 0), board));
        assertTrue(pawn.isMoveCorrect(pawnCoord, new Coord(3, 0), board));
        assertTrue(pawn.isMoveCorrect(pawnCoord, new Coord(2, 1), board));
        assertFalse(pawn.isMoveCorrect(pawnCoord, new Coord(1, 1), board));
        assertFalse(pawn.isMoveCorrect(pawnCoord, new Coord(4, 0), board));

        pawnCoord = new Coord(1, 1);
        pawn = board.getPiece(pawnCoord);
        assertFalse(pawn.isMoveCorrect(pawnCoord, new Coord(2, 0), board));
        assertFalse(pawn.isMoveCorrect(pawnCoord, new Coord(2, 1), board));
        assertTrue(pawn.isMoveCorrect(pawnCoord, new Coord(2, 2), board));
        assertFalse(pawn.isMoveCorrect(pawnCoord, new Coord(3, 1), board));
        assertFalse(pawn.isMoveCorrect(pawnCoord, new Coord(1, 2), board));
        assertFalse(pawn.isMoveCorrect(pawnCoord, new Coord(0, 1), board));

        pawnCoord = new Coord(1, 3);
        pawn = board.getPiece(pawnCoord);
        assertTrue(pawn.isMoveCorrect(pawnCoord, new Coord(2, 2), board));
        assertFalse(pawn.isMoveCorrect(pawnCoord, new Coord(3, 3), board));
        assertFalse(pawn.isMoveCorrect(pawnCoord, new Coord(2, 4), board));
        assertTrue(pawn.isMoveCorrect(pawnCoord, new Coord(2, 3), board));
        assertFalse(pawn.isMoveCorrect(pawnCoord, new Coord(3, 2), board));
        assertFalse(pawn.isMoveCorrect(pawnCoord, new Coord(3, 4), board));

        pawnCoord = new Coord(1, 6);
        pawn = board.getPiece(pawnCoord);
        assertFalse(pawn.isMoveCorrect(pawnCoord, new Coord(3, 6), board));

        pawnCoord = new Coord(2, 2);
        pawn = board.getPiece(pawnCoord);
        assertTrue(pawn.isMoveCorrect(pawnCoord, new Coord(1, 1), board));
        assertTrue(pawn.isMoveCorrect(pawnCoord, new Coord(1, 2), board));
        assertTrue(pawn.isMoveCorrect(pawnCoord, new Coord(1, 3), board));
        assertFalse(pawn.isMoveCorrect(pawnCoord, new Coord(2, 3), board));
        assertFalse(pawn.isMoveCorrect(pawnCoord, new Coord(3, 3), board));
        assertFalse(pawn.isMoveCorrect(pawnCoord, new Coord(3, 2), board));
        assertFalse(pawn.isMoveCorrect(pawnCoord, new Coord(3, 1), board));
        assertFalse(pawn.isMoveCorrect(pawnCoord, new Coord(2, 1), board));
        assertFalse(pawn.isMoveCorrect(pawnCoord, new Coord(0, 2), board));

        pawnCoord = new Coord(3, 3);
        pawn = board.getPiece(pawnCoord);
        assertFalse(pawn.isMoveCorrect(pawnCoord, new Coord(4, 2), board));
        assertFalse(pawn.isMoveCorrect(pawnCoord, new Coord(4, 3), board));
        assertFalse(pawn.isMoveCorrect(pawnCoord, new Coord(4, 4), board));

        pawnCoord = new Coord(4, 3);
        pawn = board.getPiece(pawnCoord);
        assertFalse(pawn.isMoveCorrect(pawnCoord, new Coord(3, 2), board));
        assertFalse(pawn.isMoveCorrect(pawnCoord, new Coord(3, 3), board));
        assertFalse(pawn.isMoveCorrect(pawnCoord, new Coord(3, 4), board));

        pawnCoord = new Coord(6, 7);
        pawn = board.getPiece(pawnCoord);
        assertFalse(pawn.isMoveCorrect(pawnCoord, new Coord(4, 7), board));

        pawnCoord = new Coord(6, 6);
        pawn = board.getPiece(pawnCoord);
        assertTrue(pawn.isMoveCorrect(pawnCoord, new Coord(4, 6), board));

        pawnCoord = new Coord(5, 0);
        pawn = board.getPiece(pawnCoord);
        assertTrue(pawn.isMoveCorrect(pawnCoord, new Coord(4, 1), board));
    }

    @Test
    void testEnPassant() {

        byte[][] posBytes = {
                //0   1   2   3   4   5   6   7
                {' ',' ',' ',' ',' ',' ',' ',' '},// 0
                {' ',' ',' ',' ',' ',' ',' ',' '},// 1
                {' ',' ',' ',' ',' ',' ',' ',' '},// 2
                {'P','p','P','p',' ',' ',' ',' '},// 3
                {' ',' ',' ',' ','p','P','p','P'},// 4
                {' ',' ',' ',' ',' ',' ',' ',' '},// 5
                {' ',' ',' ',' ',' ',' ',' ',' '},// 6
                {' ',' ',' ',' ',' ',' ',' ',' '},// 7
        };
        Board board = getPositionFromByteArr(posBytes);

        ((Pawn) board.getPiece(3, 0)).setTheLastMoveLong(false);
        ((Pawn) board.getPiece(3, 2)).setTheLastMoveLong(true);
        ((Pawn) board.getPiece(4, 4)).setTheLastMoveLong(true);
        ((Pawn) board.getPiece(4, 6)).setTheLastMoveLong(false);

        var pawnCoord = new Coord(3, 1);
        var pawn = board.getPiece(pawnCoord);
        assertFalse(pawn.isMoveCorrect(pawnCoord, new Coord(2, 0), board));
        assertTrue(pawn.isMoveCorrect(pawnCoord, new Coord(2, 2), board));

        pawnCoord = new Coord(3, 3);
        pawn = board.getPiece(pawnCoord);
        assertTrue(pawn.isMoveCorrect(pawnCoord, new Coord(2, 2), board));

        pawnCoord = new Coord(4, 5);
        pawn = board.getPiece(pawnCoord);
        assertTrue(pawn.isMoveCorrect(pawnCoord, new Coord(5, 4), board));
        assertFalse(pawn.isMoveCorrect(pawnCoord, new Coord(5, 6), board));

        pawnCoord = new Coord(4, 7);
        pawn = board.getPiece(pawnCoord);
        assertFalse(pawn.isMoveCorrect(pawnCoord, new Coord(5, 6), board));
    }
}
