/**
    4.15    Convert Binary Search Tree(BST) to Sorted Doubly Linked List
    Consider a simple node-like data structure called BiNode, which has pointers to two other nodes.
    The data structure BiNode could be used to represent both a binary tree (where node1 is the left node and node2 is the right node) or a doubly linked list(where node1 is the previous node and node2 is the next node).
    Implement a method to convert a binary search tree (implemented with BiNode) into a doubly linked list.
    The values should be kept in order and the operation should be performed in place (that is, on the original data structure).
    (CareerCups150 - 17.13)
    http://articles.leetcode.com/2010/11/convert-binary-search-tree-bst-to.html
 */
package question4_15;

public class Question {

    class BiNode {
        public int val;
        public BiNode prev;
        public BiNode next;

        public BiNode(int val){
            this.val = val;
        }
    }

    public static void convert(BiNode root){
        if(root==null){
            return;
        }

        BiNode leftChild = root.prev;
        BiNode leftSideLargetNode = largestNode(leftChild);
        BiNode rightChild = root.next;
        BiNode rightSideSmallestNode = smallestNode(rightChild);
        root.prev = leftSideLargetNode;
        if(leftSideLargetNode!=null){
            leftSideLargetNode.next = root;
        }
        root.next = rightSideSmallestNode;
        if(rightSideSmallestNode!=null){
            rightSideSmallestNode.prev = root;
        }
        convert(leftChild);
        convert(rightChild);
    }

    public static BiNode largestNode(BiNode root) {
        if(root==null){
            return null;
        }
        BiNode largestNode = root;
        while(largestNode.next!=null){
            largestNode = largestNode.next;
        }
        return largestNode;
    }

    public static BiNode smallestNode(BiNode root){
        if(root==null){
            return null;
        }
        BiNode smallestNode = root;
        while(smallestNode.prev!=null){
            smallestNode = smallestNode.prev;
        }
        return smallestNode;
    }

    public static void main(String[] args) {

    }

}
