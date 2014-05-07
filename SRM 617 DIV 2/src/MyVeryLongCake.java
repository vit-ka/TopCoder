import java.util.HashSet;
import java.util.Set;

public class MyVeryLongCake {
	
	public int cut(int n) {
        long result = n;
        long num = 1;

        Set<Integer> primeFactors = getPrimeFactors(n);
        for (int primeFactor : primeFactors) {
            result *= primeFactor - 1;
            num *= primeFactor;
        }

        return (int) (n - result / num);
	}

    private Set<Integer> getPrimeFactors(int number) {
        Set<Integer> result = new HashSet<Integer>();

        for (int i = 1; i <= number / i; i++) {
            if (number % i == 0) {
                if (isSimple(i))
                    result.add(i);
                if (isSimple(number / i))
                    result.add(number / i);
            }
        }

        return result;
    }

    private boolean isSimple(int number) {
        if (number == 1)
            return false;

        for (int i = 2; i <= number / i; i++) {
            if (number % i == 0)
                return false;
        }

        return true;
    }
}
