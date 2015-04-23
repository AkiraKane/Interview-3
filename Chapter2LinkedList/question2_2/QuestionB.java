/**
    Remove all elements from a linked list of integers that have value val.
    Example
    Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
    Return: 1 --> 2 --> 3 --> 4 --> 5
    (Leetcode203)
 */
package question2_2;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class QuestionB {
    
    public static LinkedListNode removeElements(LinkedListNode head, int val) {
        LinkedListNode newHead = head;
        while(newHead!=null && newHead.data==val){
            newHead = newHead.next;
        }
        if(newHead==null){
            return null;
        }
        LinkedListNode current, runner;
        current=runner=newHead;
        while(current!=null){
            runner=runner.next;
            while(runner!=null && runner.data==val){
                runner=runner.next;
            }
            current.next = runner;
            current = runner;
        }
        return newHead;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
        System.out.println(head.printForward());
        LinkedListNode newHead = removeElements(head, 4);
        System.out.println(newHead.printForward());
    }
}
