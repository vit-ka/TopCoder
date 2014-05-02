public class CCipher {
	
	public String decode(String cipherText, int shift)
    {
        String result = "";
        for (int i = 0; i < cipherText.length(); ++i) {
            result += decodeLetter(cipherText.charAt(i), shift);
        }

		return result;
	}

    private char decodeLetter(char c, int shift) {
        int codePoint = ((c - 'A') + 26 - shift) % 26 + 'A';
        return (char) codePoint;
    }
}
