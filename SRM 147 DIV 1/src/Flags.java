import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class Flags {
	
	public long numStripes(String numFlags, String[] forbidden) {
		int[][] allowedParsed = parseForbiddenAndConvertToAllowed(forbidden);

        if (checkSpecialCase(allowedParsed)) {
            return evalSpecialCase(Long.valueOf(numFlags), allowedParsed);
        }

        int stripesCount = 0;
        long totalFlags = 0;
        while (totalFlags < Long.valueOf(numFlags)) {
            stripesCount++;

            for (int i = 0; i < forbidden.length; ++i) {
                totalFlags += evalTotalFlagsForNStripes(stripesCount, allowedParsed, i);
            }

            System.out.println(String.format("Stripes count: %s = %s", stripesCount, totalFlags));
            printCache(stripesCount);
        }

        return stripesCount;
	}

    private long evalSpecialCase(long numFlags, int[][] allowedParsed) {
        long totalStripes = 0;

        for(int[] allowed : allowedParsed) {
            if (allowed.length <= 1)
                totalStripes += allowed.length;
        }

        long forbiddenColors = allowedParsed.length - totalStripes;

        return (numFlags - forbiddenColors + totalStripes - 1) / totalStripes;
    }

    private boolean checkSpecialCase(int[][] allowedParsed) {
        for(int[] allowed : allowedParsed) {
            if (allowed.length > 1)
                return false;
        }

        return true;
    }

    private void printCache(int stripesCount) {
        for (Map.Entry<Key, Long> entry : cache.entrySet()) {
            if (entry.getKey().stripesCount == stripesCount)
                System.out.println(String.format("{%s, %s}:%s", entry.getKey().stripesCount, entry.getKey().endsWithColor, entry.getValue()));
        }
    }

    Map<Key, Long> cache = new HashMap<Key, Long>();

    private long evalTotalFlagsForNStripes(int stripesCount, int[][] allowed, int endingWithColor) {
        if (stripesCount == 1)
            return 1;

        Key cacheKey = new Key();
        cacheKey.endsWithColor = endingWithColor;
        cacheKey.stripesCount = stripesCount;

        if (cache.containsKey(cacheKey))
            return cache.get(cacheKey);

        long sum = 0;
        for (int allowedColor : allowed[endingWithColor]) {
            sum += evalTotalFlagsForNStripes(stripesCount - 1, allowed, allowedColor);
        }

        cache.put(cacheKey, sum);

        return sum;
    }

    private int[][] parseForbiddenAndConvertToAllowed(String[] forbidden) {
        int[][] result = new int[forbidden.length][];

        for (int i = 0; i < forbidden.length; ++i) {
            String[] forbiddenNumbers = forbidden[i].split(" ");
            int[] resultNegative = new int[forbiddenNumbers.length];

            for (int j = 0; j < forbiddenNumbers.length; ++j) {
                resultNegative[j] = Integer.valueOf(forbiddenNumbers[j]);
            }

            int k = 0;
            result[i] = new int[forbidden.length - resultNegative.length];
            for (int j = 0; j < forbidden.length; ++j){
                if (Arrays.binarySearch(resultNegative, j) < 0)
                    result[i][k++] = j;
            }
        }

        return result;
    }

    private static class Key {
        public int stripesCount;
        public int endsWithColor;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Key key = (Key) o;

            if (endsWithColor != key.endsWithColor) return false;
            if (stripesCount != key.stripesCount) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = stripesCount;
            result = 31 * result + endsWithColor;
            return result;
        }
    }
}
