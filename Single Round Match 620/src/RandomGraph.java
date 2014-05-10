import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class RandomGraph {
	
	public double probability(int n, int p) {

        double result = getResult(n, 4);

        System.out.printf("Cache: %s\n", cache);
        System.out.printf("CacheNeede: %s\n", cacheNeeded);

        return result;
	}

    public class Key {
        public int n;
        public int needed;

        public Key(int n, int needed) {
            this.n = n;
            this.needed = needed;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Key key = (Key) o;

            if (n != key.n) return false;
            if (needed != key.needed) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = n;
            result = 31 * result + needed;
            return result;
        }

        @Override
        public String toString() {
            return "{" + n +
                    ":" + needed +
                    '}';
        }
    }

    Map<Key, Double> cache = new HashMap<Key, Double>();
    Map<Key, Double> cacheNeeded = new HashMap<Key, Double>();

    private double getResult(int n, int needed) {
        if (n < needed)
            return 0;

        if (needed == 0)
            return 1;

        Key cacheKey = new Key(n, needed);

        if (cache.containsKey(cacheKey)) {
            return cache.get(cacheKey);
        }

        double result = 0;
        for (int i = 0; i <= needed; i++) {
            result += getResult(n - 1, i) * getNeedCount(n, needed - i);
        }

        cache.put(cacheKey, result);

        return result;
    }

    private double getNeedCount(int n, int needed) {

        Key cacheKey = new Key(n, needed);

        if (cacheNeeded.containsKey(cacheKey))
            return cacheNeeded.get(cacheKey);

        long result = 0;
        for (long i = 0; i < (1 << n); i++) {
            if (testGraph(i) == needed)
                result++;
        }

        cacheNeeded.put(cacheKey, (double) result);

        return result;
    }

    private int testGraph(long number) {
        int count = 0;
        for (int i = 0; i <= 64; i++) {
            if ((number & (1 << i)) != 0) {
                count++;
            }
        }

        return count;
    }


}
