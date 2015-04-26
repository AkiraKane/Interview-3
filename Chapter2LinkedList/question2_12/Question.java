/**
    2.12    Reverse Linked List
    Reverse a linked list from position m to n. Do it in-place and in one-pass.
    For example:
    Given 1->2->3->4->5->NULL, m = 2 and n = 4,
    return 1->4->3->2->5->NULL.
    Note:
    Given m, n satisfy the following condition:
    1 ≤ m ≤ n ≤ length of list.
    (leetcode92)
    (leetcodecpp2.2.2)
    http://www.leetcode.com/2010/04/reversing-linked-list-iteratively-and.html
 */

package question2_12;

import CtCILibrary.LinkedListNode;

public class Question {

    public static LinkedListNode reverseLL(LinkedListNode head, int m, int n){
        // find the node just before m
        LinkedListNode nodeBeforeM;
        LinkedListNode nodeM;
        if(m<=1){
            nodeBeforeM=null;
            nodeM=head;
        } else {
            nodeBeforeM=head;
            for(int i=1; i<m-1; i++){
                nodeBeforeM=nodeBeforeM.next;
                if(nodeBeforeM==null){
                    return null;
                }
            }
            nodeM=nodeBeforeM.next;
        }
        
        // find the node just after n
        LinkedListNode nodeAfterN = head;
        LinkedListNode nodeN = head;
        for(int i=1; i<n; i++) {
            nodeN=nodeN.next;
            if(nodeN==null) {
                return null;
            }
        }
        nodeAfterN=nodeN.next;
        
        // now reverse nodes from m to n
        LinkedListNode first = null;
        LinkedListNode second = nodeM;
        LinkedListNode third = nodeM.next;
        for(int i=0;i<=(n-m);i++){
            second.next=first;
            first=second;
            second=third;
            third=third.next;
        }
        if(nodeBeforeM!=null){
            nodeBeforeM.next=nodeN;
        }
        nodeM.next=nodeAfterN;
        
        return head;
    }
    
    
    public static void main(String[] args) {
        
        
        
        
    }

}
