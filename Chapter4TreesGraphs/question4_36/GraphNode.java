package question4_36;

import java.util.ArrayList;
import java.util.List;


public class GraphNode {

    private List<GraphNode> neighbors;
    private String vertex;
    public State state;
    
    public static enum State {
        Unvisited, Visited;
    }
    
    public GraphNode(String vertex){
        this.vertex = vertex;
        this.neighbors = new ArrayList<GraphNode>();
    }
    
    public void addAdjacent(GraphNode node) {
        this.neighbors.add(node);
    }
    
    public List<GraphNode> getNeighbors() {
        return this.neighbors;
    }
    
    public int getNeighborsNumber() {
        return this.neighbors.size();
    }
    
    public String getVertex() {
        return vertex;
    }
    
    

}
