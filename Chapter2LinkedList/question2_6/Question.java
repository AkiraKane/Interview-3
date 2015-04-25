/**
    2.6     Merge two sorted lists
    Merge two sorted lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
    (CleanCodeHandbook--20)
    (leetcode21)
    (leetcodecpp6.2)
 */

package question2_6;

import CtCILibrary.LinkedListNode;

public class Question {
    
    public static LinkedListNode mergeTwoLists(LinkedListNode l1, LinkedListNode l2){
        LinkedListNode head = null;
        if(l1!=null&&l2!=null){
            if(l1.data<l2.data){
                head = l1;
                l1=l1.next;
            } else {
                head = l2;
                l2=l2.next;
            }
        }
        LinkedListNode runner = head;
        while(l1!=null && l2!=null){
            if(l1.data<l2.data){
                runner.next = l1;
                l1 = l1.next;
            } else {
                runner.next = l2;
                l2 = l2.next;
            }
            runner = runner.next;
        }
        if(l1!=null){
            runner.next = l1;
        } else if(l2!=null){
            runner.next = l2;
        }
        return head;
    }
    

    public static void main(String[] args) {
        LinkedListNode lA1 = new LinkedListNode(1, null, null);
        LinkedListNode lA2 = new LinkedListNode(3, null, lA1);
        LinkedListNode lA3 = new LinkedListNode(5, null, lA2);
        System.out.println("list1: " + lA1.printForward());      
        
        LinkedListNode lB1 = new LinkedListNode(1, null, null);
        LinkedListNode lB2 = new LinkedListNode(5, null, lB1);
        LinkedListNode lB3 = new LinkedListNode(9, null, lB2);  
        System.out.println("list2: " + lB1.printForward());
        
        LinkedListNode list3 = mergeTwoLists(lA1, lB1);
        System.out.println("list3: " + list3.printForward());
    }

}
