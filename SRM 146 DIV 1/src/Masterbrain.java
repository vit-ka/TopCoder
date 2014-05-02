public class Masterbrain {
	
	public int possibleSecrets(String[] guesses, String[] results) {

        int total = 0;
        for (int i = 1; i < 8; ++i) {
            for (int j = 1; j < 8; ++j) {
                for (int k = 1; k < 8; ++k) {
                    for (int l = 1; l < 8; ++l) {

                        int number = i * 1000 + j * 100 + k * 10 + l;
                        if (checkAgainstAllGuesses(number, guesses, results)) {
                            System.out.println(String.format("Passed: %s", number));
                            total++;
                        }
                    }
                }
            }
        }

        return total;
	}

    private boolean checkAgainstAllGuesses(int number, String[] guesses, String[] results) {
        int passedCount = 0;

        for (int i = 0; i < guesses.length; ++i) {
            if (checkAgainstGuess(Integer.toString(number), guesses[i], results[i]))
                passedCount++;
        }

        return passedCount == guesses.length - 1;
    }

    private boolean checkAgainstGuess(String number, String guess, String result) {
        int black = 0, white = 0;
        boolean[] used = new boolean[4];
        boolean[] guessUsed = new boolean[4];

        for (int i = 0; i < number.length(); ++i) {
            if (number.charAt(i) == guess.charAt(i)) {
                black++;
                used[i] = true;
                guessUsed[i] = true;
            }
        }

        for (int i = 0; i < number.length(); ++i) {
            for (int j = 0; j < guess.length(); ++j) {
                if (i != j && number.charAt(i) == guess.charAt(j) && !used[i] && !guessUsed[j]) {
                    white++;
                    used[i] = true;
                    guessUsed[j] = true;
                }
            }
        }

        int resultBlack = Integer.valueOf(result.substring(0, 1));
        int resultWhite = Integer.valueOf(result.substring(3, 4));

        return resultBlack == black && resultWhite == white;
    }
}
