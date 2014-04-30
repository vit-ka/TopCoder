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
                // If the last symbol is not null. Then we have inconsistency with the first assumed symbol.
            else if (currentDecodedSymbol != 0)
                return "NONE";

            prevPrevDecodedSymbol = preDecodedSymbol;
            preDecodedSymbol = currentDecodedSymbol;
        }

        return result.toString();
    }

    private int decodeCurrentSymbol(int prevDecodedSymbol, int prevPrevDecodedSymbol, int curEncodedSymbol) {
        return curEncodedSymbol - prevDecodedSymbol - prevPrevDecodedSymbol;
    }
}
