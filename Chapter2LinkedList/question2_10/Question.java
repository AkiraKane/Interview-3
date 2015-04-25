/**
    2.10    Swap Nodes in pairs
    Given a linkedlist, swap every two adjacent nodes and return its head.
    For example,
    Given 1->2->3->4, you should return the list as 2->1->4->3.
    Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
    (CleanCodeHandbook--22)
    (leetcode24)
    (leetcodecpp2.2.8)
 */

package question2_10;

import CtCILibrary.LinkedListNode;

public class Question {

    public static LinkedListNode swapNodes(LinkedListNode head){
        if(head==null){
            return null;
        } else if(head.next==null){
            // only one node left
            return head;
        } 
        // swap the first the second nodes
        LinkedListNode first = head;
        LinkedListNode second = head.next;
        LinkedListNode oldFollowNode = second.next;
        
        LinkedListNode newHead = second;
        newHead.next = first;
        first.next = swapNodes(oldFollowNode);

        return newHead;
    }
    

    public static void main(String[] args) {
        
        
        
        
    }
}
