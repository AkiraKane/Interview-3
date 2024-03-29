/**
    4.2     Depth First Search
    (CareerCups150 - P84)
     
    4.2.1   Binary tree In-order traversal
    Given a binary tree, return the inorder traversal of its nodes' values.
    For example:
    Given binary tree {1,#,2,3},
       1    
         \      
          2     
         /  
       3
    return [1,3,2].
    Note: Recursive solution is trivial, could you do it iteratively?
    confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
    (leetcode94)
    (leetcode5.1.2)
    http://articles.leetcode.com/2010/04/binary-search-tree-in-order-traversal.html
 */
package question4_2;

import CtCILibrary.AssortedMethods;
import CtCILibrary.TreeNode;

public class Question {
    
    public static void travelInOrder(TreeNode node){
        if(node.left!=null){
            travelInOrder(node.left);
        }
        System.out.print(node.data + " ");
        if(node.right!=null){
            travelInOrder(node.right);
        }
    }
    
    
    public static void travelPreOrder(TreeNode node){
        System.out.print(node.data + " ");
        if(node.left!=null){
            travelInOrder(node.left);
        }
        if(node.right!=null){
            travelInOrder(node.right);
        }
    }
    
    public static void travelPostOrder(TreeNode node) {
        if(node.left!=null){
            travelInOrder(node.left);
        }
        if(node.right!=null){
            travelInOrder(node.right);
        }
        System.out.print(node.data + " ");
    }
    
    
    public static void main(String[] args) {
        int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = AssortedMethods.createTreeFromArray(nodes_flattened);
        
        travelInOrder(root);
    }

}
