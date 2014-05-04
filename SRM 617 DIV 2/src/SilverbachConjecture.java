import static java.lang.Math.*;

public class SilverbachConjecture {

	public int[] solve(int n) {

        for (int i = 2; i < n / 2; ++i) {
            if (!isSimple(i) && !isSimple(n - i)) {
                return new int[] {i, n - i};
            }
        }

        return null;
	}

    private boolean isSimple(int n) {
        for (int i = 2; i < sqrt(n); ++i) {
            if (n % i == 0)
                return false;
        }

        return true;
    }
}
