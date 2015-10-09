import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Math.*;

public class Lottery {

    private Pattern rulePattern = Pattern.compile("(?<name>[^:]+):\\s(?<choices>\\d+)\\s(?<blanks>\\d+)\\s(?<sorted>T|F)\\s(?<unique>T|F)");

	public String[] sortByOdds(String[] rules) {

        evalSortedAndNotUnique(3, 2);

        List<LotteryProbability> probabilities = new ArrayList<LotteryProbability>();
		for (String rule : rules) {
            LotteryProbability probability = evalProbability(rule);
            probabilities.add(probability);
        }

        Collections.sort(probabilities, new Comparator<LotteryProbability>() {
            @Override
            public int compare(LotteryProbability o1, LotteryProbability o2) {
                long probability = o1.probability - o2.probability;

                if (probability == 0)
                    return o1.name.compareTo(o2.name);

                return (int) signum(probability);
            }
        });



        List<String> names = new ArrayList<String>();
        for (LotteryProbability probability : probabilities) {
            names.add(probability.name);
        }



        return names.toArray(new String[names.size()]);
	}

    private LotteryProbability evalProbability(String rule) {
        Matcher matcher = rulePattern.matcher(rule);

        if (!matcher.find())
            return null;

        String name = matcher.group("name");
        int choises = Integer.valueOf(matcher.group("choices"));
        int blanks = Integer.valueOf(matcher.group("blanks"));
        boolean sorted = matcher.group("sorted").equals("T");
        boolean unique = matcher.group("unique").equals("T");

        long probability = evalProbabilityImpl(choises, blanks, sorted, unique);

        LotteryProbability lotteryProbability = new LotteryProbability();
        lotteryProbability.name = name;
        lotteryProbability.probability = probability;

        return lotteryProbability;
    }

    private long evalProbabilityImpl(int choices, int blanks, boolean sorted, boolean unique) {

        if (!sorted && !unique) {
            return (long) pow(choices, blanks);
        }

        if (!sorted && unique) {
            long result = 1;

            for (int i = 0, currentNumber = choices; i < blanks; ++i, --currentNumber) {
                result *= currentNumber;
            }

            return result;
        }

        if (sorted && unique) {
            long result = 1;

            for (int i = 0, currentNumber = choices; i < blanks; ++i, --currentNumber) {
                result *= currentNumber;
            }

            for (int i = 2; i <= blanks; ++i) {
                result /= i;
            }

            return result;
        }

        if (sorted && !unique) {
            return evalSortedAndNotUnique(choices, blanks);
        }

        return 0;
    }

    private Map<Pair<Integer, Integer>, Long> cache = new HashMap<Pair<Integer, Integer>, Long>();

    private long evalSortedAndNotUnique(int choices, int blanks) {
        long sum = 0;

        if (blanks == 1)
            return choices;

        if (choices == 1)
            return 1;

        Pair<Integer, Integer> cacheKey = new Pair<Integer, Integer>(choices, blanks);
        if (cache.containsKey(cacheKey)) {
            return cache.get(cacheKey);
        }


        for (int i = 1; i <= choices; ++i) {
            sum += evalSortedAndNotUnique(choices - i + 1, blanks - 1);
        }

        cache.put(cacheKey, sum);

        return sum;
    }

    private class LotteryProbability {
        public String name;
        public long probability;
    }

    public class Pair<F, S>{
        private F first;
        private S second;

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            if (second != null ? !second.equals(pair.second) : pair.second != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }
    }
}
