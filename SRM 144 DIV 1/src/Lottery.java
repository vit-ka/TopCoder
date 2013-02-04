import java.util.ArrayList;
import java.util.List;

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

            System.out.println("Parsed rule: " + result);

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

    public String[] sortByOdds(String[] rules) {
        List<LotteryDescription> parsedRules = new ArrayList<LotteryDescription>(rules.length);

        for (String rule: rules) {
            LotteryDescription parsedRule = LotteryDescription.parse(rule);
            parsedRules.add(parsedRule);
        }

        return null;
    }
}
