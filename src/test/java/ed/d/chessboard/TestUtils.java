package ed.d.chessboard;

import ed.d.chessboard.pieces.AbstractPiece;
import ed.d.chessboard.pieces.Bishop;
import ed.d.chessboard.pieces.King;
import ed.d.chessboard.pieces.Knight;
import ed.d.chessboard.pieces.Pawn;
import ed.d.chessboard.pieces.Queen;
import ed.d.chessboard.pieces.Rook;
import ed.d.chessboard.pieces.Utils;

import static ed.d.chessboard.pieces.NoPiece.noPiece;

public class TestUtils {

    public static Board getPositionFromByteArr(byte[][] position) {

        final var board = Board.createEmptyBoard();
        Utils.boardIteration((i, k) -> board.setPiece(i, k, getPieceFromByte(position[i][k])));
        return board;
    }

    private static AbstractPiece getPieceFromByte(byte pieceByte) {

        return switch (pieceByte) {
            case 'P' -> new Pawn(true, false);
            case 'N' -> new Knight(true);
            case 'B' -> new Bishop(true);
            case 'R' -> new Rook(true, false);
            case 'Q' -> new Queen(true);
            case 'K' -> new King(true, false);

            case 'p' -> new Pawn(false, false);
            case 'n' -> new Knight(false);
            case 'b' -> new Bishop(false);
            case 'r' -> new Rook(false, false);
            case 'q' -> new Queen(false);
            case 'k' -> new King(false, false);

            default -> noPiece;
        };
    }
}
