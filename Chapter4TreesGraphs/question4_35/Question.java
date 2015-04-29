/**
    4.35    Clone Graph
    Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
    (CleanCodeHandbook--38)
    (leetcode133)
    (leetcodeCpp14.1)
    http://articles.leetcode.com/2012/05/clone-graph-part-i.html
 */

package question4_35;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import CtCILibrary.UndirectedGraphNode;

public class Question {

    // BFS
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode graph){
        if(graph==null) return null;
        Queue<UndirectedGraphNode> cache = new LinkedList<UndirectedGraphNode>();
        cache.add(graph);
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        UndirectedGraphNode graphCopy = new UndirectedGraphNode(graph.getVertex());
        map.put(graph, graphCopy);
        while(!cache.isEmpty()){
            UndirectedGraphNode node = cache.poll();
            for(UndirectedGraphNode neighbor : node.getNeighbors()){
                if(map.containsKey(neighbor)){
                    map.get(node).addAdjacent(map.get(neighbor));
                } else {
                    UndirectedGraphNode neighborCopy = new UndirectedGraphNode(neighbor.getVertex());
                    map.get(node).addAdjacent(neighborCopy);
                    map.put(neighbor, neighborCopy);
                    cache.add(neighbor);
                }
            }
        }
        return graphCopy;
    }
    

    public static void main(String[] args) {

    }

}
