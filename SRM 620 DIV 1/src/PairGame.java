import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class PairGame {

    Set<Pair> abs = new HashSet<Pair>();
    Set<Pair> cds = new HashSet<Pair>();

	public int maxSum(int a, int b, int c, int d) {

        evalForPair(abs, new Pair(a, b), cds);
        evalForPair(cds, new Pair(c, d), abs);

        abs.retainAll(cds);

        List<Pair> result = new ArrayList<Pair>(abs);
        Collections.sort(result, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return (o1.x + o1.y) - (o2.x + o2.y);
            }
        });

        if (result.size() == 0)
            return -1;

        Pair resultPair = result.get(result.size() - 1);
        return resultPair.x + resultPair.y;
	}

    private void evalForPair(Set<Pair> set, Pair pair, Set<Pair> another) {

        Pair newPair = pair;

        while (newPair.x > 0 && newPair.y > 0) {
            set.add(newPair);

            if (another.contains(newPair))
                return;

            if (newPair.x > newPair.y) {
                newPair = new Pair(newPair.x - newPair.y, newPair.y);
            } else {
                newPair = new Pair(newPair.x, newPair.y - newPair.x);
            }
        }
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
