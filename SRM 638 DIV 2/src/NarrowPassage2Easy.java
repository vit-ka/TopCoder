import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NarrowPassage2Easy {

	public int count(int[] size, int maxSizeSum) {
		return generate(size, size.length, maxSizeSum);
	}

	private int generate(int[] size, int n, int maxSizeSum) {
		Queue<List<Integer>> q = new LinkedList<>();
		HashSet<List<Integer>> visited = new HashSet<>();

		List<Integer> start = IntStream.range(0, n).boxed().collect(Collectors.toList());
		q.add(start);
		visited.add(start);

		while (!q.isEmpty()) {
			List<Integer> curr = q.poll();

			for (int i = 0; i < n - 1; i++) {
				if (size[curr.get(i)] + size[curr.get(i + 1)] <= maxSizeSum) {
					List<Integer> newList = new ArrayList<>(curr);
					exchange(newList, i, i + 1);

					if (!visited.contains(newList)) {
						q.add(newList);
						visited.add(newList);
					}
				}
			}
		}

		return visited.size();
	}

	private void exchange(List<Integer> list, int i1, int i2) {
		int temp = list.get(i1);
		list.set(i1, list.get(i2));
		list.set(i2, temp);
	}
}
