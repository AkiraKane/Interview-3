/**
    2.13    Rotate list
    Given a list, rotate the list to the right by k places, where k is non-negative.
    For example:
    Given 1->2->3->4->5->NULL and k = 2,
    return 4->5->1->2->3->NULL.
    (leetcode61)
    (leetcodecpp2.2.6)
 */

package question2_13;

import CtCILibrary.LinkedListNode;

public class Question {

    // the question is similar to find the Kth node from the last one
    public static LinkedListNode rotateList(LinkedListNode head, int k){
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        for(int i=0; i<k; i++){
            fast=fast.next;
        }
        
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        LinkedListNode newHead = slow.next;
        fast.next=head;
        slow.next=null;
        
        return newHead;
    }
    
    
    public static void main(String[] args) {
        
    }

}
