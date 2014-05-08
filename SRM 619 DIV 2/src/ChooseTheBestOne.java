import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class ChooseTheBestOne {
	
	public int countNumber(int N) {

        List<Integer> numbers = new ArrayList<Integer>(N);

        for (int i = 1; i <= N; ++i) {
            numbers.add(i);
        }

        long round = 1;
        long indexToRemove = 0;
        while (numbers.size() > 1) {
            indexToRemove = indexToRemove + round * round * round - 1;
            indexToRemove %= numbers.size();

            numbers.remove((int) indexToRemove);
            round++;
        }

        return numbers.get(0);
	}
}
