import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class EmployManager {
	
	public int maximumEarnings(int[] value, String[] earning) {
        int[][] earningParsed = parseEarning(earning);

        long sum = 0;

        for (int[] anEarningParsed : earningParsed) {
            for (int anAnEarningParsed : anEarningParsed)
                sum -= anAnEarningParsed;
        }

        sum /= 2;

        for (int i = 0; i < value.length; ++i) {
            long tempSum = 0;

            for (int j = 0; j < earningParsed[i].length; ++j)
                tempSum += earningParsed[i][j];

            if (tempSum > value[i]) {
                sum += tempSum - value[i];
            }
        }

		return (int) sum;
	}

    private int[][] parseEarning(String[] earning) {
        int[][] result = new int[earning.length][];

        for (int i = 0; i < earning.length; ++i) {
            result[i] = new int[earning[i].length()];
            for (int j = 0; j < earning[i].length(); ++j) {
                result[i][j] = earning[i].charAt(j) - '0';
            }
        }

        return result;
    }
}
