public class AliceGameEasy {

	public long findMinimumValue(long x, long y)
	{
		long n = (long) (Math.sqrt(2 * x + 2 * y + 0.25) - 0.5);

		System.out.println(n);

		if (n * (n + 1) / 2 != x + y) {
			return -1;
		}

		long currIndex = n;
		int counter = 0;

		while (x > 0) {
			if (x > currIndex) {
				x -= currIndex;
				counter++;
				currIndex--;
			} else {
				counter++;
				break;
			}
		}

		return counter;
	}
}
