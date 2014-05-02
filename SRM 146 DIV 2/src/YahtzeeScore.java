import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class YahtzeeScore {
	
	public int maxPoints(int[] toss) {

        Set<Integer> choises = new HashSet<Integer>();

        for (int tossI : toss) {
            choises.add(tossI);
        }

        int max = 0;

        for (int tossI : choises) {
            int sum = 0;
            for (int i = 0; i < toss.length; ++i) {
                if (toss[i] == tossI) {
                    sum += toss[i];
                }
            }

            if (sum > max) {
                max = sum;
            }
        }

		return max;
	}
}
