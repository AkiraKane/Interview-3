/**
    4.11    Write an algorithm to find the ‘next’ node (e g , in-order successor) of a given node in a binary search tree where each node has a link to its parent. 
    (CareerCups150 -- 4.6)
 */
package question4_11;

import CtCILibrary.TreeNode;

public class Question {
    
    public static TreeNode inorderSuccessor(TreeNode n){
        if(n==null){
            return null;
        }
        
        if(n.right!=null){
            // go to right child and go left most
            return leftMostChild(n.right);
        } else {
            TreeNode q = n;
            TreeNode x = q.parent;
            while(x!=null && x.left!=q){
                q=x;
                x=x.parent;
            }
            return x;
        }
    }
    
    public static TreeNode leftMostChild(TreeNode n){
        if(n==null){
            return null;
        }
        while(n.left!=null){
            n = n.left;
        }
        return n;
    }
    
    
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);
        for (int i = 0; i < array.length; i++) {
            TreeNode node = root.find(array[i]);
            TreeNode next = inorderSuccessor(node);
            if (next != null) {
                System.out.println(node.data + "->" + next.data);
            } else {
                System.out.println(node.data + "->" + null);
            }
        }
    }
}
