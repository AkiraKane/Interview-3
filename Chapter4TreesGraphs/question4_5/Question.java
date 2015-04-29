/**
    4.5     Balanced Binary Tree
    Implement a function to check if a tree is balanced. For the purposes of this question, a balanced tree is defined to be a tree such that no two leaf nodes differ in distance from the root by more than one.
    (CareerCups150 - 4.1)
    (CleanCodeHandbook--28)
    (leetcode110)
    (leetcodecpp5.1.10)
 */
package question4_5;

import CtCILibrary.TreeNode;

public class Question {

    public boolean isBalanced(TreeNode root){
        if(root==null){
            return true;
        }
        return Math.abs(maxDepth(root.left)-maxDepth(root.right))<=1 && isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int maxDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
    
    
    public static void main(String[] args) {
        
    }

}
