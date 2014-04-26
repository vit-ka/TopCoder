import static java.lang.Math.*;

public class EllysScrabble {
	
    public String getMin(String letters, int maxDistance) {
        boolean[] used = new boolean[letters.length()];

        String result = "";
        for (int i = 0; i < letters.length(); ++i) {
            // If we are going to lost this letter then just add it to the end of the string.
            if (i - maxDistance >= 0 && !used[i - maxDistance]) {

                result += letters.charAt(i - maxDistance);
                used[i - maxDistance] = true;
            } else {
                // Otherwise find the smallest possible in the range.
                int position = -1;
                int fromIndex = max(0, i - maxDistance);
                int toIndex = min(letters.length() - 1, i + maxDistance);

                for (int j = fromIndex; j <= toIndex; j++) {
                    if (!used[j] && (position == -1 || letters.charAt(position) > letters.charAt(j))) {
                        position = j;
                    }
                }

                result += letters.charAt(position);
                used[position] = true;
            }
        }

        return result;
    }
}
