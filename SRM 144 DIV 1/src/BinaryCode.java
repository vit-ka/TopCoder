public class BinaryCode {

    public String[] decode(String message) {
        return new String[] { decodeAssumingFirstDigit('0', message), decodeAssumingFirstDigit('1', message)};
    }

    private String decodeAssumingFirstDigit(char firstDigit, String message) {
        StringBuilder result = new StringBuilder();
        result.append(firstDigit);

        int prevPrevDecodedSymbol = 0;
        int preDecodedSymbol = firstDigit - '0';

        for (int i = 0; i < message.length(); ++i) {
            int currentEncodedSymbol = message.charAt(i) - '0';

            int currentDecodedSymbol = decodeCurrentSymbol(preDecodedSymbol, prevPrevDecodedSymbol, currentEncodedSymbol);

            if (currentDecodedSymbol < 0 || currentDecodedSymbol > 1) {
                return "NONE";
            }

            // Do not append the last character because it's a control one.
            if (i + 1 < message.length())
                result.append(Character.toChars(currentDecodedSymbol + '0'));

            prevPrevDecodedSymbol = preDecodedSymbol;
            preDecodedSymbol = currentDecodedSymbol;
        }

        if (!checkAnswer(result.toString(), message))
            return "NONE";

        return result.toString();
    }

    private boolean checkAnswer(String answer, String originalMessage) {
        for (int i = 0; i < answer.length(); ++i) {
            int currentEncodedSymbol = encodeCurrentSymbol(answer, i);

            if (currentEncodedSymbol != originalMessage.charAt(i) - '0')
                return false;
        }

        return true;
    }

    private int encodeCurrentSymbol(String answer, int index) {
        int prevSymbol = index != 0 ? answer.charAt(index - 1) - '0' : 0;
        int curSymbol = answer.charAt(index) - '0';
        int nextSymbol = index + 1 < answer.length() ? answer.charAt(index + 1) - '0' : 0;
        return prevSymbol + curSymbol + nextSymbol;
    }

    private int decodeCurrentSymbol(int prevDecodedSymbol, int prevPrevDecodedSymbol, int curEncodedSymbol) {
        return curEncodedSymbol - prevDecodedSymbol - prevPrevDecodedSymbol;
    }
}
