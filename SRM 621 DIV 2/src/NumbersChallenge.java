import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class NumbersChallenge {
	
	public int MinNumber(int[] S) {

        boolean[] canBe = new boolean[100000 * 20 + 1];

        for (int i = 0; i <= (1 << S.length); ++i) {
            int sum = getSum(i, S);
            canBe[sum] = true;
        }

        for (int i = 0; i < canBe.length; ++i)
            if (!canBe[i])
                return i;

        return -1;
	}

    private int getSum(int mask, int[] s) {
        int sum = 0;
        for (int i = 0; i < s.length; i++) {
           if ((mask & (1 << i)) != 0)
               sum += s[i];
        }
        return sum;
    }

}
