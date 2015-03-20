/**
 * 2.2  Implement an algorithm to find the kth to last element of a single linked list. 
 * (CareerCups150 - 2.2)
 * 
 */

package question2_2;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class Question {
    
    public static LinkedListNode nthToLast(LinkedListNode head, int n){
        if(head==null) return null;
        LinkedListNode runner = head;
        for(int i=0; i<n;i++){
            runner=runner.next;
            if(runner==null){
                return null;
            }
        }
        LinkedListNode current = head;
        while(runner.next!=null){
            current=current.next;
            runner=runner.next;
        }
        return current;
    }
    
    public static void main(String[] args) {
        LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
        System.out.println(head.printForward());
        int nth = 3;
        LinkedListNode n = nthToLast(head, nth);
        if(n==null){
            System.out.println("Null...n is out of bounds.");
        }else{
            System.out.println(nth+"th to last node is "+n.data);
        }
        
    }

}
