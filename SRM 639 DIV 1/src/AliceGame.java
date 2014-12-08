public class AliceGame {
	
	public long findMinimumValue(long x, long y) {
		long z = Math.round(Math.sqrt(x + y));

		if (z * z != x + y) {
			return -1;
		}

		long alice = x;
		long currValue = 2 * z - 1;
		long currIndex = 0;

		while (alice > 0 && currValue > 0) {
			if (alice > currValue) {
				alice -= currValue;
				currValue -= 2;
				currIndex++;
			} else {
				if (alice % 2 == 0) {
					return currIndex + 2;
				} else {
					return currIndex + 1;
				}
			}
		}

		return 0;
	}
}
