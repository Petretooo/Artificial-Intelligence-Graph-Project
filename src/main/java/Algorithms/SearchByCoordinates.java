package Algorithms;

import App.Graph;
import App.Node;

import java.util.ArrayList;
import java.util.List;

public class SearchByCoordinates{

	private Graph graph;
	private double destinationByX;
	private double destinationByY;

	public String name = "";
	public int length = 0;
	
	public SearchByCoordinates(Graph graph) {
		this.graph = graph;
	}

	public boolean search(String from, String to) {
		graph.resetGraph();
		
		Node fromNode = graph.getNode(from);
		Node toNode = graph.getNode(to);
		
		if(fromNode == null || toNode == null) {
			throw new NullPointerException("Null node");
		}
		
		destinationByX = toNode.x;
		destinationByY = toNode.y;
		
		List<Node> queue = new ArrayList<>();
		
		queue.add(fromNode);
		fromNode.depth = 0;
		
		while(!queue.isEmpty()) {
			Node testNode = queue.remove(0);
			testNode.isTested = true;

			name += testNode.name + "-";
			length++;
			
			if(testNode.name.equals(to)) {
				return true;
			}
			
			List<Node> relatedNodes = testNode.getRelatedNodes();
			
			for(Node el : relatedNodes) {
				addNode(el, queue);
			}			
		}	
		
		return false;
	}


	private void addNode(Node childNode, List<Node> queue) {
		if(childNode.isTested || queue.contains(childNode)) {
			return;
		}
		
		childNode.distanceToEnd = calculateDistance(childNode.x, childNode.y);
			
		for(int i = 0; i < queue.size(); i++) {
			if(childNode.distanceToEnd < queue.get(i).distanceToEnd) {
				queue.add(i, childNode);
				return;
			}
		}
		
		queue.add(childNode);
	}
	
	private double calculateDistance(double x, double y) {
		double a = Math.abs(x - destinationByX);
		double b = Math.abs(y - destinationByY);
		
		double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
		
		return c;		
	}

}
