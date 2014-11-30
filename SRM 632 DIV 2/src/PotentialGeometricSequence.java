public class PotentialGeometricSequence {
	
	public int numberOfSubsequences(int[] d) {
		int number = 0;
		for (int i = 0; i < d.length; i++) {
			for (int j = i; j < d.length; j++) {
				if (isGeometricSequence(d, i, j))
					number++;
			}
		}

		return number;
	}

	private boolean isGeometricSequence(int[] d, int a, int b) {
		if (a == b)
			return true;

		int diff = d[a + 1] - d[a];

		for (int i = a + 1; i < b; ++i) {
			if (d[i + 1] - d[i] != diff) {
				return false;
			}

			diff = d[i + 1] - d[i];
		}

		return true;
	}
}
