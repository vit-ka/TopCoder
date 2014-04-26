package name.vitaly.kalinkin.topcoder.solution.srm_144.div_1;

public class BinaryCode_300 {
    public String[] decode(String message) {
        return new String[] { decodeAssumingFirstDigit('0', message), decodeAssumingFirstDigit('1', message)};
    }

    private String decodeAssumingFirstDigit(char firstDigit, String message) {
        String result = "";

        int prevDigit = firstDigit - '0';
        int curDigit = message.charAt(0) - '0' - prevDigit;

        result += prevDigit;
        result += curDigit;

        if (prevDigit > 1 || prevDigit < 0)
            return "NONE";

        if (curDigit > 1 || curDigit < 0)
            return "NONE";

        for (int i = 1; i < message.length(); ++i) {
            int tempDigit =  message.charAt(i) - '0' - prevDigit - curDigit;

            if (tempDigit > 1 || tempDigit < 0)
                return "NONE";

            prevDigit = curDigit;
            curDigit = tempDigit;
            if (i != message.length() - 1)
                result += curDigit;
        }

        return result;
    }
}
