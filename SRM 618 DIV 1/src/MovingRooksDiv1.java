import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class MovingRooksDiv1 {
	
	public int[] move(int[] Y1, int[] Y2) {
        int n = Y1.length;
        List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < n; ++i) {
            if (Y2[i] > Y1[i])
                return new int[]{-1};

            for (int j = i + 1; j < n; ++j) {
                if (Y2[i] <= Y1[j] && Y1[j] <= Y1[i]) {
                    int temp = Y1[j];
                    Y1[j] = Y1[i];
                    Y1[i] = temp;

                    result.add(i);
                    result.add(j);
                }
            }
        }

        int[] resultInt = new int[result.size() > 2500 ? 2500 : result.size()];

        for (int i = 0; i < resultInt.length; ++i) {
            resultInt[i] = result.get(i);
        }

        return resultInt;
    }
}
