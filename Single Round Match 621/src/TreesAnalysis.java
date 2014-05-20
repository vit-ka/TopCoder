import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class TreesAnalysis {

    int[][] treeA = new int[4000][4000];
    int[][] treeB = new int[4000][4000];

	public long treeSimilarity(int[] tree1, int[] tree2) {

        for (int i = 0; i < tree1.length; ++i) {
            treeA[i][tree1[i]] = 1;
            treeA[tree1[i]][i] = 1;
            treeB[tree2[i]][i] = 1;
            treeB[i][tree2[i]] = 1;
        }

        long totalSum = 0;
        for (int i = 0; i < tree1.length; ++i) {
            for (int j =  0; j < tree2.length; ++j) {
                long localSum = evalLocalSum(tree1, tree2, i, j);
                totalSum += localSum * localSum;
            }
        }

        return totalSum;
	}

    private long evalLocalSum(int[] tree1, int[] tree2, int i, int j) {
        Set<Integer> setA1 = evalSet(treeA, tree1, i, new HashSet<Integer>());
        Set<Integer> setA2 = evalSet(treeA, tree1, i, setA1);
        Set<Integer> setB1 = evalSet(treeB, tree2, j, new HashSet<Integer>());
        Set<Integer> setB2 = evalSet(treeB, tree2, j, setB1);

        long max = 0;
        Set<Integer> intersection = new HashSet<Integer>(setA1);
        intersection.retainAll(setB1);

        if (intersection.size() > max) {
            max = intersection.size();
        }

        intersection = new HashSet<Integer>(setA1);
        intersection.retainAll(setB2);

        if (intersection.size() > max) {
            max = intersection.size();
        }

        intersection = new HashSet<Integer>(setA2);
        intersection.retainAll(setB1);

        if (intersection.size() > max) {
            max = intersection.size();
        }

        intersection = new HashSet<Integer>(setA2);
        intersection.retainAll(setB2);

        if (intersection.size() > max) {
            max = intersection.size();
        }

        return max;
    }

    private Set<Integer> evalSet(int[][] tree, int[] nodes, int i, Set<Integer> doNotContainsIn) {
        Set<Integer> result = new HashSet<Integer>();
        int[] visited = new int[nodes.length + 1];

        Queue<Integer> queue = new PriorityQueue<Integer>();

        int start = -1;

        for (int k = 0; k <= nodes.length; ++k) {
            if (!doNotContainsIn.contains(k)) {
                start = k;
                break;
            }
        }

        if (start == -1)
            return result;

        queue.add(start);
        result.add(start);
        visited[start] = 1;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            int linked = nodes[current];

            if (!(linked == i && current == nodes[i]) && ! (linked == nodes[i] && current == i) &&  visited[linked] != 1) {
                queue.add(linked);
                result.add(linked);
                visited[linked] = 1;
            }
        }

        return result;
    }
}
