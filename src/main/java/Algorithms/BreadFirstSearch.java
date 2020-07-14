package Algorithms;

import App.Graph;
import App.Node;

import java.util.ArrayList;
import java.util.List;

public class BreadFirstSearch{

	private Graph graph;
	public String name = "";
	public int length = 0;
	public BreadFirstSearch(Graph graph) {
		this.graph = graph;
	}

	public boolean search(String from, String to) {
		Node fromNode = graph.getNode(from);
		Node toNode = graph.getNode(to);
		if(fromNode == null || toNode == null) {
			return false;
		}
		fromNode.depth = 0;
		List<Node> queue = new ArrayList<>();
		queue.add(fromNode);

		while(!queue.isEmpty()) {
			Node testNode = queue.get(0);
			queue.remove(0);

			testNode.isTested = true;
			//name += testNode.name + "-";
			//length++;

			if(testNode.name.equals(to)) {
				name(testNode);
				return true;
			}

			List<Node> relatedNodes = testNode.getRelatedNodes();
			for(Node el : relatedNodes) {
				if(el.depth == -1){
					el.depth = testNode.depth + 1;
				}
				if(!el.isTested && !queue.contains(el)) {
					queue.add(el);
				}
			}

		}

		return false;
	}

	private void name(Node el){
		name += el.name + "-";
		length++;

		List<Node> nodes = el.getRelatedNodes();

		for (Node el1 : nodes){
			if (el1.depth < el.depth){
				name(el1);
				return;
			}
		}
	}

}
