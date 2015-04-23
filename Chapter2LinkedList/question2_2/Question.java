/**
    2.2 Remove element in Linked List
    Implement an algorithm to delete a node in the middle of a single linked list, given only access to that node 
    EXAMPLE
    Input: the node ‘c’ from the linked list a->b->c->d->e
    Result: nothing is returned, but the new linked list looks like a->b->d->e
    (CareerCups150 - 2.3)
 */

package question2_2;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class Question {
    
    public static boolean deleteNode(LinkedListNode n) {
        if(n==null || n.next==null){
            return false;
        }
        LinkedListNode next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }

    public static void main(String[] args) {
        LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
        System.out.println(head.printForward());
        deleteNode(head.next.next.next.next); // delete node 4
        System.out.println(head.printForward());
    }
}
