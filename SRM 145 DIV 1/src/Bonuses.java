import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class Bonuses {
	
	public int[] getDivision(int[] points) {
		int sum = 0;

        for (int point : points) {
            sum += point;
        }

        int[] result = new int[points.length];

        for (int i = 0; i < result.length; ++i) {
            result[i] = (points[i] * 100) / sum;
        }

        int totalPercentage = 0;
        for (int perc : result) {
            totalPercentage += perc;
        }

        totalPercentage = 100 - totalPercentage;

        while (totalPercentage > 0) {
            int index = 0;
            int maxPoint = 0;

            for (int i = 0; i < result.length; ++i) {
                if (points[i] > maxPoint) {
                    index = i;
                    maxPoint = points[i];
                }
            }

            result[index]++;
            points[index] = 0;
            --totalPercentage;
        }

        return result;
	}
}
