package name.vitaly.kalinkin.topcoder.solution.srm_144.div_1;

import java.util.*;

public class Lottery {
    private static class LotteryDescription {
        public String name;
        public int choices;
        public int blanks;
        public boolean sorted;
        public boolean unique;

        public static LotteryDescription parse(String rule) {
            int semicolonPosition = rule.indexOf(':');

            LotteryDescription result = new LotteryDescription();
            result.name = rule.substring(0, semicolonPosition);

            int spacePosition = rule.indexOf(' ', semicolonPosition + 2);
            result.choices = Integer.parseInt(rule.substring(semicolonPosition + 2, spacePosition));

            int prevSpacePosition = spacePosition;
            spacePosition = rule.indexOf(' ', spacePosition + 1);
            result.blanks = Integer.parseInt(rule.substring(prevSpacePosition + 1, spacePosition));

            result.sorted = rule.substring(spacePosition + 1, spacePosition + 2).equals("T");
            result.unique = rule.substring(spacePosition + 3, spacePosition + 4).equals("T");

            return result;
        }

        public String toString() {
            return "LotteryDescription{" +
                    "name='" + name + '\'' +
                    ", choices=" + choices +
                    ", blanks=" + blanks +
                    ", sorted=" + sorted +
                    ", unique=" + unique +
                    '}';
        }
    }

    public static class Pair<F, S> implements Comparable<Pair<F, S>> {
        private F first;
        private S second;

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            if (second != null ? !second.equals(pair.second) : pair.second != null) return false;

            return true;
        }

        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        public int compareTo(Pair<F, S> other) {
            int result = ((Comparable<F>)first).compareTo(other.first);

            if (result == 0)
                result = ((Comparable<S>)second).compareTo(other.second);

            return result;
        }

