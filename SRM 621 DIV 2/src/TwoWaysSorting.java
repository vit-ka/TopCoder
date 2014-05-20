import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class TwoWaysSorting {
	
	public String sortingMethod(String[] stringList) {

        String prevValue = "";
        boolean lexi = true;
        boolean len = true;

        for (String str : stringList) {
            if (prevValue.length() >= str.length())
                len = false;

            if (prevValue.compareTo(str) >= 0)
                lexi = false;

            prevValue = str;
        }

        if (lexi && len)
            return "both";

        if (lexi)
            return "lexicographically";

        if (len)
            return "lengths";


        return "none";
	}
}
