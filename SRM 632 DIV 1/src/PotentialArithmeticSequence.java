public class PotentialArithmeticSequence {
	
	public int numberOfSubsequences(int[] d) {

        int[] dNormalized = new int[d.length];

        for (int i = 0; i < d.length; ++i) {
            dNormalized[i] = Math.min(6, d[i]);
        }

        StringBuilder patternStringBuilder = new StringBuilder("0 1 0");

        for (int i = 2; i <= 6; ++i) {
            String patternAtStep = patternStringBuilder.toString();
            patternStringBuilder.append(" ").append(i).append(" ").append(patternAtStep);
        }

        String patternString = patternStringBuilder.toString();

        int ans = 0;
        for (int i = 0; i < d.length; ++i) {
            for (int j = i; j < d.length; ++j) {
                boolean isCon = isContiguousSeq(dNormalized, i, j, patternString);
                ans += isCon ? 1 : 0;
                System.out.println(String.format("[%s,%s]=>%s [%s]", i, j, isCon, ans));

            }
        }

        return ans;
	}

    private boolean isContiguousSeq(int[] d, int i, int j, String pattern) {
        if (i == j)
            return true;

        StringBuilder ourStringBuilder = new StringBuilder();

        for (int index = i; index <= j; ++index) {
            ourStringBuilder.append(d[index]);

            if (index != j)
                ourStringBuilder.append(" ");
        }

        String ourString = ourStringBuilder.toString();

        return pattern.contains(ourString);
    }
}
