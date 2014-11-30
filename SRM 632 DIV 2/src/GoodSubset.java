import java.util.HashMap;
import java.util.Map;

public class GoodSubset {

	private Map<Pair, Integer> cache = new HashMap<>();

	private static class Pair {
		public int goodValue;
		public int d;

		public Pair(int goodValue, int d) {
			this.goodValue = goodValue;
			this.d = d;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Pair pair = (Pair) o;

			if (d != pair.d) return false;
			if (goodValue != pair.goodValue) return false;

			return true;
		}

		@Override
		public int hashCode() {
			int result = goodValue;
			result = 31 * result + d;
			return result;
		}
	}

	public int numberOfSubsets(int goodValue, int[] d) {
		return numberOfSubsetsRec(d, goodValue, d.length) - (goodValue == 1 ? 1 : 0);
	}

	private int numberOfSubsetsRec(int[] d, int goodValue, int t) {
		Pair pair = new Pair(goodValue, t);

		if (cache.containsKey(pair)) {
			return cache.get(pair);
		}

		if (t == 0) {
			if (goodValue == 1) {
				return 1;
			} else {
				return 0;
			}
		}

		int answer = 0;
		if (goodValue % d[t - 1] == 0) {
			answer += numberOfSubsetsRec(d, goodValue / d[t - 1], t - 1);
		}

		answer += numberOfSubsetsRec(d, goodValue, t - 1);
		answer %= 1000000007;

		cache.put(pair, answer);

		return answer;
	}
}
