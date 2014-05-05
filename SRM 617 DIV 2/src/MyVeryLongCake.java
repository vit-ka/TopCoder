import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class MyVeryLongCake {
	
	public int cut(int n) {
        int sum = 0;

        for (int i = 1; i <= n; ++i) {
            if (gcd(n, i) != 1) {
                sum++;
            }
        }

        return sum;
	}

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}
