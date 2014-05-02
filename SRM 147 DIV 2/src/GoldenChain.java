import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class GoldenChain {
	
	public int minCuts(int[] sections) {
        Arrays.sort(sections);

        int openedLinks = 0;
        int sectionCount = sections.length;
        int shortestSectionIndex = 0;

        while (openedLinks < sectionCount) {
            if (sections[shortestSectionIndex] > 0) {
                sections[shortestSectionIndex]--;
                openedLinks++;
            } else {
                shortestSectionIndex++;
                sectionCount--;
            }
        }

        return openedLinks;
	}
}
