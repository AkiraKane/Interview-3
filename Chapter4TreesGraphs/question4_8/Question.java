/**
    4.8     Same Tree
    Given two binary trees, write a function to check if they are equal or not.
    Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
    (leetcode100)
    (leetcodecpp5.1.8)
 */
package question4_8;

import CtCILibrary.TreeNode;

public class Question {

    public static boolean sameTree(TreeNode root1, TreeNode root2){
        if((root1==null && root2!=null) || (root1!=null && root2==null)){
            return false;
        } else if(root1==null && root2==null){
            return true;
        }
        return (root1.data==root2.data) && sameTree(root1.left, root2.left) && sameTree(root1.right, root2.right);
    }
    
    
    
    public static void main(String[] args) {

    }

}
