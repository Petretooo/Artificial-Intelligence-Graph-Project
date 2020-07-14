package App;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public String name;
    public double weight;
    public double x;
    public double y;
    public boolean isTested;
    public int depth = -1;
    public double distanceToEnd;

    List<Link> links;

    public Node(String name, double x, double y, double weight) {
        this.name = name;
        links = new ArrayList<>();
        this.x = x;
        this.y  = y;
        this.weight = weight;
    }

    public void addLink(Link link) {

        if(link == null) {
            throw new NullPointerException("Null node");
        }

        links.add(link);
    }

    public List<Node> getRelatedNodes(){
        List<Node> nodes = new ArrayList<>();

        for(Link link : links) {
            if(!nodes.contains(link.relatedNode))
                nodes.add(link.relatedNode);
        }

        return nodes;
    }
}
