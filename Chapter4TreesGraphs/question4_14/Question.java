/**
    4.14    Convert Sorted List to Balanced Binary Search Tree(BST)
    Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
    (CleanCodeHandbook--30)
    (leetcode109)
    (leetcodecpp5.3.5)
    http://articles.leetcode.com/2010/11/convert-sorted-list-to-balanced-binary.html
 */
package question4_14;

public class Question {

    class Node {
        public int val;

        public Node next;
        public Node left;
        public Node right;

        public Node(int val){
            this.val = val;
        }
    }

    public static Node convert(Node head){
        if(head==null){
            return null;
        } else if(head.next==null){
            return head;
        } else if(head.next.next==null){
            head.right = head.next;
            return head;
        }

        // find the tail of the first-half ll
        // cut the first-half and second-half ll

        int length  = 0;
        Node runner = head;
        while(runner!=null){
            length++;
            runner = runner.next;
        }
        int firstHalfLLLength = (length-1)/2;
        // move to the tail of the first-half ll
        runner = head;
        for(int i=1; i<firstHalfLLLength; i++){
            runner = runner.next;
        }
        Node middleNode = runner.next;
        runner.next = null;
        middleNode.left = convert(head);
        middleNode.right = convert(middleNode.next);

        return middleNode;
    }


    public static void main(String[] args) {

    }

}
