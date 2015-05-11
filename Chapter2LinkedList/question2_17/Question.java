/**
    2.17    Insertion Sort linked list
    Sort a linked list using insertion sort.
    (leetcodecpp6.4)
 */
package question2_17;

import CtCILibrary.LinkedListNode;

public class Question {

    public static LinkedListNode insertionSort(LinkedListNode head){
        LinkedListNode fakeSortedHead = new LinkedListNode();
        LinkedListNode sortedRunner = fakeSortedHead;
        LinkedListNode fakeHead = new LinkedListNode();
        fakeHead.next = head;
        while(fakeHead.next!=null){
            LinkedListNode node = fakeHead; // this node's next is the smallest in the unsorted LL
            LinkedListNode runner = fakeHead.next;
            while(runner.next!=null){
                if(runner.next.data<node.next.data){
                    node=runner;
                    runner=runner.next;
                }
            }
            // move the smallest node to sorted LL
            sortedRunner.next = node.next;
            node.next = node.next.next;
            sortedRunner=sortedRunner.next;
            sortedRunner.next=null;
        }
        return fakeSortedHead.next;
    }

    public static void main(String[] args) {

    }

}
