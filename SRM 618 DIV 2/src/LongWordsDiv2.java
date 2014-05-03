import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class LongWordsDiv2 {
	
	public String find(String word) {

        if (findDoubles(word))
            return "Dislikes";

        if (findXYXYPattern(word))
            return "Dislikes";

        return "Likes";
	}

    private boolean findXYXYPattern(String word) {
        Set<Character> allChars = new HashSet<Character>();

        for (char c : word.toCharArray()) {
            allChars.add(c);
        }

        for (char c1 : allChars) {
            for (char c2 : allChars) {
                char[] pattern = new char[]{c1,c2,c1,c2};

                int lastIndex = -2;
                for (char aPattern : pattern) {
                    lastIndex = word.indexOf(aPattern, lastIndex + 1);
                    if (lastIndex < 0)
                        break;
                }

                if (lastIndex > 0)
                    return true;
            }
        }

        return false;
    }

    private boolean findDoubles(String word) {
        char prevLetter = '0';

        for (char c : word.toCharArray()) {
            if (c == prevLetter)
                return true;
            prevLetter = c;
        }

        return false;
    }
}
