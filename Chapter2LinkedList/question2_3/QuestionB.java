/**
    Remove Nth Node from end of list
    Given a linked list, remove the nth node from the end of list and return its head.
    For example,
    Given linked list: 1->2->3->4->5, and n = 2.     
    After removing the second node from the end, the linked list becomes 1->2->3->5.
    Note:
    Given n will always be valid.
    Try to do this in one pass.
    (leetcode19)
    (leetcodecpp2.2.7)
 */

package question2_3;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class QuestionB {

    public static void removeNthToLast(LinkedListNode head, int n){
        if(head==null) return;
        LinkedListNode runner = head;
        for(int i=0; i<n;i++){
            runner=runner.next;
            if(runner==null){
                return;
            }
        }
        LinkedListNode current = head;
        LinkedListNode last = null;
        while(runner.next!=null){
            last = current;
            current=current.next;
            runner=runner.next;
        }
        
        // remvove the current node
        last.next = current.next;
    }
    
    public static void main(String[] args) {
        LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
        System.out.println(head.printForward());
        int nth = 3;
        removeNthToLast(head, nth);
        System.out.println(head.printForward());
    }
}
