import java.util.Comparator;

public class Node implements Comparator<Node> {
	public int nextNode;
	public int nodeCost;
	
	public Node() {
		this.nextNode = 0;
		this.nodeCost = 0;
	}

	public Node(int node, int cost) {
		this.nextNode = node;
		this.nodeCost = cost;
	}

	@Override
	public int compare(Node node1, Node node2) {
		return Integer.compare(node1.nodeCost, node2.nodeCost);
	}
}