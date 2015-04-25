/**
    2.8     Linked List Cycle
    Given a linked list, determine if it has a cycle in it. Follow up: Can you solve it without using extra space?
    (leetcode141)
    (leetcodecpp2.2.11)
     
    Given a circular linked list, implement an algorithm, which returns node at the beginning of the loop.
    Definition: Circular linked list: A (corrupt) linked list in which a node’s next pointer points to an earlier node, so as to make a loop in the linked list.
    Example
    Input: A->B->C->D->E->C [the same C as earlier]
    Output: C
    (CareerCups150 -- 2.6)
    (leetcode142)
    (leetcodecpp2.2.12)
    http://articles.leetcode.com/2010/09/detecting-loop-in-singly-linked-list.html
 */

package question2_8;

import CtCILibrary.LinkedListNode;

public class Question {

    public static LinkedListNode findBeginning(LinkedListNode head){
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        
        // find the meeting point
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                break;
            }
        }
        
        if(fast==null || fast.next==null){
            return null;
        }
        
        slow=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return fast;
    }
    
    public static void main(String[] args) {
        int list_length = 10;
        int k = 3;
        
        // Create linked list
        LinkedListNode[] nodes = new LinkedListNode[list_length];
        for (int i = 0; i < list_length; i++) {
            nodes[i] = new LinkedListNode(i, null, i > 0 ? nodes[i - 1] : null);
        }
        
        // Create loop;
        nodes[list_length - 1].next = nodes[list_length - k];
        
        LinkedListNode loop = findBeginning(nodes[0]);
        if (loop == null) {
            System.out.println("No Cycle.");
        } else {
            System.out.println(loop.data);
        }
    }
}
