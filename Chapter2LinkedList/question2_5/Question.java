/**
    2.5     Add two numbers
    You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1’s digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.
    EXAMPLE:
    Input: (3 -> 1 -> 5), (5 -> 9 -> 2)
    Output: 8 -> 0 -> 8
    FOLLOW UP
    Suppose the digits are stored in forward order. Repeat the above problem.
    EXAMPLE:
    Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).
    Output: 9 -> 1 ->2.  That is, 912.
    (CareerCups150 - 2.5)
     
    You are given two linked lists representing two non-negative numbers. The digits are stored in reverse old and each of their nodes contains a single digit. Add the two numbers and return it as a linked list.
    Input: (2->4->3)+(5->6->4)
    Ouput: 7->0->8
    (CleanCodeHandbook--21)
    (leetcode2)
    (leetcodecpp2.2.1)
 */
package question2_5;

import CtCILibrary.LinkedListNode;

public class Question {

    public static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry){
        if(l1==null && l2==null && carry==0){
            return null;
        }
        LinkedListNode result = new LinkedListNode();
        int value = 0;
        value += carry;
        if(l1!=null){
            value+=l1.data;
        }
        if(l2!=null){
            value+=l2.data;
        }
        result.data = value%10;
        
        LinkedListNode more = addLists(l1==null?null:l1.next, l2==null?null:l2.next, value>=10?1:0);
        result.setNext(more);

        return result;
    }
    

    public static void main(String[] args) {
        LinkedListNode lA1 = new LinkedListNode(3, null, null);
        LinkedListNode lA2 = new LinkedListNode(1, null, lA1);
        LinkedListNode lA3 = new LinkedListNode(6, null, lA2);
        
        LinkedListNode lB1 = new LinkedListNode(5, null, null);
        LinkedListNode lB2 = new LinkedListNode(9, null, lB1);
        LinkedListNode lB3 = new LinkedListNode(2, null, lB2);  
        
        LinkedListNode list3 = addLists(lA1, lB1, 0);
        
        System.out.println("  " + lA1.printForward());
        System.out.println("+ " + lB1.printForward());
        System.out.println("= " + list3.printForward());
    }

}
