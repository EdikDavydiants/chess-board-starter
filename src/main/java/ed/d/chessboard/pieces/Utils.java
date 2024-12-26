package ed.d.chessboard.pieces;

import static ed.d.chessboard.Board.BOARD_SIZE;

public class Utils {



    public static void boardIteration(IterableConsumer consumer) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int k = 0; k < BOARD_SIZE; k++) {
                consumer.iterate(i, k);
            }
        }
    }


    @FunctionalInterface
    public interface IterableConsumer {

        void iterate(int i, int k);
    }
}
