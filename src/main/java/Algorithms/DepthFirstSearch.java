package Algorithms;

import App.Graph;
import App.Node;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch{

	private Graph graph;
	public String name = "";
	public int length = 0;
	public DepthFirstSearch(Graph graph) {
		this.graph = graph;
	}

	public boolean search(String from, String to) {

		Node fromNode = graph.getNode(from);
		Node toNode = graph.getNode(to);
		
		if(fromNode == null || toNode == null) {
			return false;
		}
		List<Node> queue = new ArrayList<>();
		queue.add(fromNode);
		
		while(!queue.isEmpty()) {
			Node testNode = queue.get(0);
			queue.remove(0);
			
			testNode.isTested = true;
			name += testNode.name + "-";
			length++;

			if(testNode.name.equals(to)) {
				return true;
			}

			List<Node> relatedNodes = testNode.getRelatedNodes();
			for(Node el : relatedNodes) {
				if(!el.isTested && !queue.contains(el)) {
					queue.add(0, el);
				}
			}			
		}
		return false;
	}
}
