/**
    2.9     Intersection of two linked lists
    Write a program to find the node at which the intersection of two singly linked lists begins.
    For example, the following two linked lists:
    A:      a1->a2
                    c1->c2->c3
    
    B:  b1->b2->b3
    
    begin to intersect at node c1.
    Notes:
    If the two linked lists have no intersection at all, return null.
    The linked lists must retain their original structure after the function returns.
    You may assume there are no cycles anywhere in the entire linked structure.
    Your code should preferably run in O(n) time and use only O(1) memory.
    (leetcode160)
 */

package question2_9;

import CtCILibrary.LinkedListNode;

public class Question {

    public static LinkedListNode findIntersectNode(LinkedListNode head1, LinkedListNode head2){
        int length1 = getListLength(head1);
        int length2 = getListLength(head2);
        
        if(length1<length2){
            // head2 move forward
            for(int i=0; i<(length2-length1); i++){
                head2=head2.next;
            }
        } else if(length1>length2){
            // head1 move forward
            for(int i=0; i<(length1-length2); i++){
                head1=head1.next;
            }
        }
        
        while(head1!=null&&head2!=null){
            if(head1==head2){
                return head1;
            }
            head1=head1.next;
            head2=head2.next;
        }
               
        return null;
    }
    
    public static int getListLength(LinkedListNode head){
        int length = 0;
        while(head!=null){
            length++;
            head=head.next;
        }
        return length;
    }
    
    
    public static void main(String[] args) {
        LinkedListNode[] list1Nodes = new LinkedListNode[2];
        for (int i = 0; i < 2; i++) {
            list1Nodes[i] = new LinkedListNode(i, null, i > 0 ? list1Nodes[i - 1] : null);
        }
        LinkedListNode[] list2Nodes = new LinkedListNode[3];
        for(int i=0; i<3; i++){
            list2Nodes[i] = new LinkedListNode(i, null, i > 0 ? list2Nodes[i - 1] : null);
        }
        LinkedListNode[] list3Nodes = new LinkedListNode[3];
        for(int i=0; i<3; i++){
            list3Nodes[i] = new LinkedListNode(i+3, null, i > 0 ? list3Nodes[i - 1] : null);
        }
        
        list1Nodes[1].next = list3Nodes[0];
        list2Nodes[2].next = list3Nodes[0];
        System.out.println(list1Nodes[0].printForward());
        System.out.println(list2Nodes[0].printForward());
        
        LinkedListNode intersectNode = findIntersectNode(list1Nodes[0], list2Nodes[0]);
        System.out.println(intersectNode.data);
    }
}
