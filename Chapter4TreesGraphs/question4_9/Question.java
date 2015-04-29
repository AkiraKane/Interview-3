/**
    4.9     Symmetric Tree
    Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
    For example, this binary tree is symmetric:
    
    But the following is not:
    
    Note:
    Bonus points if you could solve it both recursively and iteratively.
    (leetcode101)
    (leetcodecpp5.1.9)
 */
package question4_9;

import CtCILibrary.TreeNode;

public class Question {
    
    public static boolean isSymmetric(TreeNode node1, TreeNode node2){
        if(node1==null && node2==null){
            return true;
        } else if((node1==null && node2!=null) || (node1!=null && node2==null)){
            return false;
        }
        if(node1==node2){
            return isSymmetric(node1.left, node1.right);
        }
        return (node1.data==node2.data) && isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
    }

    public static void main(String[] args) {
        
    }

}
