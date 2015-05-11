/**
    2.16    Sort Linked List
    Sort a linked list in O(n log n) time using constant space complexity.
    (leetcode148)
    (leetcodecpp6.5)
 */
package question2_16;

import CtCILibrary.LinkedListNode;

public class Question {

    public static LinkedListNode mergeSort(LinkedListNode head){
        if(head==null || head.next==null){
            return head;
        }
        
        LinkedListNode firstHalfHead = head;
        // get linkedlist length
        int length = 0;
        LinkedListNode runner = head;
        while(runner!=null){
            length++;
            runner=runner.next;
        }
        int halfLength = length%2==0 ? length/2 : length/2+1;
        runner = head;
        for(int i=0; i<halfLength; i++){
            runner=runner.next;
        }
        LinkedListNode secondHalfHead = runner;

        return merge(firstHalfHead, secondHalfHead);
    }
    
    public static LinkedListNode merge(LinkedListNode firstHalfHead, LinkedListNode secondHalfHead){
        LinkedListNode fakeHead = new LinkedListNode();
        LinkedListNode runner = fakeHead;
        while(firstHalfHead!=null && secondHalfHead!=null){
            if(firstHalfHead.data<=secondHalfHead.data){
                runner.next = firstHalfHead;
                runner = firstHalfHead;
                firstHalfHead=firstHalfHead.next;
            } else {
                runner.next = secondHalfHead;
                runner = secondHalfHead;
                secondHalfHead = secondHalfHead.next;

            }
        }
        if(firstHalfHead!=null){
            runner.next = secondHalfHead;
        } else if(secondHalfHead!=null){
            runner.next = firstHalfHead;
        }
        return fakeHead.next;
    }
    
    
    public static void main(String[] args) {

    }

}
