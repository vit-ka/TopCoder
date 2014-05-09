import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoodCompanyDivOne {
	
	public int minimumCost(int[] superior, int[] training) {
        Arrays.sort(training);

        int sum = 0;

        for (int i = 0; i < superior.length; ++i) {
            List<Integer> department = getDepartment(i, superior);

            if (department.size() >= training.length)
                return -1;

            sum += training[0];

            for (int j = 1; j <= department.size(); ++j) {
                sum += training[j];
            }
        }

        return sum;
    }

    private List<Integer> getDepartment(int boss, int[] superior) {

        List<Integer> result = new ArrayList<Integer>();

        result.add(boss);

        for (int i = 0; i < superior.length; ++i) {
            if (superior[i] == boss) {
                result.add(i);
            }
        }

        return result;

    }
}
