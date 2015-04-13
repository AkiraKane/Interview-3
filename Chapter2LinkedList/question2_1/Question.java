/**
    2.1     Write code to remove duplicates from an unsorted linked list
    FOLLOW UP
    How would you solve this problem if a temporary buffer is not allowed?
    (CareerCup150 - 2.1) 
    Given a sorted linked list, delete all duplicates such that each element appear only once.
    For example,
    Given 1->1->2, return 1->2.
    Given 1->1->2->3->3, return 1->2->3.
    (leetcode83)
    (leetcode2.2.4)
    
    Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
    For example,
    Given 1->2->3->3->4->4->5, return 1->2->5.
    Given 1->1->1->2->3, return 2->3.
    (leetcode82)
    (leetcode2.2.5)
 */

package question2_1;

import java.util.HashSet;

import CtCILibrary.LinkedListNode;

public class Question {
    
    // Method A, using buffer
    public static void deleteDupsA(LinkedListNode n){
        if(n==null){
            return;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        LinkedListNode previous = n.prev;
        while(n!=null){
            if(set.contains(n.data)){
                previous.next = n.next;
            } else {
                set.add(n.data);
                previous = n;
            }
            n = n.next;
        }
    }
    
    // Method B, not using buffer
    public static void deleteDupsB(LinkedListNode n){
        if(n==null){
            return;
        }
        
        while(n!=null){
            LinkedListNode current = n;
            LinkedListNode runner = n.next;
            while(runner!=null){
                if(runner.data==n.data){
                    current.next=runner.next;
                } else {
                    current=runner;
                }
                runner=runner.next;
            }
            n=n.next;
        }
    }
    
    public static void main(String[] args) {
        LinkedListNode first = new LinkedListNode(0, null, null);
        LinkedListNode head = first;
        LinkedListNode second = null;
        for(int i=1; i<8;i++){
            second=new LinkedListNode(i%2, null, null);
            first.setNext(second);
            second.setPrevious(first);
            first = second;
        }
        System.out.println(head.printForward());
        LinkedListNode clone = head.clone();
        deleteDupsA(head);
        System.out.println(head.printForward());
        deleteDupsB(clone);
        System.out.println(clone.printForward());
    }
}