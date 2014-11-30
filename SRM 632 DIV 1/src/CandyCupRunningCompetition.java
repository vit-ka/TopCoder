import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CandyCupRunningCompetition {
	
	public int findMaximum(int N, int[] A, int[] B) {
		long res = 0;

		List<Queue<Integer>> g = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			g.add(new LinkedList<>());
		}

		for (int i = A.length - 1; i >= 0; i--) {
			Queue<Integer> bQ = g.get(B[i]);
			bQ.add(A[i]);
			g.set(B[i], bQ);

			Queue<Integer> aQ = g.get(A[i]);
			aQ.add(B[i]);
			g.set(A[i], aQ);

			if (isConnected(g)) {
				res += powModulo(i);
				bQ.poll();
				aQ.poll();
			}
		}

		return (int) (res % 1000000007);
	}

	private long powModulo(int pow) {
		long mod = 1000000007;

		long result = 1;

		for (int i = 0; i < pow; i++) {
			result = (result * 3) % mod;
		}

		return result;
	}

	private boolean isConnected(List<Queue<Integer>> g) {
		int n = g.size();

		boolean[] visited = new boolean[n];
		visited[0] = true;

		Queue<Integer> q = new LinkedList<>();
		q.add(0);

		while (!q.isEmpty()) {
			int curr = q.poll();

			g.get(curr).stream().filter(adj -> !visited[adj]).forEach(adj -> {
				q.add(adj);
				visited[adj] = true;
			});
		}

		return visited[n - 1];
	}
}
