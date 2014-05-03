import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class MovingRooksDiv2 {
	
	public String move(int[] Y1, int[] Y2) {

        Chessboard chessboard1 = new Chessboard(Y1);
        Chessboard chessboard2 = new Chessboard(Y2);

        boolean answer = mutateChessboard(chessboard1, chessboard2);

		return answer ? "Possible" : "Impossible";
	}

    Map<Chessboard, Boolean> cache = new HashMap<Chessboard, Boolean>();

    private boolean mutateChessboard(Chessboard chessboard1, Chessboard chessboard2) {
        if (chessboard1.equals(chessboard2))
            return true;

        if (cache.containsKey(chessboard1))
            return cache.get(chessboard1);

        List<Chessboard> possibleMutations = getPossibleMutations(chessboard1);

        boolean result = false;
        for (Chessboard possibleChessboard : possibleMutations) {
            result |= mutateChessboard(possibleChessboard, chessboard2);
        }

        cache.put(chessboard1, result);

        return result;
    }

    private List<Chessboard> getPossibleMutations(Chessboard chessboard) {
        List<Chessboard> result = new ArrayList<Chessboard>();

        for (int i = 0; i < chessboard.board.length; ++i) {
            for (int j = i + 1; j < chessboard.board.length; ++j) {
                int rook1Col = chessboard.board[i];
                int rook2Col = chessboard.board[j];

                if (rook1Col > rook2Col) {
                    Chessboard newChessboard = new Chessboard(Arrays.copyOf(chessboard.board, chessboard.board.length));
                    newChessboard.board[j] = rook1Col;
                    newChessboard.board[i] = rook2Col;
                    result.add(newChessboard);
                }
            }
        }

        return result;
    }

    private static class Chessboard {
        public int[] board;

        private Chessboard(int[] board) {
            this.board = board;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Chessboard that = (Chessboard) o;

            if (!Arrays.equals(board, that.board)) return false;

            return true;
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(board);
        }
    }
}