        public String toString() {
            return "Pair{" +
                    "" + first +
                    "," + second +
                    '}';
        }
    }

    public String[] sortByOdds(String[] rules) {
        List<LotteryDescription> parsedRules = new ArrayList<LotteryDescription>(rules.length);

        for (String rule : rules) {
            LotteryDescription parsedRule = LotteryDescription.parse(rule);
            parsedRules.add(parsedRule);
        }

        List<Pair<Long, LotteryDescription>> probabilitiesToWin = new ArrayList<Pair<Long, LotteryDescription>>();
        for (LotteryDescription lotteryDescription : parsedRules) {
            long probabilityF = getProbabilityByFormula(lotteryDescription);
            long probabilityD = getProbabilityByDynamic(lotteryDescription);

            if (probabilityD != probabilityF) {
                System.err.println("Incorrect probability. Excepted for " + probabilityF + " but got " + probabilityD);
            }

            System.out.println("Rules " + lotteryDescription + " has been evaluated to " + probabilityF);
            probabilitiesToWin.add(new Pair<Long, LotteryDescription>(probabilityD, lotteryDescription));
        }

        Collections.sort(probabilitiesToWin, new Comparator<Pair<Long, LotteryDescription>>() {

            public int compare(Pair<Long, LotteryDescription> o1, Pair<Long, LotteryDescription> o2) {
                int result = (int) Math.signum(o1.first - o2.first);

                if (result == 0)
                    result = o1.second.name.compareTo(o2.second.name);

                return result;
            }
        });

        String[] result = new String[probabilitiesToWin.size()];

        int index = 0;
        for (Pair<Long, LotteryDescription> pair : probabilitiesToWin) {
            result[index++] = pair.second.name;
        }

        return result;
    }

    private long getProbabilityByFormula(LotteryDescription lotteryDescription) {
        if (lotteryDescription.sorted && !lotteryDescription.unique) {
            long sortedProbability = getSortedProbability(lotteryDescription.choices, lotteryDescription.blanks);
            System.out.println(sortedProbability + " because of sorting.");
            return sortedProbability;
        }

        if (lotteryDescription.unique && !lotteryDescription.sorted) {
            long uniqueProbability = getUniqueProbability(lotteryDescription.choices, lotteryDescription.blanks);
            System.out.println(uniqueProbability + " because of uniqueness.");
            return uniqueProbability;
        }

        if (lotteryDescription.unique && lotteryDescription.sorted) {
            long sortAndUniqueProbability = getSortedAndUniqueProbability(lotteryDescription.choices, lotteryDescription.blanks);
            System.out.println(sortAndUniqueProbability + " because of sorting in uniqueness.");
            return sortAndUniqueProbability;
        }

        long baseProbability = getBaseProbability(lotteryDescription.choices, lotteryDescription.blanks);
        System.out.println(baseProbability + " just base");
        return baseProbability;
    }


    private long getSortedAndUniqueProbability(int choices, int blanks) {
        long result = 1;
        for (int i = 0; i < blanks; ++i) {
            result *= choices - i;
        }

        return result / fact(blanks);
    }

    private long fact(long choices) {
        if (choices <= 1)
            return 1;

        return choices * fact(choices - 1);
    }


    private long getUniqueProbability(int choices, int blanks) {
        long result = 1;
        for (int i = 0; i < blanks; ++i) {
            result *= choices - i;
        }

        return result;
    }

    private long getSortedProbability(int choices, int blanks) {
        long result = 1;
        for (int i = choices; i < choices + blanks; ++i) {
            result *= i;
        }

        return result / fact(blanks);
    }

    private long getBaseProbability(int choices, int blanks) {
        long result = choices;
        for (int i = 1; i < blanks; ++i) {
            result *= choices;
        }

        return result;
    }


    private long getProbabilityByDynamic(LotteryDescription lotteryDescription) {
        if (lotteryDescription.sorted && !lotteryDescription.unique) {
            long sortedProbability = getSortedProbabilityByDynamic(lotteryDescription.choices, lotteryDescription.blanks);
            System.out.println(sortedProbability + " because of sorting.");
            return sortedProbability;
        }

        if (lotteryDescription.unique && !lotteryDescription.sorted) {
            long uniqueProbability = getUniqueProbabilityByDynamic(lotteryDescription.choices, lotteryDescription.blanks);
            System.out.println(uniqueProbability + " because of uniqueness.");
            return uniqueProbability;
        }


        if (lotteryDescription.unique && lotteryDescription.sorted) {
            long sortAndUniqueProbability = getSortedAndUniqueProbabilityByDynamic(lotteryDescription.choices, lotteryDescription.blanks);
            System.out.println(sortAndUniqueProbability + " because of sorting in uniqueness.");
            return sortAndUniqueProbability;
        }

        long baseProbability = getBaseProbabilityByDynamic(lotteryDescription.choices, lotteryDescription.blanks);
        System.out.println(baseProbability + " just base");
        return baseProbability;
    }

    TreeMap<Pair<Integer, Integer>, Long> sortedProbabilityCache = new TreeMap<Pair<Integer, Integer>, Long>();
    private long getSortedProbabilityByDynamic(int choices, int blanks) {
        if (choices == 0)
            return 0;

        if (choices < blanks)
            return 0;

        if (choices == 1)
            return 1;

        if (blanks == 1)
            return choices;


        Pair<Integer, Integer> key = new Pair<Integer, Integer>(choices, blanks);
        if (sortedProbabilityCache.containsKey(key))
            return sortedProbabilityCache.get(key);

        long result = 0;
        for (int i = 1; i <= choices; ++i) {
            result += getSortedProbabilityByDynamic(choices - i + 1, blanks - 1);
        }

        sortedProbabilityCache.put(key, result);
        System.out.println("S(" + choices + "," + blanks + ")=" + result);
        return result;
    }

    TreeMap<Pair<Integer, Integer>, Long> sortedAndUniqueProbabilityCache = new TreeMap<Pair<Integer, Integer>, Long>();
    private long getSortedAndUniqueProbabilityByDynamic(int choices, int blanks) {
        if (choices == 0)
            return 0;

        if (choices < blanks)
            return 0;

        if (choices == 1)
            return 1;

        if (blanks == 1)
            return choices;


        Pair<Integer, Integer> key = new Pair<Integer, Integer>(choices, blanks);
        if (sortedAndUniqueProbabilityCache.containsKey(key))
            return sortedAndUniqueProbabilityCache.get(key);

        long result = 0;
        for (int i = 1; i < choices; ++i) {
            result += getSortedAndUniqueProbabilityByDynamic(choices - i, blanks - 1);
        }

        sortedAndUniqueProbabilityCache.put(key, result);
        System.out.println("SU(" + choices + "," + blanks + ")=" + result);
        return result;
    }

    private long getUniqueProbabilityByDynamic(int choices, int blanks) {
        if (choices == 1)
            return 1;

        if (blanks == 1)
            return choices;

        return choices * getUniqueProbabilityByDynamic(choices - 1, blanks - 1);
    }

    private long getBaseProbabilityByDynamic(int choices, int blanks) {
        if (blanks == 1)
            return choices;
        return choices * getBaseProbabilityByDynamic(choices, blanks - 1);
    }
}
