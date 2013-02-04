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

            //System.out.println("Parsed rule: " + result);

            return result;
        }

        @Override
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

    public static class Pair<F, S> {
        private F first;
        private S second;

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }

    public String[] sortByOdds(String[] rules) {
        List<LotteryDescription> parsedRules = new ArrayList<LotteryDescription>(rules.length);

        for (String rule: rules) {
            LotteryDescription parsedRule = LotteryDescription.parse(rule);
            parsedRules.add(parsedRule);
        }

        List<Pair<Long, LotteryDescription>> probabilitiesToWin = new ArrayList<Pair<Long, LotteryDescription>>();
        for (LotteryDescription lotteryDescription : parsedRules) {
            long probability = getProbability(lotteryDescription);
            System.out.println("Rules " + lotteryDescription + " has been evaluated to " + probability);
            probabilitiesToWin.add(new Pair(probability, lotteryDescription));
        }

        Collections.sort(probabilitiesToWin, new Comparator<Pair<Long, LotteryDescription>>() {
            @Override
            public int compare(Pair<Long, LotteryDescription> o1, Pair<Long, LotteryDescription> o2) {
                int result = (int) Math.signum(o1.first - o2.first);

                if (result == 0)
                    result = o1.second.name.compareTo(o2.second.name);

                return result;
            }
        });

        String[] result = new String[probabilitiesToWin.size()];

        int index = 0;
        for(Pair<Long, LotteryDescription> pair: probabilitiesToWin) {
            result[index++] = pair.second.name;
        }

        return result;
    }

    private long getProbability(LotteryDescription lotteryDescription) {
        if (lotteryDescription.sorted && !lotteryDescription.unique) {
            long sortedProbability = getSortedProbability(lotteryDescription.choices, lotteryDescription.blanks);
            System.out.println(sortedProbability + " because of sorting.");
            return  sortedProbability;
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
        long result = 0;
        for (int j = 0; j < choices - blanks + 1; ++j) {
            int innerResult = 0;

            for (int i = choices - blanks + 1 - j; i >= 1; --i) {
                innerResult += i;
            }

            result += innerResult;
        }

        return result;
    }


    private long getUniqueProbability(int choices, int blanks) {
        long result = 1;
        for (int i = 1; i < blanks; ++i) {
            result *= (choices - i);
        }

        return result * choices;
    }

    private long getSortedProbability(int choices, int blanks) {
        long result = 0;
        for (int j = 0; j < choices; ++j) {

            long innerResult = 1;
            for (int i = 0; i < blanks - 1; ++i) {
                innerResult *= (choices - j);
            }

            result += innerResult;
        }

        return result;
    }

    private long getBaseProbability(int choices, int blanks) {
        long result = choices;
        for (int i = 1; i < blanks; ++i) {
            result *= choices;
        }

        return result;
    }
}
