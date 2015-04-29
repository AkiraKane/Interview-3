/**
    4.6     Maximum Height(Depth) of a Binary Tree
    Given a binary tree, find its maximum depth.
    The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
    (CleanCodeHandbook--26)
    (leetcode104)
    (leetcodecpp5.4.2)
 */
package question4_6;

import CtCILibrary.TreeNode;

public class Question {

    public int maxDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
    
    
    public static void main(String[] args) {

    }

}
