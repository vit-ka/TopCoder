import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class PairGameEasy {
	
	public String able(int a, int b, int c, int d) {
		Pair start = new Pair(a, b);
        Pair finish = new Pair(c, d);

        boolean result = tryToGenerate(start, finish);

        return result ? "Able to generate" : "Not able to generate";
	}

    private boolean tryToGenerate(Pair start, Pair finish) {
        if (start.equals(finish))
            return true;

        if (start.x > finish.x || start.y > finish.y)
            return false;

        boolean result = false;

        result |= tryToGenerate(new Pair(start.x, start.x + start.y), finish);
        result |= tryToGenerate(new Pair(start.x + start.y, start.y), finish);

        return result;
    }

    public class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (x != pair.x) return false;
            if (y != pair.y) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
