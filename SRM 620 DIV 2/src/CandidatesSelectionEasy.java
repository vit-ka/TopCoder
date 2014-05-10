import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class CandidatesSelectionEasy {

    public int[] sort(String[] score, int x) {


        final int xTemp = x;
        List<C> list = new ArrayList<C>();

        int index = 0;
        for (String str : score) {
            C c = new C();
            c.index = index++;
            c.str = str;

            list.add(c);
        }

        Collections.sort(list, new Comparator<C>() {
            @Override
            public int compare(C o1, C o2) {
                int result = o1.str.charAt(xTemp) - o2.str.charAt(xTemp);

                if (result == 0) {
                    return o1.index - o2.index;
                }

                return result;
            }
        });

        int[] result = new int[score.length];

        for (int i = 0; i < score.length; i++) {
            result[i] = list.get(i).index;
        }

        return result;
    }

    public class C {
        public String str;
        public int index;
    }
}
