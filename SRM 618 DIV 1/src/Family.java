import java.util.*;

public class Family {
	
	public String isFamily(int[] parent1, int[] parent2) {

        Map<Integer, Node> nodes = new HashMap<Integer, Node>();

        // Creates graph of parents.
        for (int i = 0; i < parent1.length; ++i) {
            if (!nodes.containsKey(parent1[i])) {
                Node node = new Node();
                node.index = parent1[i];
                nodes.put(parent1[i], node);
            }

            if (!nodes.containsKey(parent2[i])) {
                Node node = new Node();
                node.index = parent2[i];
                nodes.put(parent2[i], node);
            }

            Node parent1Node = nodes.get(parent1[i]);
            Node parent2Node = nodes.get(parent2[i]);
            parent1Node.linked.add(parent2Node);
            parent2Node.linked.add(parent1Node);
        }

        nodes.remove(-1);

        // Tests if the graph is bipartite.
        for (int i = 0; i < parent1.length; ++i) {
            if (nodes.containsKey(i) && nodes.get(i).color == -1) {
                if (!dfs(nodes, i, 0)) {
                    return "Impossible";
                }
            }
        }

        return "Possible";
	}

    private boolean dfs(Map<Integer, Node> nodes, int currentNodeIndex, int color) {
        if (nodes.get(currentNodeIndex).color == -1) {
            Node currentNode = nodes.get(currentNodeIndex);
            currentNode.color = color;

            for (Node linkedNode : currentNode.linked) {
                if (linkedNode.color == color) {
                    return false;
                }

                if (linkedNode.color == -1) {
                    if (!dfs(nodes, linkedNode.index, color == 0 ? 1 : 0)) {
                        return false;
                    }
                }
            }

            return true;
        } else {
            return nodes.get(currentNodeIndex).color != color;
        }
    }

    private static class Node {
        int index;
        int color = -1;
        Set<Node> linked = new HashSet<Node>();
    }

}
