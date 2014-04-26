import java.util.Arrays;

public class EllysSortingTrimmer {
	
	public String getMin(String S, int L) {

        String result = S;

        while (result.length() != L) {
            String pref = result.substring(0, result.length() - L);
            String suff = result.substring(result.length() - L);

            suff = sortString(suff);

            result = pref + suff;
            result = result.substring(0, result.length() - 1);
        }

        result = sortString(result);

        return result;
	}

    private String sortString(String result) {
        char[] letters = result.toCharArray();
        Arrays.sort(letters);
        result = String.valueOf(letters);
        return result;
    }


}
