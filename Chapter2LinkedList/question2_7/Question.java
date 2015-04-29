/**
    2.7     Merge K Sorted Linked Lists
    Merge K sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
    (CleanCodeHandbook--23)
    (leetcode23)
    (leetcodecpp6.3)
 */
package question2_7;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import CtCILibrary.LinkedListNode;

public class Question {

    public LinkedListNode mergeKLists(List<LinkedListNode> lists){
        if(lists.isEmpty()) return null;
        Queue<LinkedListNode> minHeap = new PriorityQueue<LinkedListNode>(lists.size(), listComparator);
        
        for(LinkedListNode node : lists){
            if(node!=null){
                minHeap.add(node);
            }
        }
        
        LinkedListNode dummyHead = new LinkedListNode();
        LinkedListNode p = dummyHead;
        while(!minHeap.isEmpty()){
            LinkedListNode node = minHeap.poll();
            p.next=node;
            p=p.next;
            if(node.next!=null){
                minHeap.add(node.next);
            }
        }
        return dummyHead.next;
    }
    
    private static final Comparator<LinkedListNode> listComparator = new Comparator<LinkedListNode>() {
        @Override
        public int compare(LinkedListNode x, LinkedListNode y){
            return x.data - y.data;
        }
    };
    
    public static void main(String[] args) {

    }

}
