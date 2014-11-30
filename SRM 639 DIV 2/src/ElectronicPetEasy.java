import java.util.HashSet;
import java.util.Set;

public class ElectronicPetEasy {
	
	public String isDifficult(int st1, int p1, int t1, int st2, int p2, int t2) {
		Set<Integer> firstPetFeedingTimes = new HashSet<>();

		for (int i = 0; i < t1; i++) {
			firstPetFeedingTimes.add(st1 + p1 * i);
		}

		for (int i = 0; i < t2; i++) {
			if (firstPetFeedingTimes.contains(st2 + p2 * i))
				return "Difficult";
		}

		return "Easy";
	}
}
