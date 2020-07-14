package App;

import java.util.HashMap;
import java.util.Map;

public class Graph {
    private HashMap<String, Node> graph = new HashMap<>();

    public HashMap<String, Node> getAllNodes(){
        return graph;
    }

    public void addNode(Node node) {
        if(node == null || node.name.trim().isEmpty()) {
            throw new NullPointerException("Cannot be null");
        }

        if(!graph.containsKey(node.name)) {
            graph.put(node.name, node);
        }else {
            throw new IllegalArgumentException("Try add another node");
        }
    }

    public Node getNode(String name) {
        return graph.get(name);
    }

    public void addLink(String nodeNameFrom, String nodeNameTo, boolean isBiDirectional) {
        Node nodeFrom = graph.get(nodeNameFrom);
        Node nodeTo = graph.get(nodeNameTo);

        if(nodeFrom == null || nodeTo == null) {
            throw new NullPointerException("Null node");
        }

        try {
            nodeFrom.addLink(new Link(nodeTo));
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(isBiDirectional)
            try {
                nodeTo.addLink(new Link(nodeFrom));
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public void resetGraph() {
        for(Map.Entry<String, Node> keyValuePair : graph.entrySet()) {
            keyValuePair.getValue().isTested = false;
            keyValuePair.getValue().depth = -1;
        }
    }
}
