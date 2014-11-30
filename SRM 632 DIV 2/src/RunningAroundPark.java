public class RunningAroundPark {
	
	public int numberOfLap(int N, int[] d)
	{
		int laps = 1;

		for (int i = 0; i < d.length - 1; i++) {
			if (d[i] >= d[i + 1]) {
				laps++;
			}
		}

		return laps;
	}
}
