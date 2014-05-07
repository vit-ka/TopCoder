import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoodCompanyDivTwo {
	
	public int countGood(int[] superior, int[] workType) {

        int sum = 0;

        for (int i = 0; i < superior.length; ++i) {
            List<Integer> department = getDepartmentWorkTypesFor(i, superior, workType);

            Collections.sort(department);

            boolean flag = true;
            int previousWorkType = -1;
            for (int emplWorkType : department) {
                if (emplWorkType == previousWorkType) {
                    flag = false;
                }

                previousWorkType = emplWorkType;
            }

            if (flag)
                sum++;
        }

        return sum;
	}

    private List<Integer> getDepartmentWorkTypesFor(int boss, int[] superior, int[] workType) {

        List<Integer> result = new ArrayList<Integer>();

        result.add(workType[boss]);

        for (int i = 0; i < superior.length; ++i) {
            if (superior[i] == boss) {
                result.add(workType[i]);
            }
        }

        return result;

    }
}
