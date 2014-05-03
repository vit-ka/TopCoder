import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class LongWordsDiv1 {

    private static long MOD = 1000000007;

	public int count(int n) {
        long[] dp = new long[5001];

        dp[0] = 1;

        for (int i = 1; i <= n; ++i) {
            // Case 1
            dp[i] = dp[i - 1];

            // Case 2
            for (int p = 1; p + 2 <= i; p++) {
                dp[i] += (dp[i - p - 1] * dp[p]) % MOD;
            }

            dp[i] %= MOD;
        }

        return (int) ((dp[n] * modFactorial(n)) % MOD);
	}

    private long modFactorial(int n) {
        long result = 1;

        for (int i = 2; i <= n; ++i) {
            result = (result * i) % MOD;
        }

        return result;
    }
}
