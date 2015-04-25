/**
    2.11    Reverse Nodes in k-Group
    Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
    If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
    You may not alter the values in the nodes, only nodes itself may be changed.
    Only constant memory is allowed.
    For example,
    Given this linked list: 1->2->3->4->5
    For k = 2, you should return: 2->1->4->3->5
    For k = 3, you should return: 3->2->1->4->5
    (leetcode25)
    (leetcodecpp2.2.9)
 */

package question2_11;

import CtCILibrary.LinkedListNode;

public class Question {

    public static LinkedListNode reverse(LinkedListNode head, int k){
        
        LinkedListNode runner = head;
        int count = 0;
        while(runner!=null){
            count++;
            if(count>=k){
                break;
            }
            runner=runner.next;
        }
        if(count<k){
            // less than K nodes left
            return head;
        }
        

        LinkedListNode newLast = head;
        LinkedListNode newHead = runner;
        // reverse k nodes starting from head node
        
        LinkedListNode first = null;
        LinkedListNode second = head;
        LinkedListNode third = head.next;
        for(int i=0; i<k; i++){
            second.next=first;
            first = second;
            second = third;
            third = third.next;
        }
        
        newLast.next = reverse(third, k);
        return newHead;
    }
    
    
    public static void main(String[] args) {
        
        
        
    }

}
