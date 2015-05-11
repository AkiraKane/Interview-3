/**
    2.15    Insert into a Cyclic Sorted List
    Given a node from a cyclic linked list which has been sorted, write a function to insert a value into the list such that it remains a cyclic sorted list. The given node can be any single node in the list.
    (leetcode147)
    http://articles.leetcode.com/2011/08/insert-into-a-cyclic-sorted-list.html
 */
package question2_15;

import CtCILibrary.LinkedListNode;

public class Question {

    public static void insert(LinkedListNode node, int val){
        boolean toInsert = false;
        if(node.data <=node.next.data){
            if(node.data<=val && node.next.data>=val){
                toInsert = true;
            }
        } else {
            if(val>=node.data){
                toInsert = true;
            }
        }
        if(toInsert){
            LinkedListNode insertNode = new LinkedListNode();
            insertNode.data = val;
            insertNode.next = node.next;
            node.next = insertNode;
            return;
        }
        insert(node.next, val);
    }
    

    public static void main(String[] args) {

    }

}
