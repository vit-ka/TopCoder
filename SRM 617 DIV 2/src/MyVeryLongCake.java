import java.util.ArrayList;
import java.util.List;

public class MyVeryLongCake {
	
	public int cut(int n) {
        long result = n;
        long num = 1;

        List<Integer> primeFactors = getPrimeFactors(n);
        for (int primeFactor : primeFactors) {
            result *= primeFactor - 1;
            num *= primeFactor;
        }

        return (int) (n - result / num);
	}

    private List<Integer> getPrimeFactors(int number) {
        List<Integer> result = new ArrayList<Integer>();

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
