/**
    2.4 Partition List
    Write code to partition a linked list around a value x, such as that all nodes less than x, such that all nodes less than x come before all nodes greater than or equal to x.
    (CareerCups150 -- 2.4)
    
    Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
    You should preserve the original relative order of the nodes in each of the two partitions.
    For example,
    Given 1->4->3->2->5->2 and x = 3,
    return 1->2->2->4->3->5.
    (leetcode86)
    (leetcodecpp2.2.3)
    
    Given a list, split it into two sublists — one for the front half, and one for the back half. If the number of elements is odd, the extra element should go in the front list. So FrontBackSplit() on the list {2, 3, 5, 7, 11} should yield the two lists {2, 3, 5} and {7, 11}.
    http://www.leetcode.com/2010/09/splitting-linked-list.html
 */

package question2_4;

import CtCILibrary.LinkedListNode;

public class Question {

    public static LinkedListNode partition(LinkedListNode node, int x){
        
        
        return null;
    }
    
    
    public static void main(String[] args) {
        int[] vals = {1,3,7,5,2,9,4};
        LinkedListNode head = new LinkedListNode(vals[0], null, null);
        LinkedListNode current = head;
        for(int i=1; i<vals.length; i++){
            current = new LinkedListNode(vals[i], null, current);
        }
        System.out.println(head.printForward());
        
        LinkedListNode h = partition(head, 5);
        System.out.println(h.printForward());
    }

}
