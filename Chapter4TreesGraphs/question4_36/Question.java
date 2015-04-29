/**
    4.36    Given a directed graph, design an algorithm to find out whether there is a route between two nodes. 
    (CareerCups150 - 4.2)
 */
package question4_36;

import java.util.LinkedList;

public class Question {

    // BFS
    public static boolean search(GraphNode start, GraphNode end) {
        
        LinkedList<GraphNode> q = new LinkedList<GraphNode>();
        q.add(start);
        
        while(!q.isEmpty()){
            GraphNode node = q.poll();
            if(node==end){
                return true;
            } else{
                node.state = GraphNode.State.Visited;
            }
            if(node!=null){
                for(GraphNode neighbor : node.getNeighbors()){
                    if(neighbor.state == GraphNode.State.Unvisited){
                        q.add(neighbor);
                    }
                }
            }
        }
        return false;
    }
    
    

    public static void main(String[] args) {

    }
}
