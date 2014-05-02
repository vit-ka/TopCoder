import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class BridgeCrossing {
	
	public int minTime(int[] times) {

        int result = times.length == 1 ? times[0] : getResult(times, new boolean[]{false, false, false, false, false, false}, 0);

        return result;
	}

    private int getResult(int[] times, boolean[] onLeft, int onLeftCount) {
        int minimaxSum = Integer.MAX_VALUE;

        for (int i = 0; i < times.length; ++i) {
            for (int j = i + 1; j < times.length; ++j) {
                if (onLeft[i] || onLeft[j])
                    continue;

                int sum = max(times[i], times[j]);
                onLeft[i] = true;
                onLeft[j] = true;

                if (onLeftCount < times.length - 2) {
                    int goesBackIndex = getMinOnLeftIndex(times, onLeft);

                    boolean backGoesOnLeft = onLeft[goesBackIndex];
                    onLeft[goesBackIndex] = false;
                    sum += times[goesBackIndex];

                    sum += getResult(times, onLeft, onLeftCount + 1);
                    onLeft[goesBackIndex] = backGoesOnLeft;
                }

                onLeft[i] = false;
                onLeft[j] = false;

                if (sum < minimaxSum) {
                    minimaxSum = sum;
                }
            }
        }

        return minimaxSum;
    }

    private int getMinOnLeftIndex(int[] times, boolean[] onLeft) {
        int goesBackIndex = -1;
        int minOnLeft = Integer.MAX_VALUE;

        for (int k = 0; k < times.length; ++k) {
            if (onLeft[k] && times[k] < minOnLeft) {
                minOnLeft = times[k];
                goesBackIndex = k;
            }
        }
        return goesBackIndex;
    }
}
