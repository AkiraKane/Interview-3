/**
    2.14    Reorder List
    Given a singly linked list L: L0→L1→…→Ln-1→Ln,
    reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
    You must do this in-place without altering the nodes' values.
    For example,
    Given {1,2,3,4}, reorder it to {1,4,2,3}.
    (leetcode143)
    (leetcodecpp2.2.13)
 */
package question2_14;

import CtCILibrary.LinkedListNode;

public class Question {

    
    public static LinkedListNode reorder(LinkedListNode head){
        // find the second-half of this linkedlist
        // reverse the second-half
        // merge with the first half
        
        int num = 0;
        LinkedListNode runner = head;
        while(runner!=null){
            num++;
            runner = runner.next;
        }
        runner = head;
        int positionOfSecondHalfHead = (num+1)/2;
        for(int i=1; i<positionOfSecondHalfHead-1; i++){
            runner = runner.next;
        }
        LinkedListNode head2 = runner.next;
        runner.next = null;
        
        // reverse the second-half LL
        head2 = reverse(head2);
        
        return merge(head, head2);
    }
    
    private static LinkedListNode reverse(LinkedListNode head){
        if(head==null || head.next==null){
            return head;
        }
        LinkedListNode first = null;
        LinkedListNode second = head;
        LinkedListNode third = head.next;
        while(second!=null){
            second.next = first;
            if(third!=null){
                first = second;
                second = third;
                third = third.next;
            } else {
                break;
            }
        }
        return second;
    }
    
    private static LinkedListNode merge(LinkedListNode head1, LinkedListNode head2) {
        LinkedListNode runner1 = head1;
        LinkedListNode runner2 = head2;
        while(runner1!=null && runner2!=null){
            LinkedListNode runnerNext1 = runner1.next;
            LinkedListNode runnerNext2 = runner2.next;
            runner1.next = runner2;
            runner2.next = runnerNext1;
            runner1 = runnerNext1;
            runner2 = runnerNext2;
        }
        return head1;
    }
    
    public static void main(String[] args) {

    }

}
