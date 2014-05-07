import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class GoodCompanyDivTwo {
	
	public int countGood(int[] superior, int[] workType) {
		Map<Integer, Map<Integer, Integer>> workTypeToDepartment = new HashMap<Integer, Map<Integer, Integer>>();

        for (int i = 0; i < superior.length; ++i) {
            int superE = superior[i];
            int work = workType[i];

            if (!workTypeToDepartment.containsKey(superE)) {
                workTypeToDepartment.put(superE, new HashMap<Integer, Integer>());
            }

            if (!workTypeToDepartment.get(superE).containsKey(work)) {
                workTypeToDepartment.get(superE).put(work, 0);
            }

            if (!workTypeToDepartment.containsKey(i)) {
                workTypeToDepartment.put(i, new HashMap<Integer, Integer>());
            }

            if (!workTypeToDepartment.get(i).containsKey(work)) {
                workTypeToDepartment.get(i).put(work, 0);
            }

            workTypeToDepartment.get(superE).put(work, workTypeToDepartment.get(superE).get(work) + 1);
            workTypeToDepartment.get(i).put(work, workTypeToDepartment.get(superE).get(work) + 1);
        }

        int sum = 0;
        for (Map<Integer, Integer> workTypes : workTypeToDepartment.values()) {
            boolean flag = true;
            for (int numberOfWorkPerDepartment : workTypes.values()) {
                if (numberOfWorkPerDepartment > 1) {
                    flag = false;
                }
            }

            if (flag)
                sum++;
        }

        return sum;
	}
}
