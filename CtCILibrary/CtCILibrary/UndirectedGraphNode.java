package CtCILibrary;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphNode {
    private List<UndirectedGraphNode> neighbors;
    private String vertex;
    
    public UndirectedGraphNode(String vertex){
        this.vertex = vertex;
        this.neighbors = new ArrayList<UndirectedGraphNode>();
    }
    
    public void addAdjacent(UndirectedGraphNode node) {
        this.neighbors.add(node);
    }
    
    public List<UndirectedGraphNode> getNeighbors() {
        return this.neighbors;
    }
    
    public int getNeighborsNumber() {
        return this.neighbors.size();
    }
    
    public String getVertex() {
        return vertex;
    }
    
}
