import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class MyLongCake {
	
	public int cut(int n) {
		Set<Integer> result = new HashSet<Integer>();

        for (int i = 2; i < n; ++i) {
            if (n % i == 0) {
                for (int j = 1; j < n / i; ++j) {
                    result.add(i * j);
                }
            }
        }

        return result.size() + 1;
	}
}
